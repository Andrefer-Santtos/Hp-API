package write.your.magic.hp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import write.your.magic.hp.model.Ravenclaw;

@Repository
public interface RavenclawRepository extends JpaRepository<Ravenclaw, Integer> {
}
