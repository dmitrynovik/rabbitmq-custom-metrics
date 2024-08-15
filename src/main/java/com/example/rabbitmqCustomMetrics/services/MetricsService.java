package com.example.rabbitmqCustomMetrics.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.rabbitmqCustomMetrics.RabbitMQController;
import com.example.rabbitmqCustomMetrics.config.LokiConfig;
import com.example.rabbitmqCustomMetrics.config.RabbitMQConfig;
import com.example.rabbitmqCustomMetrics.models.rabbitmq.MaxLenPolicyUtilisation;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Base64;

@Service
public class MetricsService {
    private final RabbitMQConfig rabbitMQConfig;
	private static final Logger log = LoggerFactory.getLogger(RabbitMQController.class);
	private HttpClient httpClient;
	private RabbitMQService rabbitMQService;
	private LokiService lokiService;
    private boolean polling;

	public MetricsService(RabbitMQConfig rabbitMQConfig, LokiConfig lokiConfig, RestTemplate restTemplate, 
		RabbitMQService rabbitMQService, LokiService lokiService) throws URISyntaxException, IOException, InterruptedException {	
		this.rabbitMQConfig = rabbitMQConfig;
		this.rabbitMQService = rabbitMQService;
		this.lokiService = lokiService;
		this.httpClient = HttpClient.newHttpClient();

        this.startPoller();
	}

    public void startPoller() throws URISyntaxException, IOException, InterruptedException {
        polling = true;
        doPoll();
    }

    @Async
    private void doPoll() throws URISyntaxException, IOException, InterruptedException {
        while (polling) {
            getQueueUtilizationMetrics();
            Thread.sleep(10000); // TODO: config
        }
    }

    public void stopPoller() {
        polling = false;
    }

	public MaxLenPolicyUtilisation[] getQueueUtilizationMetrics() throws URISyntaxException, IOException, InterruptedException {
		final String uri = rabbitMQConfig.getConnectionString() + "/api/queues";
		log.info("HTTP GET " + uri);

		HttpRequest request = createHttpRequest(uri);

		HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
		String payload = response.body();
		//log.info(payload);
		MaxLenPolicyUtilisation[] utilisations = rabbitMQService.getQueueMaxLengthUtilization(payload);
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
