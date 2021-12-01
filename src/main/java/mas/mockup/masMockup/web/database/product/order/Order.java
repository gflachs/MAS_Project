package mas.mockup.masMockup.web.database.product.order;

import java.util.Set;

import mas.mockup.masMockup.web.database.product.order.orderlineitem.OrderLineItem;

public class Order {
    
    private int orderID;
    private Set<OrderLineItem> orderLineItems;
    private int acoountInfoID;
    private OrderStatus status;

    public Order() {
    }

    public int getAcoountInfoID() {
        return acoountInfoID;
    }

    public void setAcoountInfoID(int acoountInfoID) {
        this.acoountInfoID = acoountInfoID;
    }

    public Order(int id, Set<OrderLineItem> orderLineItems,int accountInfoID, OrderStatus status) {
        this.orderID = id;
        this.orderLineItems = orderLineItems;
        this.acoountInfoID = accountInfoID;
        this.status = status;
    }

    public int getOrderID() {
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
