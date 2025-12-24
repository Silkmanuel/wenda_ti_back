package kutuStech.wenda.infrastructure.config;

import kutuStech.wenda.adapters.output.config.PasswordEncodePort;
import kutuStech.wenda.adapters.output.config.TokenServicePort;
import kutuStech.wenda.adapters.output.repository.reference.ReferenceRepositoryImpl;
import kutuStech.wenda.adapters.output.repository.subpoint.SubpointRepositoryImpl;
import kutuStech.wenda.adapters.output.repository.suggestion.SuggestionRepositoryImpl;
import kutuStech.wenda.adapters.output.repository.word.WordRepositoryImpl;
import kutuStech.wenda.application.services.ReferenceService;
import kutuStech.wenda.application.services.SubpointService;
import kutuStech.wenda.application.services.SuggestionService;
import kutuStech.wenda.application.services.UserService;
import kutuStech.wenda.application.services.WordService;
import kutuStech.wenda.application.usecases.ReferenceUseCases;
import kutuStech.wenda.application.usecases.SubpointUseCases;
import kutuStech.wenda.application.usecases.SuggestionUseCases;
import kutuStech.wenda.application.usecases.UserUseCases;
import kutuStech.wenda.domain.user.UserRepository;
import kutuStech.wenda.infrastructure.mapper.DtosMappers;
import kutuStech.wenda.infrastructure.security.JwtAutenticationFilter;
import kutuStech.wenda.infrastructure.services.Argon2PasswordEncoderAdapter;
import kutuStech.wenda.infrastructure.services.TokenServiceAdapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    private final DtosMappers dtosMappers = new DtosMappers();
    private final TokenServicePort tokenService = new TokenServiceAdapter();
    private final PasswordEncodePort passwordEncode = new Argon2PasswordEncoderAdapter();

    // private final WordRepository wordRepository;
    // private final ReferenceUseCases referenceuCases;
    // private final SubpointUseCases subpointUseCases;
    // private final SuggestionUseCases suggestionUseCases;
    // private final UserUseCases userUseCases;
    @Bean
    public WordService wordService(WordRepositoryImpl wordRepository, ReferenceUseCases referenceUseCases, SubpointUseCases subpointUseCases, UserUseCases userUseCases, SuggestionUseCases suggestionUseCases) {
        return new WordService(wordRepository, referenceUseCases, subpointUseCases, suggestionUseCases,userUseCases);
    }

    @Bean
    public UserService userService(UserRepository userRepositoryPort) {
        return new UserService(dtosMappers, tokenService, userRepositoryPort, passwordEncode);
    }

    @Bean
    public SuggestionService sugestaoService(SuggestionRepositoryImpl sugestaoRepositoryPort) {
        return new SuggestionService(sugestaoRepositoryPort);
    }

    @Bean
    public ReferenceService referenceService(ReferenceRepositoryImpl referenceRepositoryPort) {
        return new ReferenceService(referenceRepositoryPort);
    }

    @Bean
    public SubpointService subpointService(SubpointRepositoryImpl subpointRepositoryPort) {
        return new SubpointService(subpointRepositoryPort);
    }

    @Bean
    public JwtAutenticationFilter jwtAutenticationFilter(){
        return new JwtAutenticationFilter(tokenService);
    }
}
