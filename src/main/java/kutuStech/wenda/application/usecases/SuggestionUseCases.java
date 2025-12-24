package kutuStech.wenda.application.usecases;

import java.util.List;

import kutuStech.wenda.application.dtos.suggestion.SuggestionRegisterParams;
import kutuStech.wenda.domain.suggestion.Suggestion;

public interface SuggestionUseCases {
    Suggestion createSuggestion(SuggestionRegisterParams suggestion);
    List<Suggestion> getAllSuggestions();
    List<Suggestion> getAllSuggestionsAvailable();
    Suggestion getById(String suggestionId);
    void updateSuggestion(Suggestion suggestion);
}
