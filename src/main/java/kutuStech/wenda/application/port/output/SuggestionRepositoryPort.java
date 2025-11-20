package kutuStech.wenda.application.port.output;

import kutuStech.wenda.domain.model.Suggestion;
import java.util.List;
import java.util.Optional;

public interface SuggestionRepositoryPort {
    Suggestion save(Suggestion sugestao);
    Optional<Suggestion> findById(String id);
    List<Suggestion> findAll();
}
