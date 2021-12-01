package mas.mockup.masMockup.persistence.orders.orderlineitem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mas.mockup.masMockup.persistence.orders.orderlineitem.itemstatus.ItemStatusEntity;

@Repository
public interface OrderLineItemRepository extends JpaRepository<OrderLineItemEntity,Integer> {
    
    List<OrderLineItemEntity> findAllByItemStatus(ItemStatusEntity itemStatusEntity);
    
}
