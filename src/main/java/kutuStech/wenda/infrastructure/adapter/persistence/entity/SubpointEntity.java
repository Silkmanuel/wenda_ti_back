package kutuStech.wenda.infrastructure.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "subpoint")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubpointEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String description;
    @Column(name = "createdAt")
    private LocalDateTime createdAt;
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;
}
