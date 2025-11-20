package kutuStech.wenda.application.port.input;

import kutuStech.wenda.domain.model.User;

public interface UserServicePort {
    User createUser(User adm);
    User getUserById(String id);
}
