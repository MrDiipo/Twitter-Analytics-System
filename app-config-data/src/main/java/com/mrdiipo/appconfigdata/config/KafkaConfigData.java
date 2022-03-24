package com.mrdiipo.appconfigdata.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "kafka-config")
public class KafkaConfigData {

    private String bootstrapService;
    private String schemaRegistryUrlKey;
    private String schemaRegistryKey;
    private String topicName;
    private List<String> topicNamesToCreate;
    private Integer numOfPartitions;
    private Short replicationFactor;
    
}
