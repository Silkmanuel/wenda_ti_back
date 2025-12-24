package kutuStech.wenda.adapters.inbound;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.RequestBody;
import kutuStech.wenda.application.dtos.subpoint_dtos.SubpointRegisterParams;
import kutuStech.wenda.application.services.SubpointService;
import kutuStech.wenda.domain.subpoint.Subpoint;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/subpoint")
@RequiredArgsConstructor
@SecurityRequirement(name = "ApiKeyAuth")  
@SecurityRequirement(name = "Bearer Authentication")  
public class SubpointController {
    private final SubpointService subpointService;

    @PostMapping
    public ResponseEntity<Subpoint> createSubpoint(@RequestBody SubpointRegisterParams subpoint) {
        return ResponseEntity.ok(subpointService.createSubpoint(subpoint));
    }

    @GetMapping("{id}")
    public ResponseEntity<Subpoint> getById(@PathVariable String subpointId) {
        return ResponseEntity.ok(subpointService.getById(subpointId));
    } 
    
    @GetMapping
    public ResponseEntity<List<Subpoint>> getAll() {
        return ResponseEntity.ok(subpointService.getAll());
    } 
}
