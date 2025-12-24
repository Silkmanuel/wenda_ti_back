package kutuStech.wenda.application.services;

import kutuStech.wenda.application.dtos.word_dtos.WordRegisterParams;
import kutuStech.wenda.application.usecases.ReferenceUseCases;
import kutuStech.wenda.application.usecases.SubpointUseCases;
import kutuStech.wenda.application.usecases.SuggestionUseCases;
import kutuStech.wenda.application.usecases.UserUseCases;
import kutuStech.wenda.application.usecases.WordUseCases;
import kutuStech.wenda.domain.reference.Reference;
import kutuStech.wenda.domain.subpoint.Subpoint;
import kutuStech.wenda.domain.suggestion.Suggestion;
import kutuStech.wenda.domain.word.Word;
import kutuStech.wenda.domain.word.WordRepository;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.transaction.Transactional;

@RequiredArgsConstructor
public class WordService implements WordUseCases {
    private final WordRepository wordRepository;
    private final ReferenceUseCases referenceuCases;
    private final SubpointUseCases subpointUseCases;
    private final SuggestionUseCases suggestionUseCases;
    private final UserUseCases userUseCases;

    @Transactional
    @Override
    public Word createWord(WordRegisterParams wordParams) {
        // User user = new User();
        try {
            userUseCases.getById(wordParams.idCreator());
            // user = userOptional.get();
        Suggestion suggestion = new Suggestion();
        if(wordParams.idSuggestion() != null){
            suggestion = suggestionUseCases.getById(wordParams.idSuggestion());
        }
        List<Reference> references = new ArrayList<>();
        List<Subpoint> subpoints = new ArrayList<>();
        for (String reference : wordParams.references()) {
            Reference r = referenceuCases.getById(reference);
            references.add(r);
        }
        for (String subpoint : wordParams.points()) {
            Subpoint s = subpointUseCases.getById(subpoint);
            subpoints.add(s);
        }
        Word word = Word.builder()
                .title(wordParams.title())
                .description(wordParams.description())
                .idCreator(wordParams.idCreator())
                .idSuggestion(wordParams.idSuggestion())
                .subpoints(subpoints)
                .references(references)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .deleted(false)
                .build();
        word = wordRepository.save(word);
        suggestion.setDeleted(true);
        suggestion.setIdWord(word.getId());
        suggestionUseCases.updateSuggestion(suggestion);
        return word;
        } catch (Exception e) {
          throw  new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Word getWordById(String wordId) {
        return wordRepository.getById(wordId).orElseThrow(() -> new RuntimeException("Word not found"));
    }

    @Override
    public List<Word> getAllWords() {
        List<Word> words = wordRepository.getAll();
        List<Word> response = new ArrayList<>();
        for (Word word : words) {
            if (!word.getDeleted()) {
                response.add(word);
            }
        }
        return response;
    }

    @Override
    public void deleteWord(String wordId) {
        try {
            Word word = wordRepository.getById(wordId).orElseThrow(() -> new RuntimeException("Word not found"));
            word.setDeleted(true);
            wordRepository.save(word);
        } catch (Exception e) {
          throw  new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Word> getWordByCaracters(String caracter) {
        List<Word> words = wordRepository.findByCaracters(caracter);
        List<Word> response = new ArrayList<>();
        for (Word word : words) {
            if (!word.getDeleted()) {
                response.add(word);
            }
        }
        return response; 
    }
}
