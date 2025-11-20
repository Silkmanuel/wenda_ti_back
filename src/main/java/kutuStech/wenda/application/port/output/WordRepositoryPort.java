package kutuStech.wenda.application.port.output;

import kutuStech.wenda.domain.model.Word;
import java.util.List;
import java.util.Optional;

public interface WordRepositoryPort {
    Word save(Word palavra);
    Optional<Word> findById(String id);
    List<Word> findAll();
    void deleteById(String id);
}
