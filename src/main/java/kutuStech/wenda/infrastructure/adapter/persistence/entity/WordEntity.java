package kutuStech.wenda.infrastructure.adapter.persistence.entity;

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
    private UserEntity userEntity;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "word_subpoint",
        joinColumns = @JoinColumn(name = "word_id"),
        inverseJoinColumns = @JoinColumn(name = "subpoint_id")
    )
    private List<SubpointEntity> subpoints;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "word_reference",
        joinColumns = @JoinColumn(name = "word_id"),
        inverseJoinColumns = @JoinColumn(name = "reference_id")
    )
    private List<ReferenceEntity> references;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
