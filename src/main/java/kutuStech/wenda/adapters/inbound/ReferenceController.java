package kutuStech.wenda.adapters.inbound;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.web.bind.annotation.RequestBody;
import kutuStech.wenda.application.dtos.reference_dtos.ReferenceRegisterParams;
import kutuStech.wenda.application.services.ReferenceService;
import kutuStech.wenda.domain.reference.Reference;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/reference")
@RequiredArgsConstructor
@SecurityRequirement(name = "ApiKeyAuth")  
@SecurityRequirement(name = "Bearer Authentication")  
public class ReferenceController {
    private final ReferenceService referenceService;
    
    @PostMapping
    public ResponseEntity<Reference> createReference(@RequestBody ReferenceRegisterParams reference) {
        return ResponseEntity.ok(referenceService.createReference(reference));
    }

    @GetMapping
    public ResponseEntity<List<Reference>> getAllReferences() {
        return ResponseEntity.ok(referenceService.getAllReference());
    }
    
}
