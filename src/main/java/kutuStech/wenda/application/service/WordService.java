package kutuStech.wenda.application.service;

import kutuStech.wenda.application.port.input.WordServicePort;
import kutuStech.wenda.application.port.output.WordRepositoryPort;
import kutuStech.wenda.domain.model.Word;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class WordService implements WordServicePort {

    private final WordRepositoryPort wordRepositoryPort;

    @Override
    public Word createWord(Word palavra) {
        palavra.setCreatedAt(LocalDateTime.now());
        palavra.setUpdatedAt(LocalDateTime.now());
        palavra.setDeleted(false);
        return wordRepositoryPort.save(palavra);
    }

    @Override
    public Word getWordById(String id) {
        return wordRepositoryPort.findById(id).orElseThrow(() -> new RuntimeException("Word not found"));
    }

    @Override
    public List<Word> getAllWords() {
        return wordRepositoryPort.findAll();
    }

    @Override
    public void deleteWord(String id) {
        wordRepositoryPort.deleteById(id);
    }
}
