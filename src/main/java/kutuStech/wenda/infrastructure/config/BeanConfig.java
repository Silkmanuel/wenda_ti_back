package kutuStech.wenda.infrastructure.config;

import kutuStech.wenda.application.port.output.SuggestionRepositoryPort;
import kutuStech.wenda.application.port.output.UserRepositoryPort;
import kutuStech.wenda.application.port.output.WordRepositoryPort;
import kutuStech.wenda.application.service.SuggestionService;
import kutuStech.wenda.application.service.UserService;
import kutuStech.wenda.application.service.WordService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public WordService wordService(WordRepositoryPort wordRepositoryPort) {
        return new WordService(wordRepositoryPort);
    }

    @Bean
    public UserService userService(UserRepositoryPort userRepositoryPort) {
        return new UserService(userRepositoryPort);
    }

    @Bean
    public SuggestionService sugestaoService(SuggestionRepositoryPort sugestaoRepositoryPort) {
        return new SuggestionService(sugestaoRepositoryPort);
    }
}
