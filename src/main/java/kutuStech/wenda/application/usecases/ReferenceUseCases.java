package kutuStech.wenda.application.usecases;

import java.util.List;

import kutuStech.wenda.application.dtos.reference_dtos.ReferenceRegisterParams;
import kutuStech.wenda.domain.reference.Reference;


public interface ReferenceUseCases {
    Reference createReference(ReferenceRegisterParams reference);
    List<Reference> getAllReference();
    Reference getById(String referenceId);
}
