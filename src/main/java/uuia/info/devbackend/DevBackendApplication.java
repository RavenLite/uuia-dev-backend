package uuia.info.devbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@ComponentScan(basePackages = {"uuia.info.devbackend"})
@EnableJpaRepositories(basePackages = {"uuia.info.devbackend.repository"})
@EntityScan(basePackages = {"uuia.info.devbackend.entity"})
public class DevBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(DevBackendApplication.class, args);
    }

}
