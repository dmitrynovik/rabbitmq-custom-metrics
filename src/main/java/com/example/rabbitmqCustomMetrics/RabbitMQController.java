package com.example.rabbitmqCustomMetrics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.rabbitmqCustomMetrics.models.rabbitmq.MaxLenPolicyUtilisation;
import com.example.rabbitmqCustomMetrics.services.RabbitMQService;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class RabbitMQController {

	private RabbitMQService rabbitMQService;

	public RabbitMQController(RabbitMQService rabbitMQService) {	
		this.rabbitMQService = rabbitMQService;
	}

	@GetMapping("/rabbitmq/queue/utilization")
	public MaxLenPolicyUtilisation[] index() throws URISyntaxException, IOException, InterruptedException {
		return this.rabbitMQService.getQueueUtilizationMetrics();
	}
}
