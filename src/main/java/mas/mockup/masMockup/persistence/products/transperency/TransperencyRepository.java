package mas.mockup.masMockup.persistence.products.transperency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransperencyRepository extends JpaRepository<TransperencyEntity, Integer>{
    
}
