package kutuStech.wenda.domain.subpoint;

import java.util.List;
import java.util.Optional;

public interface SubpointRepository {
    Subpoint save(Subpoint subpoint);
    Optional<Subpoint> getById(String subPointId);
    void delete (Subpoint subPoint);
    List<Subpoint> getAll();
}
