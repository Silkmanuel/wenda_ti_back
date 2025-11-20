package kutuStech.wenda.infrastructure.adapter.persistence.mapper;

import kutuStech.wenda.domain.model.*;
import kutuStech.wenda.infrastructure.adapter.persistence.entity.*;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Collectors;

@Component
public class PersistenceMapper {

    public User toDomain(UserEntity entity) {
        if (entity == null) return null;
        return User.builder()
                .id(entity.getId())
                .name(entity.getName())
                .phoneNumber(entity.getPhoneNumber())
                .password(entity.getPassword())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public UserEntity toEntity(User domain) {
        if (domain == null) return null;
        return UserEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .phoneNumber(domain.getPhoneNumber())
                .password(domain.getPassword())
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdatedAt())
                .build();
    }

    public Subpoint toDomain(SubpointEntity entity) {
        if (entity == null) return null;
        return Subpoint.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public SubpointEntity toEntity(Subpoint domain) {
        if (domain == null) return null;
        return SubpointEntity.builder()
                .id(domain.getId())
                .description(domain.getDescription())
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdatedAt())
                .build();
    }

    public Reference toDomain(ReferenceEntity entity) {
        if (entity == null) return null;
        return Reference.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public ReferenceEntity toEntity(Reference domain) {
        if (domain == null) return null;
        return ReferenceEntity.builder()
                .id(domain.getId())
                .description(domain.getDescription())
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdatedAt())
                .build();
    }

    public Word toDomain(WordEntity entity) {
        if (entity == null) return null;
        return Word.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .deleted(entity.getDeleted())
                .description(entity.getDescription())
                .idCreator(entity.getUserEntity() != null ? entity.getUserEntity().getId() : null)
                .subpoints(entity.getSubpoints() != null ? entity.getSubpoints().stream().map(this::toDomain).collect(Collectors.toList()) : Collections.emptyList())
                .references(entity.getReferences() != null ? entity.getReferences().stream().map(this::toDomain).collect(Collectors.toList()) : Collections.emptyList())
                .build();
    }

    public WordEntity toEntity(Word domain) {
        if (domain == null) return null;
        return WordEntity.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdatedAt())
                .deleted(domain.getDeleted())
                .description(domain.getDescription())
                .userEntity(domain.getIdCreator() != null ? UserEntity.builder().id(domain.getIdCreator()).build() : null) // Only ID is needed for mapping usually, or fetch from DB if needed
                .subpoints(domain.getSubpoints() != null ? domain.getSubpoints().stream().map(this::toEntity).collect(Collectors.toList()) : null)
                .references(domain.getReferences() != null ? domain.getReferences().stream().map(this::toEntity).collect(Collectors.toList()) : null)
                .build();
    }

    public Suggestion toDomain(SuggestionEntity entity) {
        if (entity == null) return null;
        return Suggestion.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .deleted(entity.getDeleted())
                .email(entity.getEmail())
                .idWord(entity.getWord() != null ? entity.getWord().getId() : null)
                .build();
    }

    public SuggestionEntity toEntity(Suggestion domain) {
        if (domain == null) return null;
        return SuggestionEntity.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdatedAt())
                .deleted(domain.getDeleted())
                .email(domain.getEmail())
                .word(domain.getIdWord() != null ? WordEntity.builder().id(domain.getIdWord()).build() : null)
                .build();
    }
}
