package kutuStech.wenda.adapters.output.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "word")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private String description;
    private Boolean deleted;
    @ManyToOne
    @JoinColumn(name = "idCreator")
    private JpaUserEntity userEntity;
    @ManyToOne
    @JoinColumn(name = "idSuggestion")
    private SuggestionEntity suggestionEntity;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
        name = "word_subpoint",
        joinColumns = @JoinColumn(name = "word_id"),
        inverseJoinColumns = @JoinColumn(name = "subpoint_id")
    )
    private List<SubpointEntity> subpoints;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
        name = "word_reference",
        joinColumns = @JoinColumn(name = "word_id"),
        inverseJoinColumns = @JoinColumn(name = "reference_id")
    )
    private List<ReferenceEntity> references;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
