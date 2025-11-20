package kutuStech.wenda.infrastructure.adapter.persistence.adapter;

import kutuStech.wenda.application.port.output.UserRepositoryPort;
import kutuStech.wenda.domain.model.User;
import kutuStech.wenda.infrastructure.adapter.persistence.entity.UserEntity;
import kutuStech.wenda.infrastructure.adapter.persistence.mapper.PersistenceMapper;
import kutuStech.wenda.infrastructure.adapter.persistence.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserJpaRepository userJpaRepository;
    private final PersistenceMapper mapper;

    @Override
    public User save(User user) {
        UserEntity entity = mapper.toEntity(user);
        UserEntity savedEntity = userJpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<User> findById(String id) {
        return userJpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<User> findByName(String nome) {
        return userJpaRepository.findByName(nome).map(mapper::toDomain);
    }
}
