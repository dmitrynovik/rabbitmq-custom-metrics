package com.example.rabbitmqCustomMetrics.models.rabbitmq.api.queues;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class Effective_policy_definition {
    private long maxLength, maxLengthBytes;

    @JsonGetter("max-length-bytes")
    public long getMaxLengthBytes() {
        return maxLengthBytes;
    }

    @JsonSetter("max-length-bytes")    
    public void setMaxLengthBytes(long maxLengthBytes) {
        this.maxLengthBytes = maxLengthBytes;
    }

    @JsonGetter("max-length")
    public long getMaxLength() {
        return maxLength;
    }

    @JsonSetter("max-length")
    public void setMaxLength(long maxLength) {
        this.maxLength = maxLength;
    }

    // max-length
    // max-length-bytes
}
