package com.mrdiipo.twittertokafkaservice;

import com.mrdiipo.appconfigdata.config.ConfigData;
import com.mrdiipo.twittertokafkaservice.runner.StreamRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan("com.mrdiipo")
public class TwitterToKafkaServiceApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(TwitterToKafkaServiceApplication.class);
	private final ConfigData configData;
	private final StreamRunner streamRunner;

	public TwitterToKafkaServiceApplication(ConfigData configData, @Qualifier("mockKafkaStreamRunner") StreamRunner streamRunner) {
		this.configData = configData;
		this.streamRunner = streamRunner;
	}

	public static void main(String[] args) {
		SpringApplication.run(TwitterToKafkaServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("App Starts...");
		LOG.info(Arrays.toString(configData.getTwitterKeywords().toArray(new String[] {})));
		streamRunner.start();
	}
}
