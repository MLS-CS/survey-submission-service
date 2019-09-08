package com.marketlogicsoftware.cs.surveysubmissionservice;

import com.mongodb.MongoClient;
import cz.jirutka.spring.embedmongo.EmbeddedMongoBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;

@Configuration
@Profile("dev")
public class SurveySubmissionDevConfiguration {
    @Autowired
    private SurveySubmissionProperties surveySubmissionProperties;

    @Bean
    public MongoClient mongoClient() throws IOException {
        return new EmbeddedMongoBuilder()
                .bindIp(surveySubmissionProperties.getDb().getHost())
                .build();
    }

    @Bean
    public MongoTemplate mongoTemplate() throws IOException {
        return new MongoTemplate(mongoClient(), surveySubmissionProperties.getDb().getName());
    }

}
