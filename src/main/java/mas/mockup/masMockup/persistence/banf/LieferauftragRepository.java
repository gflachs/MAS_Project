package mas.mockup.masMockup.persistence.banf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LieferauftragRepository extends JpaRepository<LieferauftragEntity, Long> {

}
