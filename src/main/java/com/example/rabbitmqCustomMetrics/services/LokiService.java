package com.example.rabbitmqCustomMetrics.services;

import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.rabbitmqCustomMetrics.config.LokiConfig;
import com.github.loki4j.logback.HttpSender;
import com.github.loki4j.logback.JavaHttpSender;
import com.github.loki4j.logback.Loki4jAppender;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;

@Service
public class LokiService {
    public Logger createLokiLogger(LokiConfig lokiConfig) {
        LoggerContext ctx = (LoggerContext) LoggerFactory.getILoggerFactory();

        Loki4jAppender lokiAppender = new Loki4jAppender();
        JavaHttpSender httpSender = new JavaHttpSender();
        httpSender.setUrl(lokiConfig.getConnectionString());
        httpSender.setTenantId(lokiConfig.getTenantId());

        lokiAppender.setContext(ctx);
        lokiAppender.setHttp(httpSender);
        lokiAppender.setBatchMaxItems(1);
        lokiAppender.start();

        Logger logger = (Logger) LoggerFactory.getLogger("LOKI");
        logger.addAppender(lokiAppender);
        logger.setLevel(Level.INFO);
        logger.setAdditive(false);
        return logger;
    }
}
