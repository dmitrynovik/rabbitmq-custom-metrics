package com.example.rabbitmqCustomMetrics.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.rabbitmqCustomMetrics.config.RabbitMQConfig;
import com.example.rabbitmqCustomMetrics.models.rabbitmq.MaxLenPolicyUtilisation;
import com.example.rabbitmqCustomMetrics.models.rabbitmq.api.queues.Effective_policy_definition;
import com.example.rabbitmqCustomMetrics.models.rabbitmq.api.queues.QueueResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Base64;
import java.util.stream.Stream;

@Service
public class RabbitMQService {

    private final RabbitMQConfig rabbitMQConfig;
    private final HttpClient httpClient;
    private final LokiService lokiService;
    private static final Logger log = LoggerFactory.getLogger(RabbitMQService.class);

    public RabbitMQService(RabbitMQConfig rabbitMQConfig, LokiService lokiService) {
        this.rabbitMQConfig = rabbitMQConfig;
        this.httpClient = HttpClient.newHttpClient();
        this.lokiService = lokiService;
    }

    private final ObjectMapper mapper = new ObjectMapper()
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    public MaxLenPolicyUtilisation[] getQueueMaxLengthUtilization(String payload) throws JsonMappingException, JsonProcessingException, IOException {
        QueueResponse[] queues = mapper.readValue(payload, QueueResponse[].class);

        return Stream.of(queues)
            .map(RabbitMQService::convertToQueueMaxLengthUtilization)
            .toArray(MaxLenPolicyUtilisation[]::new);
    }

    public static MaxLenPolicyUtilisation convertToQueueMaxLengthUtilization(QueueResponse queue) {
        Effective_policy_definition policy = queue.getEffective_policy_definition();
        float utilisation = 0;

        if (policy != null) {
            // check utilisation as no. of messages:
            long maxLength = policy.getMaxLength();
            if (maxLength > 0) {
                utilisation = queue.getMessages() / maxLength;
            }
            
            // check utlisation as no. of bytes:
            long maxLengthBytes = policy.getMaxLengthBytes();
            if (maxLengthBytes > 0) {
                float utilisationBytes = queue.getMessage_bytes() / maxLengthBytes;
                utilisation = Math.max(utilisation, utilisationBytes);
            }
        }

        return new MaxLenPolicyUtilisation(queue.getVhost(), queue.getName(), utilisation);
    }

    public MaxLenPolicyUtilisation[] getQueueUtilizationMetrics() throws URISyntaxException, IOException, InterruptedException {
		final String uri = rabbitMQConfig.getConnectionString() + "/api/queues";
		log.info("HTTP GET " + uri);

		HttpRequest request = createHttpRequest(uri);

		HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
		String payload = response.body();
		//log.info(payload);
		MaxLenPolicyUtilisation[] utilisations = getQueueMaxLengthUtilization(payload);
		lokiService.logQueueUtilisationLogFmt(utilisations);
		return utilisations;
	}

	private HttpRequest createHttpRequest(final String uri) throws URISyntaxException {
		return HttpRequest.newBuilder()
			.GET()
			.uri(new URI(uri))
			.header("Authorization", getBasicAuthenticationHeader())
			.build();
	}

	private final String getBasicAuthenticationHeader() {
		String valueToEncode = rabbitMQConfig.getUserName() + ":" + rabbitMQConfig.getPassword();
		return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
	}
}
