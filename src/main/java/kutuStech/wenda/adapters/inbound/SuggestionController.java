package kutuStech.wenda.adapters.inbound;

import kutuStech.wenda.application.dtos.suggestion.SuggestionRegisterParams;
import kutuStech.wenda.application.services.SuggestionService;
import kutuStech.wenda.domain.suggestion.Suggestion;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

@RestController
@RequestMapping("/api/suggestion")
@RequiredArgsConstructor
@SecurityRequirement(name = "ApiKeyAuth")  
@SecurityRequirement(name = "Bearer Authentication")  
public class SuggestionController {

    private final SuggestionService suggestionService;

    @PostMapping
    public ResponseEntity<Suggestion> createSugestao(@RequestBody SuggestionRegisterParams suggestion) {
        return ResponseEntity.ok(suggestionService.createSuggestion(suggestion));
    }

    @GetMapping
    public ResponseEntity<List<Suggestion>> getAllSugestoes() {
        return ResponseEntity.ok(suggestionService.getAllSuggestions());
    }
    @GetMapping("/available")
    public ResponseEntity<List<Suggestion>> getAllSugestoesAvailable() {
        return ResponseEntity.ok(suggestionService.getAllSuggestionsAvailable());
    }
}
