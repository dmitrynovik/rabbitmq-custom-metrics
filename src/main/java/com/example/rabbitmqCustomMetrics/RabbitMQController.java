package com.example.rabbitmqCustomMetrics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.rabbitmqCustomMetrics.config.LokiConfig;
import com.example.rabbitmqCustomMetrics.config.RabbitMQConfig;
import com.example.rabbitmqCustomMetrics.models.rabbitmq.MaxLenPolicyUtilisation;
import com.example.rabbitmqCustomMetrics.services.LokiService;
import com.example.rabbitmqCustomMetrics.services.RabbitMQService;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.Charset;
import java.util.Base64;

@RestController
public class RabbitMQController {

	private final RabbitMQConfig rabbitMQConfig;
	private final LokiConfig lokiConfig;
	private static final Logger log = LoggerFactory.getLogger(RabbitMQController.class);
	private RestTemplate restTemplate;
	private HttpClient httpClient;
	private RabbitMQService rabbitMQService;
	private Logger lokiLogger;
	private LokiService lokiService;

	public RabbitMQController(RabbitMQConfig rabbitMQConfig, LokiConfig lokiConfig, RestTemplate restTemplate, 
		RabbitMQService rabbitMQService, LokiService lokiService) {
			
		this.rabbitMQConfig = rabbitMQConfig;
		this.lokiConfig = lokiConfig;
		this.restTemplate = restTemplate;
		this.rabbitMQService = rabbitMQService;
		this.lokiService = lokiService;
		this.httpClient = HttpClient.newHttpClient();

		this.lokiLogger = lokiService.createLokiLogger(lokiConfig);
	}

	@GetMapping("/")
	public MaxLenPolicyUtilisation[] index() throws URISyntaxException, IOException, InterruptedException {
		final String uri = rabbitMQConfig.getConnectionString() + "/api/queues";
		log.info("HTTP GET " + uri);

		HttpRequest request = HttpRequest.newBuilder()
			.GET()
			.uri(new URI(uri))
			.header("Authorization", getBasicAuthenticationHeader())
			.build();

		HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
		String payload = response.body();
		//log.info(payload);
		MaxLenPolicyUtilisation[] utilisations = rabbitMQService.readJson(payload);
		lokiLogger.info(lokiService.getQueueUtilisationLogFmt("/", "NONAME", 0));
		
		return utilisations;
		//ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		//return response.getBody();
	}

	private final String getBasicAuthenticationHeader() {
		String valueToEncode = rabbitMQConfig.getUserName() + ":" + rabbitMQConfig.getPassword();
		return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
	}

}
