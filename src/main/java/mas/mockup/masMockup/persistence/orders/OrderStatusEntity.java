package mas.mockup.masMockup.persistence.orders;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "orderstatus")
public class OrderStatusEntity {
    
    @Id
    private String orderStatus;

    @OneToMany(mappedBy = "orderStatusEntity", fetch = FetchType.LAZY)
    private Set<OrderEntity> orderEntitys;

    public OrderStatusEntity() {
    }
    

    public Set<OrderEntity> getOrderEntitys() {
        return orderEntitys;
    }


    public void setOrderEntitys(Set<OrderEntity> orderEntitys) {
        this.orderEntitys = orderEntitys;
    }


    public OrderStatusEntity(String orderStatus) {
        this.orderStatus = orderStatus;
    }


    public String getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

}
