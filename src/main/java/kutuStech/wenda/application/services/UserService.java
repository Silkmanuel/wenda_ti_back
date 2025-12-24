package kutuStech.wenda.application.services;


import kutuStech.wenda.adapters.output.config.PasswordEncodePort;
import kutuStech.wenda.adapters.output.config.TokenServicePort;
import kutuStech.wenda.application.dtos.user_dtos.UserLoginResponse;
import kutuStech.wenda.application.dtos.user_dtos.UserRegisterParams;
import kutuStech.wenda.application.usecases.UserUseCases;
import kutuStech.wenda.domain.user.User;
import kutuStech.wenda.domain.user.UserRepository;
import kutuStech.wenda.infrastructure.mapper.DtosMappers;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserUseCases {
    private final DtosMappers dtosMappers;
    private final TokenServicePort tokenService;
    private final UserRepository userRepository;
    private final PasswordEncodePort passwordEncode;

    @Override
    public User createUser(UserRegisterParams user) {
        Optional<User> userOptional=userRepository.findByPhoneNumber(user.phoneNumber());
        if(userOptional.isPresent()){
            throw new UnsupportedOperationException("Phone number duplicate");
        }
        String passwordEncripty = passwordEncode.encode(user.password());
        User userDomain = User.builder()
                .name(user.name())
                .phoneNumber(user.phoneNumber())
                .password(passwordEncripty)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        return userRepository.save(userDomain);
    }


    @Override
    public List<User> getAll() {
        return userRepository.getall();
    }

    @Override
    public User getUserByPhonenUMBER(String phoneNumber) {
        Optional<User> userOptinal = userRepository.findByPhoneNumber(phoneNumber);
        if(userOptinal.isPresent()) return userOptinal.get();
        throw new UnsupportedOperationException("User not found");
    }


    @Override
    public UserLoginResponse login(String phoneNumber, String passeword) {
        Optional<User> userOptional = userRepository.findByPhoneNumber(phoneNumber);
        if(!userOptional.isPresent()){
            throw new UnsupportedOperationException("Unathorized");
        }
        boolean passwordisTrue = passwordEncode.matches(passeword, userOptional.get().getPassword());
        if(!passwordisTrue){
            throw new UnsupportedOperationException("Unathorized");
        }
        String token = tokenService.generateAccessToken(userOptional.get().getId());
        return dtosMappers.toUserlogin(userOptional.get(), token);
    }


    @Override
    public User getById(String userId) {
        Optional<User> userOptinal = userRepository.findById(userId);
        if(userOptinal.isPresent()) return userOptinal.get();
        throw new UnsupportedOperationException("User not found");    
    }
}
