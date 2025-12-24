package kutuStech.wenda.adapters.output.repository.reference;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import kutuStech.wenda.adapters.output.entity.ReferenceEntity;
import kutuStech.wenda.domain.reference.Reference;
import kutuStech.wenda.domain.reference.ReferenceRepository;
import kutuStech.wenda.infrastructure.mapper.PersistenceMapper;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ReferenceRepositoryImpl implements ReferenceRepository {
    private final PersistenceMapper mapper;
    private final ReferenceJpaRepository referenceJpaRepository;

    @Override
    public Reference save(Reference reference) {
        return mapper.toDomain(referenceJpaRepository.save(mapper.toEntity(reference)));
    }

    @Override
    public Optional<Reference> getById(String referenceId) {
        Optional<ReferenceEntity> referenceOptional = referenceJpaRepository.findById(referenceId);
        return mapper.optionalJpaReferenceEntityToReference(referenceOptional);
    }

    @Override
    public void delete(Reference reference) {
        referenceJpaRepository.delete(mapper.toEntity(reference));
    }

    @Override
    public List<Reference> getAll() {
        List<ReferenceEntity> referenceEntities = referenceJpaRepository.findAll();
        List<Reference> refences = new ArrayList<>();
        for (ReferenceEntity r : referenceEntities) {
            refences.add(mapper.toDomain(r));
        }
        return refences;
    }

}
