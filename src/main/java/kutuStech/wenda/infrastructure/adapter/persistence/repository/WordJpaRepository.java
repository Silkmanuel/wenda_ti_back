package kutuStech.wenda.infrastructure.adapter.persistence.repository;

import kutuStech.wenda.infrastructure.adapter.persistence.entity.WordEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordJpaRepository extends JpaRepository<WordEntity, String> {
}
