package com.example.rabbitmqCustomMetrics.services;

import org.springframework.stereotype.Service;

import com.example.rabbitmqCustomMetrics.models.rabbitmq.MaxLenPolicyUtilisation;
import com.example.rabbitmqCustomMetrics.models.rabbitmq.api.queues.Effective_policy_definition;
import com.example.rabbitmqCustomMetrics.models.rabbitmq.api.queues.QueueResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.stream.Stream;

@Service
public class RabbitMQService {

    private final ObjectMapper mapper = new ObjectMapper()
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    public MaxLenPolicyUtilisation[] readJson(String payload) throws JsonMappingException, JsonProcessingException, IOException {
        QueueResponse[] queues = mapper.readValue(payload, QueueResponse[].class);

        return Stream.of(queues)
            .map(RabbitMQService::convert)
            .toArray(MaxLenPolicyUtilisation[]::new);
    }

    private static MaxLenPolicyUtilisation convert(QueueResponse queue) {
        Effective_policy_definition policy = queue.getEffective_policy_definition();
        float utilisation = 0;

        if (policy != null) {
            long maxLength = policy.getMaxLength();
            if (maxLength > 0) {
                utilisation = queue.getMessages() / maxLength;
            }

            long maxLengthBytes = policy.getMaxLengthBytes();
            if (maxLengthBytes > 0) {
                float utilisationMax = queue.getMessage_bytes() / maxLengthBytes;
                utilisation = Math.max(utilisation, utilisationMax);
            }
        }

        return new MaxLenPolicyUtilisation(queue.getName(), utilisation);
    }
}
