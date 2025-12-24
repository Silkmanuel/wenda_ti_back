package kutuStech.wenda.infrastructure.mapper;

import org.springframework.stereotype.Component;
import kutuStech.wenda.application.dtos.user_dtos.UserLoginResponse;
import kutuStech.wenda.domain.user.User;

@Component
public class DtosMappers {
    public UserLoginResponse toUserlogin(User user, String token) {
    if (user == null) return null;
        return new UserLoginResponse(user.getId(), user.getName(), user.getPhoneNumber(), token, user.getCreatedAt(), user.getUpdatedAt());
    }
}
