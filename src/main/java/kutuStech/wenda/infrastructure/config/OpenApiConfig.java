package kutuStech.wenda.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI wendaOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Wenda TI API")
                        .description("API documentation for Wenda TI application")
                        .version("v1.0.0"));
    }
}
