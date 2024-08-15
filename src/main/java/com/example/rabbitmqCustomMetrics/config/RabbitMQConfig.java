package com.example.rabbitmqCustomMetrics.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "rabbitmq")
public class RabbitMQConfig {
    
    private String userName;
    private String password; 
    private String host;
    private int httpPort;
    private String schema;
    
    public String getConnectionString() {
        return schema + "://" + host + ":" + httpPort;
    }

    public String getUserName() { return userName; }
    public String getPassword() { return password; }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getHttpPort() {
        return httpPort;
    }

    public void setHttpPort(int httpPort) {
        this.httpPort = httpPort;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
}
