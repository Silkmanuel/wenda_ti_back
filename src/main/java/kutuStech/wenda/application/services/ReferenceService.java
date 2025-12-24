package kutuStech.wenda.application.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import kutuStech.wenda.adapters.output.repository.reference.ReferenceRepositoryImpl;
import kutuStech.wenda.application.dtos.reference_dtos.ReferenceRegisterParams;
import kutuStech.wenda.application.usecases.ReferenceUseCases;
import kutuStech.wenda.domain.reference.Reference;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReferenceService implements ReferenceUseCases {
        private final ReferenceRepositoryImpl referenceRepository;

    @Override
    public Reference createReference(ReferenceRegisterParams reference) {
        Reference referenceDomain = Reference.builder()
                .description(reference.description())
                .url(reference.url())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        return referenceRepository.save(referenceDomain);
    }

    @Override
    public List<Reference> getAllReference() {
        return referenceRepository.getAll();
    }

    @Override
    public Reference getById(String referenceId) {
        try {
            Optional<Reference> refOptional = referenceRepository.getById(referenceId);
            if(!refOptional.isPresent()){
                throw  new RuntimeException("reference not found");
            }
            return refOptional.get();
        } catch (Exception e) {
          throw  new RuntimeException(e.getMessage());
        }
    }
    
}
