package mas.mockup.masMockup.web.database.banf;

import java.util.Date;
import java.util.Set;

import mas.mockup.masMockup.web.database.order.orderlineitem.OrderLineItemBodyOrder;

public class BanfBody {

    private Set<OrderLineItemBodyOrder> orderLineItems;
    private int accountInfoID;
    private BanfStatus status;
    private Date orderDate;
    private double rabatt;
    private double versandkosten;

    public BanfBody() {
    }

    public BanfBody(Set<OrderLineItemBodyOrder> orderLineItems, int accountInfoID, BanfStatus status, Date orderDate,
            double rabatt, double versandkosten) {
        this.orderLineItems = orderLineItems;
        this.accountInfoID = accountInfoID;
        this.status = status;
        this.orderDate = orderDate;
        this.rabatt = rabatt;
        this.versandkosten = versandkosten;
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

    public int getAccountInfoID() {
        return accountInfoID;
    }

    public void setAccountInfoID(int accountInfoID) {
        this.accountInfoID = accountInfoID;
    }

    public Set<OrderLineItemBodyOrder> getOrderLineItems() {
        return this.orderLineItems;
    }

    public void setOrderLineItems(Set<OrderLineItemBodyOrder> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public BanfStatus getStatus() {
        return this.status;
    }

    public void setStatus(BanfStatus status) {
        this.status = status;
    }

}
