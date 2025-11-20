package kutuStech.wenda.infrastructure.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
