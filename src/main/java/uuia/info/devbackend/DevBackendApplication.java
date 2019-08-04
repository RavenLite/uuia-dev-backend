package uuia.info.devbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("uuia.info.devbackend.entity")
@EnableJpaRepositories("uuia.info.devbackend.repository")
public class DevBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevBackendApplication.class, args);
    }

}
