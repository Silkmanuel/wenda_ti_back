package kutuStech.wenda.adapters.output.repository.reference;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kutuStech.wenda.adapters.output.entity.ReferenceEntity;

@Repository
public interface ReferenceJpaRepository extends JpaRepository<ReferenceEntity, String> {
    
}
