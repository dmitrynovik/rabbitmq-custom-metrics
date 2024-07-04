package com.example.rabbitmqCustomMetrics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {

	private final RabbitMQConfig rabbitMQConfig;
	private final LokiConfig lokiConfig;

	public RabbitMQController(RabbitMQConfig rabbitMQConfig, LokiConfig lokiConfig) {
		this.rabbitMQConfig = rabbitMQConfig;
		this.lokiConfig = lokiConfig;

	}

	@GetMapping("/queue-size-limits")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
