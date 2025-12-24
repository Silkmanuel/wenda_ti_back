package kutuStech.wenda.domain.reference;

import java.util.List;
import java.util.Optional;

public interface ReferenceRepository {
    Reference save(Reference reference);
    Optional<Reference> getById(String referenceId);
    List<Reference> getAll();
    void delete (Reference reference);
}
