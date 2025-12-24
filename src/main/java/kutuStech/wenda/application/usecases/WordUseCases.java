package kutuStech.wenda.application.usecases;


import java.util.List;

import kutuStech.wenda.application.dtos.word_dtos.WordRegisterParams;
import kutuStech.wenda.domain.word.Word;

public interface WordUseCases {
    Word createWord(WordRegisterParams word);
    Word getWordById(String wordId);
    List<Word> getAllWords();
    void deleteWord(String wordId);
    List<Word> getWordByCaracters(String caracter);
}
