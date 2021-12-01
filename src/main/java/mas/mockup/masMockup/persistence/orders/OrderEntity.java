package mas.mockup.masMockup.persistence.orders;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import mas.mockup.masMockup.persistence.accounts.AccountInfoEntity;
import mas.mockup.masMockup.persistence.orders.orderlineitem.OrderLineItemEntity;

@Entity(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private int id;

    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL)
    private Set<OrderLineItemEntity> orderLineItems;

    @ManyToOne
    @JoinColumn(name = "orderstatusid")
    private OrderStatusEntity orderStatusEntity;
    @ManyToOne
    @JoinColumn(name = "accountid")
    private AccountInfoEntity accountInfoEntity;
    

    public OrderEntity() {
    }

    public AccountInfoEntity getAccountInfoEntity() {
        return accountInfoEntity;
    }

    public void setAccountInfoEntity(AccountInfoEntity accountInfoEntity) {
        this.accountInfoEntity = accountInfoEntity;
    }

    public OrderEntity(OrderStatusEntity orderStatusEntity, AccountInfoEntity accountInfoEntity) {
        this.orderStatusEntity = orderStatusEntity;
        this.accountInfoEntity = accountInfoEntity;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<OrderLineItemEntity> getOrderLineItems() {
        return this.orderLineItems;
    }

    public void setOrderLineItems(Set<OrderLineItemEntity> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public OrderStatusEntity getStatus() {
        return this.orderStatusEntity;
    }

    public void setStatus(OrderStatusEntity orderStatusEntity) {
        this.orderStatusEntity = orderStatusEntity;
    }

}
