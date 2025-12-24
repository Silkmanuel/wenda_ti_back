package kutuStech.wenda.domain.user;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    // save
    User save(User user);
    // get by phone number
    Optional<User> findByPhoneNumber(String phoneNumber);

    List<User> getall();

    Optional<User> findById(String userId);

}
