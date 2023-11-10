package ua.com.dionysus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@EnableElasticsearchRepositories("ua.com.dionysus.persistence.elasticsearch.repository")
public class ElasticsearchConfig {
}
