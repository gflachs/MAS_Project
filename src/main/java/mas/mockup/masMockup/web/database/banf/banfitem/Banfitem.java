package mas.mockup.masMockup.web.database.banf.banfitem;

import mas.mockup.masMockup.web.database.order.orderlineitem.itemstatus.ItemStatus;

public class Banfitem {

    private int itemID;
    private int articleID;
    private int amount;
    private double price;
    private int orderID;
    private ItemStatus itemStatus;

    public Banfitem(int itemID, int articleID, int amount, double price, int orderId, ItemStatus itemStatus) {
        this.itemID = itemID;
        this.articleID = articleID;
        this.amount = amount;
        this.price = price;
        this.setOrderID(orderId);
        this.itemStatus = itemStatus;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Banfitem() {
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    public int getItemID() {
        return this.itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
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
