package kutuStech.wenda.infrastructure.adapter.persistence.adapter;

import kutuStech.wenda.application.port.output.SuggestionRepositoryPort;
import kutuStech.wenda.domain.model.Suggestion;
import kutuStech.wenda.infrastructure.adapter.persistence.entity.SuggestionEntity;
import kutuStech.wenda.infrastructure.adapter.persistence.mapper.PersistenceMapper;
import kutuStech.wenda.infrastructure.adapter.persistence.repository.SuggestionJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SuggestionRepositoryAdapter implements SuggestionRepositoryPort {

    private final SuggestionJpaRepository suggestionJpaRepository;
    private final PersistenceMapper mapper;

    @Override
    public Suggestion save(Suggestion suggestion) {
        SuggestionEntity entity = mapper.toEntity(suggestion);
        SuggestionEntity savedEntity = suggestionJpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Suggestion> findById(String id) {
        return suggestionJpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Suggestion> findAll() {
        return suggestionJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    // @Override
    // public void deleteById(String id) {
    //     suggestionJpaRepository.deleteById(id);
    // }
}
