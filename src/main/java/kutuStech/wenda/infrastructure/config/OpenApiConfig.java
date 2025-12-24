package kutuStech.wenda.infrastructure.config;

import io.swagger.v3.oas.models.Components;
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
    public OpenAPI wendaOpenAPI() {
        Components components = new Components()
        .addSecuritySchemes("ApiKeyAuth",
                new SecurityScheme()
                        .type(SecurityScheme.Type.APIKEY)
                        .in(SecurityScheme.In.HEADER)
                        .name("wenda-api-key"))
        .addSecuritySchemes("Bearer Authentication",
                new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT"));
        return new OpenAPI()
                .components(components)
                .addSecurityItem(new SecurityRequirement()
                                    .addList("ApiKeyAuth")
                                    .addList("Bearer Authentication")
                                )
                .info(new Info().title("Wenda TI API")
                        .description("API documentation for Wenda TI application")
                        .version("v1.0.0")
                        .contact(new Contact()
                        .name("Suporte Wenda TI")
                        .url("https://wendati.com/support")
                        .email("silk552001@gmail.com"))
                    );
    }
}
