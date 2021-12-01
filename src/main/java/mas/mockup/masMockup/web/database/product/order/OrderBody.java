package mas.mockup.masMockup.web.database.product.order;

import java.util.Set;

import mas.mockup.masMockup.web.database.product.order.orderlineitem.OrderLineItemBodyOrder;

public class OrderBody {
    

    private Set<OrderLineItemBodyOrder> orderLineItems;
    private int accountInfoID;
    private OrderStatus status;

    public OrderBody() {
    }

    public int getAccountInfoID() {
        return accountInfoID;
    }

    public void setAccountInfoID(int accountInfoID) {
        this.accountInfoID = accountInfoID;
    }

    public OrderBody(Set<OrderLineItemBodyOrder> orderLineItems,int accountInfoID, OrderStatus status) {
      
        this.orderLineItems = orderLineItems;
        this.accountInfoID = accountInfoID;
        this.status = status;
    }

    public Set<OrderLineItemBodyOrder> getOrderLineItems() {
        return this.orderLineItems;
    }

    public void setOrderLineItems(Set<OrderLineItemBodyOrder> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }


}
