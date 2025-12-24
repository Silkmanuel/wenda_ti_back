package kutuStech.wenda.domain.suggestion;

import java.util.List;
import java.util.Optional;

public interface SuggestionRepository {
    Suggestion save(Suggestion suggestion);
    Optional<Suggestion> findById(String suggestionId);
    List<Suggestion> getAll();
}
