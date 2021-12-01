package mas.mockup.masMockup.persistence.orders.orderlineitem.itemstatus;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import mas.mockup.masMockup.persistence.orders.orderlineitem.OrderLineItemEntity;

@Entity(name = "orderlineitemstatus")
public class ItemStatusEntity {
    
    @Id
    private String itemStatus;

    @OneToMany(mappedBy = "itemStatus", fetch = FetchType.LAZY)
    private Set<OrderLineItemEntity> orderLineItemEntity;

    public ItemStatusEntity() {
    }

    public Set<OrderLineItemEntity> getOrderLineItemEntity() {
        return orderLineItemEntity;
    }

    public void setOrderLineItemEntity(Set<OrderLineItemEntity> orderLineItemEntity) {
        this.orderLineItemEntity = orderLineItemEntity;
    }

    public ItemStatusEntity(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }
}
