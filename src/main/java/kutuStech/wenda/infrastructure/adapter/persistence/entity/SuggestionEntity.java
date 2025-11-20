package kutuStech.wenda.infrastructure.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "suggestion")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SuggestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private Boolean deleted;
    private String email;
    @OneToOne
    @JoinColumn(name = "id_word")
    private WordEntity word;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
