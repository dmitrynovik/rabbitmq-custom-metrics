package com.example.rabbitmqCustomMetrics.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "loki")
public class LokiConfig {
    
    private String host;
    
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    private int port;
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    private String schema;
    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    private String tenant;

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getConnectionString() {
        return schema + "://" + host + ":" + port + "/loki/api/v1/push";
    }

    public String getTenantId() {
        return tenant;
    }

    public String getServiceName() {
        return "rabbitmq-queue-limits";
    }
}
