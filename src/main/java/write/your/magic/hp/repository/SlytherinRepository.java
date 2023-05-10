package write.your.magic.hp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import write.your.magic.hp.model.Slytherin;

@Repository
public interface SlytherinRepository extends JpaRepository<Slytherin, Integer> {
}
