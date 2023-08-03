package com.example.dtodemo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@OpenAPIDefinition(servers = { @Server(url = "http://localhost:8888", description = "로컬 서버 테스트 용"),
        @Server(url = "https://tonyhouse.site", description = "실제 서버 테스트 용")})
@SpringBootApplication
@EnableJpaAuditing
public class DtoDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DtoDemoApplication.class, args);
    }

}
