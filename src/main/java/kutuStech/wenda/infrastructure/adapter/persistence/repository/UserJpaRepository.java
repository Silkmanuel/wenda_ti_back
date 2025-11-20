package kutuStech.wenda.infrastructure.adapter.persistence.repository;

import kutuStech.wenda.infrastructure.adapter.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByName(String nome);
}
