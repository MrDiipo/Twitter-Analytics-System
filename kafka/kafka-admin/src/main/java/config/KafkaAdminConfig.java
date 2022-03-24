package config;

import com.mrdiipo.appconfigdata.config.KafkaConfigData;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@Configurable
public class KafkaAdminConfig {

    private final KafkaConfigData kafkaConfigData;

    public KafkaAdminConfig(KafkaConfigData kafkaConfigData) {
        this.kafkaConfigData = kafkaConfigData;
    }
}
