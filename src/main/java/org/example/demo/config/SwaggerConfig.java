package org.example.demo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.models.GroupedOpenApi;


@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        // new info 막혀서  다른 방법
        return new OpenAPI().info(new io.swagger.v3.oas.models.info.Info()
                .title("Board API")
                .version("1.0")
                .description("Board API Description"));
    }
}
