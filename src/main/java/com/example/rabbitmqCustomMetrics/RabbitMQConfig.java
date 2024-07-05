package com.example.rabbitmqCustomMetrics;

import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class RabbitMQConfig {
    
    // TODO: read from configuration
    private String userName = "admin";
    private String password = "admin"; 
    private String host = "172.18.255.200";
    private int port = 15672;
    private String schema = "http";
    
    public String getConnectionString() {
        return schema + "://" + userName + ":" + password + "@" + host + ":" + port;
    }
}
