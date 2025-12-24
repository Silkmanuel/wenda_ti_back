package kutuStech.wenda.adapters.output.repository.word;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kutuStech.wenda.adapters.output.entity.WordEntity;

@Repository
public interface WordJpaRepository extends JpaRepository<WordEntity, String> {
    List<WordEntity> findByTitleContainingIgnoreCaseAndDeletedFalse(String title);
}
