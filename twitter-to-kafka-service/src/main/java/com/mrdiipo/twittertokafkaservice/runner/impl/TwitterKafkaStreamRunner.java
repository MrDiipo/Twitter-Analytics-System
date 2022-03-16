package com.mrdiipo.twittertokafkaservice.runner.impl;

import com.mrdiipo.twittertokafkaservice.config.ConfigData;
import com.mrdiipo.twittertokafkaservice.listener.TwitterKafkaStatusListener;
import com.mrdiipo.twittertokafkaservice.runner.StreamRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import twitter4j.FilterQuery;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import javax.annotation.PreDestroy;
import java.util.Arrays;

@Component
public class TwitterKafkaStreamRunner  implements StreamRunner {

    public static final Logger LOG = LoggerFactory.getLogger(TwitterKafkaStreamRunner.class);

    private final ConfigData configData;
    private final TwitterKafkaStatusListener twitterKafkaStatusListener;
    private TwitterStream twitterStream;

    public TwitterKafkaStreamRunner(ConfigData configData,
                                    TwitterKafkaStatusListener twitterKafkaStatusListener) {
        this.configData = configData;
        this.twitterKafkaStatusListener = twitterKafkaStatusListener;
    }

    @Override
    public void start() throws TwitterException {
        twitterStream = new TwitterStreamFactory().getInstance();
        twitterStream.addListener(twitterKafkaStatusListener);
        addFilter();
    }

    @PreDestroy
    public void shutdown(){
        if(twitterStream != null){
            LOG.info("Closing twitter stream");
            twitterStream.shutdown();
        }
    }

    private void addFilter(){
        String[] keywords = configData.getTwitterKeywords().toArray(new String[]{});
        FilterQuery filterQuery = new FilterQuery(keywords);
        twitterStream.filter(filterQuery);
        LOG.info("Started filtering twitter stream for keywords {}", Arrays.toString(keywords));
    }
}
