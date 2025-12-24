package kutuStech.wenda.adapters.output.repository.subpoint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kutuStech.wenda.adapters.output.entity.SubpointEntity;

@Repository
public interface SubpointJpaRepository extends JpaRepository<SubpointEntity, String> {}