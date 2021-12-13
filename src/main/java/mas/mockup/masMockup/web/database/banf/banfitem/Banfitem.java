package mas.mockup.masMockup.web.database.banf.banfitem;

import mas.mockup.masMockup.web.database.banf.banfitem.itemstatus.ItemStatus;

public class Banfitem {

    private int itemID;
    private int articleID;
    private int amount;
    private double price;
    private long banfID;
    private ItemStatus itemStatus;

    public Banfitem(int itemID, int articleID, int amount, double price, long banfID, ItemStatus itemStatus) {
        this.itemID = itemID;
        this.articleID = articleID;
        this.amount = amount;
        this.price = price;
        this.setBanfID(banfID);
        this.itemStatus = itemStatus;
    }

    public long getBanfID() {
        return banfID;
    }

    public void setBanfID(long banfID) {
        this.banfID = banfID;
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
