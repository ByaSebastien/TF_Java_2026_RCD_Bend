package be.bstorm.tf_java_2026_rcd_bend.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("DigitalHub API")
                        .version("1.0.0")
                        .description("Professional Spring Boot REST API with JWT Authentication, DTOs, MapStruct, and Validation")
                        .contact(new Contact()
                                .name("Spring Boot Training")
                                .url("https://springboot-training.example.com")
                        )
                )
                .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("Bearer Authentication",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                                        .description("Enter JWT token (without 'Bearer' prefix, it will be added automatically)")
                        )
                );
    }
}
