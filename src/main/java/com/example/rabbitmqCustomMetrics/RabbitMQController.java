package com.example.rabbitmqCustomMetrics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {

	@GetMapping("/queue-size-limits")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
