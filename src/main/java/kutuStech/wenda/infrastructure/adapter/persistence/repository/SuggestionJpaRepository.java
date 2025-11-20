package kutuStech.wenda.infrastructure.adapter.persistence.repository;


import kutuStech.wenda.infrastructure.adapter.persistence.entity.SuggestionEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestionJpaRepository extends JpaRepository<SuggestionEntity, String> {
}
