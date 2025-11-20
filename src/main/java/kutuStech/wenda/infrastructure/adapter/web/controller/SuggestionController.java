package kutuStech.wenda.infrastructure.adapter.web.controller;

import kutuStech.wenda.application.port.input.SuggestionServicePort;
import kutuStech.wenda.domain.model.Suggestion;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suggestion")
@RequiredArgsConstructor
public class SuggestionController {

    private final SuggestionServicePort suggestionServicePort;

    @PostMapping
    public ResponseEntity<Suggestion> createSugestao(@RequestBody Suggestion suggestion) {
        return ResponseEntity.ok(suggestionServicePort.createSuggestion(suggestion));
    }

    @GetMapping
    public ResponseEntity<List<Suggestion>> getAllSugestoes() {
        return ResponseEntity.ok(suggestionServicePort.getAllSuggestions());
    }
}
