package com.example.rabbitmqCustomMetrics.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.example.rabbitmqCustomMetrics.config.MetricsServiceConfig;
import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class MetricsService {
	
	private RabbitMQService rabbitMQService;
    private boolean polling;
    private MetricsServiceConfig metricsServiceConfig;

	public MetricsService(MetricsServiceConfig metricsServiceConfig, 
		RabbitMQService rabbitMQService, LokiService lokiService) throws URISyntaxException, IOException, InterruptedException {	
        this.metricsServiceConfig = metricsServiceConfig;
		this.rabbitMQService = rabbitMQService;
        
        startPoller();
	}

    public void startPoller() throws URISyntaxException, IOException, InterruptedException {
        polling = true;
        doPoll();
    }

    @Async
    private void doPoll() throws URISyntaxException, IOException, InterruptedException {
        while (polling) {
            rabbitMQService.getQueueUtilizationMetrics();
            Thread.sleep(metricsServiceConfig.getSleepInterval());
        }
    }

    public void stopPoller() {
        polling = false;
    }
}
