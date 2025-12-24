package kutuStech.wenda.adapters.output.repository.suggestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import kutuStech.wenda.adapters.output.entity.SuggestionEntity;
import kutuStech.wenda.domain.suggestion.Suggestion;
import kutuStech.wenda.domain.suggestion.SuggestionRepository;
import kutuStech.wenda.infrastructure.mapper.PersistenceMapper;
import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class SuggestionRepositoryImpl implements SuggestionRepository{
    private final PersistenceMapper mapper;
    private final SuggestionJpaRepository suggestionJpaRepository;

    @Override
    public Suggestion save(Suggestion suggestion) {
        return mapper.toDomain(suggestionJpaRepository.save(mapper.toEntity(suggestion)));
    }

    @Override
    public Optional<Suggestion> findById(String suggestionId) {
        Optional<SuggestionEntity> suggestionEntity = suggestionJpaRepository.findById(suggestionId);
        return mapper.optionalSuggestionToSuggestion(suggestionEntity);    
    }

    @Override
    public List<Suggestion> getAll() {
        List<SuggestionEntity> entities = suggestionJpaRepository.findAll();
        List<Suggestion> response = new ArrayList<>();
        for (SuggestionEntity e : entities) {
            response.add(mapper.toDomain(e));
        }
        return response;
    }

}
