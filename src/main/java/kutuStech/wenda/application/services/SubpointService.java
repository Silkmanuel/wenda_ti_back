package kutuStech.wenda.application.services;

import kutuStech.wenda.application.dtos.subpoint_dtos.SubpointRegisterParams;
import kutuStech.wenda.application.usecases.SubpointUseCases;
import kutuStech.wenda.domain.subpoint.Subpoint;
import kutuStech.wenda.domain.subpoint.SubpointRepository;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class SubpointService implements SubpointUseCases {
    private final SubpointRepository subpointRepository;

    @Override
    public Subpoint createSubpoint(SubpointRegisterParams subpoint) {
        Subpoint subpointDomain = Subpoint.builder()
                .description(subpoint.description())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        return subpointRepository.save(subpointDomain);
    }

    @Override
    public Subpoint getById(String subpointId) {
        try {
            Optional<Subpoint> subpointOptional= subpointRepository.getById(subpointId);
            if (!subpointOptional.isPresent()) {
                throw  new RuntimeException("subpoint not found");
            }
            return subpointOptional.get();
        } catch (Exception e) {
          throw  new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Subpoint> getAll() {
        return subpointRepository.getAll();
    }
}
