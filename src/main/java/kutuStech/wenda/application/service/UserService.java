package kutuStech.wenda.application.service;

import kutuStech.wenda.application.port.input.UserServicePort;
import kutuStech.wenda.application.port.output.UserRepositoryPort;
import kutuStech.wenda.domain.model.User;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class UserService implements UserServicePort {

    private final UserRepositoryPort userRepositoryPort;

    @Override
    public User createUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return userRepositoryPort.save(user);
    }

    @Override
    public User getUserById(String id) {
        return userRepositoryPort.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
