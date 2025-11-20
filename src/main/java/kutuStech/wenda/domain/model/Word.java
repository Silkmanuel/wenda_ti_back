package kutuStech.wenda.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Word {
    private String id;
    private String title;
    private Boolean deleted;
    private String description;
    private String idCreator;
    private List<Subpoint> subpoints;
    private List<Reference> references;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
