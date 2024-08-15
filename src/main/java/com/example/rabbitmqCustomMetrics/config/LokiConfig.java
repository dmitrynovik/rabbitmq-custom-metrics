package com.example.rabbitmqCustomMetrics.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "loki")
public class LokiConfig {

    // public LokiConfig(@Value("${loki.host}") String host, 
    //     @Value("${loki.port}") int port, 
    //     @Value("${loki.schema}") String schema, 
    //     @Value("${loki.tenant}") String tenant) {
    //     this.host = host;
    //     this.port = port;
    //     this.schema = schema;
    //     this.tenant = tenant;
    // }
    
    private String host;// = "172.18.255.205";
    
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    private int port;// = 3100;
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    private String schema;// = "http";
    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    private String tenant;// = "myorg";

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
