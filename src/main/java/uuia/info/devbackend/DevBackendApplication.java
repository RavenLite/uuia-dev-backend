package uuia.info.devbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"uuia.info.devbackend"})
public class DevBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevBackendApplication.class, args);
    }

}
