package ua.com.dionysus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DionysusServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DionysusServerApplication.class, args);
    }

}
