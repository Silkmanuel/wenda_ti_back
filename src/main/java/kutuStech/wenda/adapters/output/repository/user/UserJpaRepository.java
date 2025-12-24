package kutuStech.wenda.adapters.output.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kutuStech.wenda.adapters.output.entity.JpaUserEntity;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<JpaUserEntity, String> {
    Optional<JpaUserEntity> findByPhoneNumber(String phoneNumber);
}
