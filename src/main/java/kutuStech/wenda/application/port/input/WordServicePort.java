package kutuStech.wenda.application.port.input;


import java.util.List;

import kutuStech.wenda.domain.model.Word;

public interface WordServicePort {
    Word createWord(Word palavra);
    Word getWordById(String id);
    List<Word> getAllWords();
    void deleteWord(String id);
}
