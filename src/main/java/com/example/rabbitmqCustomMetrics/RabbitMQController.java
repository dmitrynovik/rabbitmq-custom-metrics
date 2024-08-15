package com.example.rabbitmqCustomMetrics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.rabbitmqCustomMetrics.models.rabbitmq.MaxLenPolicyUtilisation;
import com.example.rabbitmqCustomMetrics.services.MetricsService;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class RabbitMQController {

	private final MetricsService metricsService;

	public RabbitMQController(MetricsService metricsService) {	
		this.metricsService = metricsService;
	}

	@GetMapping("/rabbitmq/queue/utilization")
	public MaxLenPolicyUtilisation[] index() throws URISyntaxException, IOException, InterruptedException {
		return this.metricsService.getQueueUtilizationMetrics();
	}
}
