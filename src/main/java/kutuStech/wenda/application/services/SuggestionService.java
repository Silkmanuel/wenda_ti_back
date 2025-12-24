package kutuStech.wenda.application.services;

import kutuStech.wenda.adapters.output.repository.suggestion.SuggestionRepositoryImpl;
import kutuStech.wenda.application.dtos.suggestion.SuggestionRegisterParams;
import kutuStech.wenda.application.usecases.SuggestionUseCases;
import kutuStech.wenda.domain.suggestion.Suggestion;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class SuggestionService implements SuggestionUseCases {

    private final SuggestionRepositoryImpl suggestionRepository;

    @Override
    public Suggestion createSuggestion(SuggestionRegisterParams suggestionParams) {
        Suggestion suggestion = new Suggestion();
        suggestion.setTitle(suggestionParams.title());
        suggestion.setEmail(suggestionParams.email());
        suggestion.setCreatedAt(LocalDateTime.now());
        suggestion.setUpdatedAt(LocalDateTime.now());
        suggestion.setDeleted(false);
        return suggestionRepository.save(suggestion);
    }

    @Override
    public List<Suggestion> getAllSuggestions() {
        List<Suggestion> sugestions = suggestionRepository.getAll();
        List<Suggestion> response = new ArrayList<>();
        for (Suggestion s : sugestions) {
            response.add(s);
        }
        return response;
    }

    @Override
    public List<Suggestion> getAllSuggestionsAvailable() {
        List<Suggestion> sugestions = suggestionRepository.getAll();
        List<Suggestion> response = new ArrayList<>();
        for (Suggestion s : sugestions) {
            if(s.getIdWord() == null){
                response.add(s);
            }
        }
        return response;    
    }

    @Override
    public void updateSuggestion(Suggestion suggestion) {
        suggestion.setUpdatedAt(LocalDateTime.now());
        suggestion.setDeleted(true);
        suggestionRepository.save(suggestion);
    }

    @Override
    public Suggestion getById(String suggestionId) {
        Optional<Suggestion> suggestionOptinal = suggestionRepository.findById(suggestionId);
        if(suggestionOptinal.isPresent()) return suggestionOptinal.get();
        throw new UnsupportedOperationException("Suggestion not found");  
    }
}
