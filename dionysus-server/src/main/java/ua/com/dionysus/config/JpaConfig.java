package ua.com.dionysus.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("ua.com.dionysus.persistence.sql.repository.product")
public class JpaConfig {
}
