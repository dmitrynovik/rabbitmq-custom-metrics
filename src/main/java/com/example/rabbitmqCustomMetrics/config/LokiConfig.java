package com.example.rabbitmqCustomMetrics.config;

import java.util.*;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class LokiConfig {
    
    // TODO: read from configuration
    private String host = "172.18.255.206";
    private int port = 3100;
    private String schema = "http";
    private String tenant = "myorg";

    private Map<String, String> headers = Map.of(
        "X-Scope-OrgID", tenant
    );

    public String getConnectionString() {
        return schema + "://" + host + ":" + port + "/loki/api/v1/push";
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}
