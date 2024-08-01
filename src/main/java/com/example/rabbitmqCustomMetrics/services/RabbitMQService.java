package com.example.rabbitmqCustomMetrics.services;

import org.springframework.stereotype.Service;

import com.example.rabbitmqCustomMetrics.models.rabbitmq.api.queues.QueueResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

@Service
public class RabbitMQService {

    private final ObjectMapper mapper = new ObjectMapper()
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    public QueueResponse[] readJson(String payload) throws JsonMappingException, JsonProcessingException, IOException {
        return mapper.readValue(payload, QueueResponse[].class);
    }
}
