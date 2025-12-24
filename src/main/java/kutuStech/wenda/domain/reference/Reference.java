package kutuStech.wenda.domain.reference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reference {
    private String id;
    private String url;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}