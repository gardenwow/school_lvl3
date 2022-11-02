package ru.hogwarts.school.lvl3;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@OpenAPIDefinition
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SchoolLvl3Application {

    public static void main(String[] args) {
        SpringApplication.run(SchoolLvl3Application.class, args);
    }

}
