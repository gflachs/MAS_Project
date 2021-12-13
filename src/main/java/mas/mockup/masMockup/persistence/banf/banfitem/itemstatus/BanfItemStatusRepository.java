package mas.mockup.masMockup.persistence.banf.banfitem.itemstatus;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BanfItemStatusRepository extends JpaRepository<ItemStatusEntity, String> {

}
