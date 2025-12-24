package kutuStech.wenda.domain.suggestion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Suggestion {
    private String id;
    private String title;
    private Boolean deleted;
    private String email;
    private String idWord;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
