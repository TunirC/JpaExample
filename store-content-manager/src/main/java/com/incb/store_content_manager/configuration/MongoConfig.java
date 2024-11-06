package com.incb.store_content_manager.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com/incb/store_content_manager/repository/mongo")
@ConditionalOnProperty(prefix = "db.source", value = "type", havingValue = "mongo")
public class MongoConfig {
}
