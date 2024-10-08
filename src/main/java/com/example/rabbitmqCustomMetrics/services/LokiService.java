package com.example.rabbitmqCustomMetrics.services;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.rabbitmqCustomMetrics.config.LokiConfig;
import com.example.rabbitmqCustomMetrics.models.rabbitmq.MaxLenPolicyUtilisation;
import com.github.loki4j.logback.JavaHttpSender;
import com.github.loki4j.logback.JsonEncoder;
import com.github.loki4j.logback.Loki4jAppender;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;

@Service
public class LokiService {

    private final Logger lokiLogger;

    public LokiService(LokiConfig lokiConfig) {
        this.lokiLogger = createLokiLogger(lokiConfig);
    }

    private Logger createLokiLogger(LokiConfig lokiConfig) {
        LoggerContext ctx = (LoggerContext) LoggerFactory.getILoggerFactory();

        Loki4jAppender lokiAppender = new Loki4jAppender();
        JavaHttpSender httpSender = new JavaHttpSender();
        httpSender.setUrl(lokiConfig.getConnectionString());
        httpSender.setTenantId(lokiConfig.getTenantId());

        lokiAppender.setContext(ctx);
        lokiAppender.setHttp(httpSender);
        lokiAppender.setBatchMaxItems(1);

        JsonEncoder encoder = new JsonEncoder();
        encoder.getLabel().setPattern("service_name=" + lokiConfig.getServiceName());
        lokiAppender.setFormat(encoder);

        lokiAppender.start();

        Logger logger = (Logger) LoggerFactory.getLogger("LOKI");
        logger.addAppender(lokiAppender);
        logger.setLevel(Level.INFO);
        logger.setAdditive(false);
        return logger;
    }

    public String getQueueUtilisationLogFmt(MaxLenPolicyUtilisation utilisation) {
        return getQueueUtilisationLogFmt(utilisation.vhost(), utilisation.queue(), utilisation.utilisation());
    }

    public String getQueueUtilisationLogFmt(String vhost, String queueName, float utilisation) {
        return String.format("vhost=\"%s\" queue=\"%s\" utilize=%f", vhost, queueName, utilisation);
    }

    public void logQueueUtilisationLogFmt(MaxLenPolicyUtilisation[] utilisations) {
        for (MaxLenPolicyUtilisation u : utilisations) {
            lokiLogger.info( getQueueUtilisationLogFmt(u));
        }
    }
}
