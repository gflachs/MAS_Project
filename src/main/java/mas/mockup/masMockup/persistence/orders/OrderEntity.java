package mas.mockup.masMockup.persistence.orders;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import mas.mockup.masMockup.persistence.accounts.AccountInfoEntity;
import mas.mockup.masMockup.persistence.orders.orderlineitem.OrderLineItemEntity;

@Entity(name = "orders")
public class OrderEntity {

    @Id
    @Column(name = "orderid")
    private long id;
    @Column(name = "orderdatum")
    private Date orderDate;
    @Column(name = "rabatt")
    private double rabatt;
    @Column(name = "versandkosten")
    private double versandkosten;

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

    public OrderEntity(long id, Date orderDate, double rabatt, double versandkosten,
            OrderStatusEntity orderStatusEntity,
            AccountInfoEntity accountInfoEntity) {
        this.id = id;
        this.orderDate = orderDate;
        this.rabatt = rabatt;
        this.versandkosten = versandkosten;
        this.orderStatusEntity = orderStatusEntity;
        this.accountInfoEntity = accountInfoEntity;
    }

    public double getVersandkosten() {
        return versandkosten;
    }

    public void setVersandkosten(double versandkosten) {
        this.versandkosten = versandkosten;
    }

    public double getRabatt() {
        return rabatt;
    }

    public void setRabatt(double rabatt) {
        this.rabatt = rabatt;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public AccountInfoEntity getAccountInfoEntity() {
        return accountInfoEntity;
    }

    public void setAccountInfoEntity(AccountInfoEntity accountInfoEntity) {
        this.accountInfoEntity = accountInfoEntity;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
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
