package mas.mockup.masMockup.persistence.orders.orderlineitem.itemstatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemStatusRepository extends JpaRepository<ItemStatusEntity,String>{
    
}
