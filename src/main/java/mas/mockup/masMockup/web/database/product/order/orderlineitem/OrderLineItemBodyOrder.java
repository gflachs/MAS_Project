package mas.mockup.masMockup.web.database.product.order.orderlineitem;

import mas.mockup.masMockup.web.database.product.order.orderlineitem.itemstatus.ItemStatus;

public class OrderLineItemBodyOrder {
    
    private int articleID;
    private int amount;
    private double price;
    private ItemStatus itemStatus;


    public OrderLineItemBodyOrder() {
    }

    public OrderLineItemBodyOrder(int articleID, int amount, double price, ItemStatus itemStatus) {
        this.articleID = articleID;
        this.amount = amount;
        this.price = price;
        this.itemStatus = itemStatus;
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

    public ItemStatus getItemStatus() {
        return this.itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

}
