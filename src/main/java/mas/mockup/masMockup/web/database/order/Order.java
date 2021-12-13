package mas.mockup.masMockup.web.database.order;

import java.util.Date;
import java.util.Set;

import mas.mockup.masMockup.web.database.order.orderlineitem.OrderLineItem;

public class Order {

    private long orderID;
    private Date orderDate;
    private double rabatt;
    private double versandkosten;
    private Set<OrderLineItem> orderLineItems;
    private int acoountInfoID;
    private OrderStatus status;

    public Order() {
    }

    public Order(long orderID, Date orderDate, double rabatt, double versandkosten, Set<OrderLineItem> orderLineItems,
            int acoountInfoID, OrderStatus status) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.rabatt = rabatt;
        this.versandkosten = versandkosten;
        this.orderLineItems = orderLineItems;
        this.acoountInfoID = acoountInfoID;
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getRabatt() {
        return rabatt;
    }

    public void setRabatt(double rabatt) {
        this.rabatt = rabatt;
    }

    public double getVersandkosten() {
        return versandkosten;
    }

    public void setVersandkosten(double versandkosten) {
        this.versandkosten = versandkosten;
    }

    public int getAcoountInfoID() {
        return acoountInfoID;
    }

    public void setAcoountInfoID(int acoountInfoID) {
        this.acoountInfoID = acoountInfoID;
    }

    public long getOrderID() {
        return this.orderID;
    }

    public void setOrderID(int id) {
        this.orderID = id;
    }

    public Set<OrderLineItem> getOrderLineItems() {
        return this.orderLineItems;
    }

    public void setOrderLineItems(Set<OrderLineItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

}
