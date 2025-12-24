package kutuStech.wenda.domain.word;

import java.util.List;
import java.util.Optional;

public interface WordRepository {
    Word save(Word word);
    List<Word> findByCaracters(String caracters);
    List<Word> getAll();
    Optional<Word> getById(String wordId);
}
