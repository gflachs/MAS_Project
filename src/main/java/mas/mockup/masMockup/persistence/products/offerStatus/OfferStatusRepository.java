package mas.mockup.masMockup.persistence.products.offerStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferStatusRepository extends JpaRepository<OfferStatusEntity, String> {
    
}
