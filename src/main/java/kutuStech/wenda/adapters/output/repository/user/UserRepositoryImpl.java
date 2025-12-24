package kutuStech.wenda.adapters.output.repository.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import kutuStech.wenda.adapters.output.entity.JpaUserEntity;
import kutuStech.wenda.domain.user.User;
import kutuStech.wenda.domain.user.UserRepository;
import kutuStech.wenda.infrastructure.mapper.PersistenceMapper;
import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository{

    private final PersistenceMapper mapper;
    private final UserJpaRepository userJpaRepository;

    @Override
    public User save(User user) {
        JpaUserEntity userEntity = mapper.toEntity(user);
        userEntity = userJpaRepository.save(userEntity);
        return mapper.toDomain(userEntity);
    }

    @Override
    public Optional<User> findByPhoneNumber(String phoneNumber) {
        Optional<JpaUserEntity> useOptional = userJpaRepository.findByPhoneNumber(phoneNumber);
        return mapper.optionalJpaUserEntityToUser(useOptional);
    }

    @Override
    public List<User> getall() {
        List<User> users = new ArrayList<>();
        List<JpaUserEntity> usersEntity = userJpaRepository.findAll();
        for (JpaUserEntity jpaUserEntity : usersEntity) {
            users.add(mapper.toDomain(jpaUserEntity));
        }
        return users;
    }

    @Override
    public Optional<User> findById(String userId) {
        Optional<JpaUserEntity> useOptional = userJpaRepository.findById(userId);
        return mapper.optionalJpaUserEntityToUser(useOptional);
    }
    
}
