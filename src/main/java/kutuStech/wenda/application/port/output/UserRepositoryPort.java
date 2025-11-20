package kutuStech.wenda.application.port.output;

import kutuStech.wenda.domain.model.User;
import java.util.Optional;

public interface UserRepositoryPort {
    User save(User adm);
    Optional<User> findById(String id);
    Optional<User> findByName(String nome);
}
