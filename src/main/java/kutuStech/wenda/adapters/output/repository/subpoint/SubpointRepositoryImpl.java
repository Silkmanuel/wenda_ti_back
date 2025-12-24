package kutuStech.wenda.adapters.output.repository.subpoint;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import kutuStech.wenda.adapters.output.entity.SubpointEntity;
import kutuStech.wenda.domain.subpoint.Subpoint;
import kutuStech.wenda.domain.subpoint.SubpointRepository;
import kutuStech.wenda.infrastructure.mapper.PersistenceMapper;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SubpointRepositoryImpl implements SubpointRepository{
    private final PersistenceMapper mapper;
    private final SubpointJpaRepository subpointJpaRepository;

    @Override
    public Subpoint save(Subpoint subpoint) {
        return mapper.toDomain(subpointJpaRepository.save(mapper.toEntity(subpoint)));
    }

    @Override
    public Optional<Subpoint> getById(String subPointId) {
        Optional<SubpointEntity> subpointOptinal = subpointJpaRepository.findById(subPointId);
        return mapper.optionalJpaSubpointEntityToSubpoint(subpointOptinal);
    }

    @Override
    public void delete(Subpoint subPoint) {
        subpointJpaRepository.delete(mapper.toEntity(subPoint));
    }

    @Override
    public List<Subpoint> getAll() {
        List<SubpointEntity> subpointEntities = subpointJpaRepository.findAll();
        List<Subpoint> response = new ArrayList<>();
        for (SubpointEntity subpointEntity : subpointEntities) {
            response.add(mapper.toDomain(subpointEntity));
        }
        return response;
    }
}
