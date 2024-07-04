package com.example.rabbitmqCustomMetrics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {

	private RabbitMQConfig rabbitMQConfig;

	public RabbitMQController(RabbitMQConfig rabbitMQConfig) {
		this.rabbitMQConfig = rabbitMQConfig;

	}

	@GetMapping("/queue-size-limits")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
