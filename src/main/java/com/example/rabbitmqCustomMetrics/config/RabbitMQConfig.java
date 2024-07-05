package com.example.rabbitmqCustomMetrics.config;

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
        return schema + "://" + host + ":" + port;
        //return schema + "://" + userName + ":" + password + "@" + host + ":" + port;
    }

    public String getUserName() { return userName; }
    public String getPassword() { return password; }
}
