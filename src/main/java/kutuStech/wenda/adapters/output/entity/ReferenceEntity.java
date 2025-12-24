package kutuStech.wenda.adapters.output.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "reference")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReferenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String url;
    private String description;
    @ManyToMany(mappedBy = "references")
    private List<WordEntity> words;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
