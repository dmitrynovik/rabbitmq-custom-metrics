package com.example.rabbitmqCustomMetrics;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.client.RestTemplate;

import com.example.rabbitmqCustomMetrics.services.MetricsService;

@SpringBootApplication
//@EnableConfigurationProperties
//@EnableAutoConfiguration
public class Application {

	//private final MetricsService metricsService;

	public Application(/*MetricsService metricsService*/) {
		//this.metricsService = metricsService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	// @EventListener(ApplicationReadyEvent.class)
	// public void onReady() throws URISyntaxException, IOException, InterruptedException {
    // 	metricsService.startPoller();
	// }
}
