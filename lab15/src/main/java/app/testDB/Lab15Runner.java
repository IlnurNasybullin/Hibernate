package app.testDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching(proxyTargetClass = true)
public class Lab15Runner {
    public static void main(String[] args) {
        SpringApplication.run(Lab15Runner.class, args);
    }
}
