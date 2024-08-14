package com.example.rabbitmqCustomMetrics.models.rabbitmq;

public record MaxLenPolicyUtilisation (String vhost, String queue, float utilisation){}