package kutuStech.wenda.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Subpoint {
    private String id;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
