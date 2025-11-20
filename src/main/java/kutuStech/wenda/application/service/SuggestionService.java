package kutuStech.wenda.application.service;

import kutuStech.wenda.application.port.input.SuggestionServicePort;
import kutuStech.wenda.application.port.output.SuggestionRepositoryPort;
import kutuStech.wenda.domain.model.Suggestion;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class SuggestionService implements SuggestionServicePort {

    private final SuggestionRepositoryPort suggestionRepositoryPort;

    @Override
    public Suggestion createSuggestion(Suggestion suggestion) {
        suggestion.setCreatedAt(LocalDateTime.now());
        suggestion.setUpdatedAt(LocalDateTime.now());
        suggestion.setDeleted(false);
        return suggestionRepositoryPort.save(suggestion);
    }

    @Override
    public List<Suggestion> getAllSuggestions() {
        return suggestionRepositoryPort.findAll();
    }
}
