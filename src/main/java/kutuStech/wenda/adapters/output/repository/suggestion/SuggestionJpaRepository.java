package kutuStech.wenda.adapters.output.repository.suggestion;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kutuStech.wenda.adapters.output.entity.SuggestionEntity;

@Repository
public interface SuggestionJpaRepository extends JpaRepository<SuggestionEntity, String> {
}
