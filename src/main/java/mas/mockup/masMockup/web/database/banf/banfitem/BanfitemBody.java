package mas.mockup.masMockup.web.database.banf.banfitem;

import mas.mockup.masMockup.web.database.banf.banfitem.itemstatus.ItemStatus;

public class BanfitemBody {

    private int articleID;
    private int amount;
    private double price;
    private long banfID;
    private ItemStatus itemStatus;

    public BanfitemBody(int articleID, int amount, double price, long banfID, ItemStatus itemStatus) {
        this.articleID = articleID;
        this.amount = amount;
        this.price = price;
        this.banfID = banfID;
        this.itemStatus = itemStatus;
    }

    public long getBanfID() {
        return banfID;
    }

    public void setOrdsetBanfID(long banfID) {
        this.banfID = banfID;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    public BanfitemBody() {
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
