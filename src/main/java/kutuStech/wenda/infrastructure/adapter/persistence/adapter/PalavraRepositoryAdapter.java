package kutuStech.wenda.infrastructure.adapter.persistence.adapter;

import kutuStech.wenda.application.port.output.WordRepositoryPort;
import kutuStech.wenda.domain.model.Word;
import kutuStech.wenda.infrastructure.adapter.persistence.entity.WordEntity;
import kutuStech.wenda.infrastructure.adapter.persistence.mapper.PersistenceMapper;
import kutuStech.wenda.infrastructure.adapter.persistence.repository.WordJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PalavraRepositoryAdapter implements WordRepositoryPort {

    private final WordJpaRepository wordJpaRepository;
    private final PersistenceMapper mapper;

    @Override
    public Word save(Word word) {
        WordEntity entity = mapper.toEntity(word);
        WordEntity savedEntity = wordJpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Word> findById(String id) {
        return wordJpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Word> findAll() {
        return wordJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        wordJpaRepository.deleteById(id);
    }
}
