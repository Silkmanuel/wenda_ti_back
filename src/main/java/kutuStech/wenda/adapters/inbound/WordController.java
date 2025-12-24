package kutuStech.wenda.adapters.inbound;

import kutuStech.wenda.application.dtos.word_dtos.WordRegisterParams;
import kutuStech.wenda.application.services.WordService;
import kutuStech.wenda.domain.word.Word;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

@RestController
@RequestMapping("/api/word")
@RequiredArgsConstructor
@SecurityRequirement(name = "ApiKeyAuth")  
@SecurityRequirement(name = "Bearer Authentication")  
public class WordController {
    private final WordService wordService;

//    /api/word/all
//    /api/word/search


    @PostMapping("/register")
    public ResponseEntity<Word> createPalavra(@RequestBody WordRegisterParams word) {
        return ResponseEntity.ok(wordService.createWord(word));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Word>> getAllPalavras() {
        return ResponseEntity.ok(wordService.getAllWords());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Word> getPalavraById(@PathVariable String id) {
        return ResponseEntity.ok(wordService.getWordById(id));
    }

    @GetMapping("/search/{word}")
    public ResponseEntity<List<Word>> getPalavraByCaracter(@PathVariable String word) {
        return ResponseEntity.ok(wordService.getWordByCaracters(word));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePalavra(@PathVariable String id) {
        wordService.deleteWord(id);
        return ResponseEntity.noContent().build();
    }
}
