package kutuStech.wenda.application.usecases;

import java.util.List;
import kutuStech.wenda.application.dtos.user_dtos.UserLoginResponse;
import kutuStech.wenda.application.dtos.user_dtos.UserRegisterParams;
import kutuStech.wenda.domain.user.User;

public interface UserUseCases {
    User createUser(UserRegisterParams adm);
    User getUserByPhonenUMBER(String phoneNumber);
    List<User> getAll();
    UserLoginResponse login (String phoneNumber, String passeword);
    User getById (String userId);
    
}
