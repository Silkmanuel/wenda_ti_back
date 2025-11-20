package kutuStech.wenda.application.port.input;

import kutuStech.wenda.domain.model.Suggestion;
import java.util.List;

public interface SuggestionServicePort {
    Suggestion createSuggestion(Suggestion suggestion);
    List<Suggestion> getAllSuggestions();
}
