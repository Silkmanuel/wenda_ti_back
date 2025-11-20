package kutuStech.wenda.infrastructure.adapter.web.controller;

import kutuStech.wenda.application.port.input.WordServicePort;
import kutuStech.wenda.domain.model.Word;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/word")
@RequiredArgsConstructor
public class WordController {

    private final WordServicePort wordServicePort;

    @PostMapping
    public ResponseEntity<Word> createPalavra(@RequestBody Word word) {
        return ResponseEntity.ok(wordServicePort.createWord(word));
    }

    @GetMapping
    public ResponseEntity<List<Word>> getAllPalavras() {
        return ResponseEntity.ok(wordServicePort.getAllWords());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Word> getPalavraById(@PathVariable String id) {
        return ResponseEntity.ok(wordServicePort.getWordById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePalavra(@PathVariable String id) {
        wordServicePort.deleteWord(id);
        return ResponseEntity.noContent().build();
    }
}
