package kutuStech.wenda.adapters.output.repository.word;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import kutuStech.wenda.adapters.output.entity.WordEntity;
import kutuStech.wenda.domain.word.Word;
import kutuStech.wenda.domain.word.WordRepository;
import kutuStech.wenda.infrastructure.mapper.PersistenceMapper;
import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class WordRepositoryImpl implements WordRepository{
    private final PersistenceMapper mapper;
    private final WordJpaRepository wordJpaRepository;

    @Override
    public Word save(Word word) {
        return mapper.toDomain(wordJpaRepository.save(mapper.toEntity(word)));
    }

    @Override
    public List<Word> findByCaracters(String caracters) {
        List<WordEntity> wordEntities = wordJpaRepository.findByTitleContainingIgnoreCaseAndDeletedFalse(caracters);
        List<Word> response = new ArrayList<>();
        for (WordEntity w : wordEntities) {
            response.add(mapper.toDomain(w));
        }
        return response;
    }

    @Override
    public List<Word> getAll() {
        List<WordEntity> wordEntities = wordJpaRepository.findAll();
        List<Word> response = new ArrayList<>();
        for (WordEntity w : wordEntities) {
            response.add(mapper.toDomain(w));
        }
        return response;
    }

    @Override
    public Optional<Word> getById(String wordId) {
        Optional<WordEntity> wordEntity = wordJpaRepository.findById(wordId);
        return mapper.optionalJpaWordEntityToWord(wordEntity);
    }

}
