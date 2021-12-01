package mas.mockup.masMockup.web.database.product.order.orderlineitem;

import mas.mockup.masMockup.web.database.product.order.orderlineitem.itemstatus.ItemStatus;

public class OrderLineItemBody {
    
    private int articleID;
    private int amount;
    private double price;
    private int orderID;
    private ItemStatus itemStatus;

    public OrderLineItemBody( int articleID, int amount, double price,int orderID, ItemStatus itemStatus) {
        this.articleID = articleID;
        this.amount = amount;
        this.price = price;
        this.orderID = orderID;
        this.itemStatus = itemStatus;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    public OrderLineItemBody() {
    }

    public int getArticleID() {
        return this.articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



}