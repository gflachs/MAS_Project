package mas.mockup.masMockup.persistence.banf.banfitem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import mas.mockup.masMockup.persistence.banf.LieferauftragEntity;
import mas.mockup.masMockup.persistence.banf.banfitem.itemstatus.ItemStatusEntity;
import mas.mockup.masMockup.persistence.products.ArticleEntity;

@Entity(name = "banfitem")
public class BanfItemEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "itemid")
    private int itemID;

    @ManyToOne
    @JoinColumn(name = "articleid")
    private ArticleEntity article;
    @Column(name = "bestellmenge")
    private int amount;
    @Column(name = "bestellpreis")
    private double price;

    @ManyToOne
    @JoinColumn(name = "status")
    private ItemStatusEntity itemStatus;

    @ManyToOne
    @JoinColumn(name = "lieferauftragsid")
    private LieferauftragEntity lieferauftragEntity;

    public BanfItemEntity(ArticleEntity article, int amount, double price,
            ItemStatusEntity itemStatus, LieferauftragEntity lieferauftragEntity) {

        this.article = article;
        this.amount = amount;
        this.price = price;
        this.itemStatus = itemStatus;
        this.setLieferauftragEntity(lieferauftragEntity);
    }

    public LieferauftragEntity getLieferauftragEntity() {
        return lieferauftragEntity;
    }

    public void setLieferauftragEntity(LieferauftragEntity lieferauftragEntity) {
        this.lieferauftragEntity = lieferauftragEntity;
    }

    public BanfItemEntity() {
    }

    public int getItemID() {
        return this.itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public ArticleEntity getArticle() {
        return this.article;
    }

    public void setArticle(ArticleEntity article) {
        this.article = article;
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

    public ItemStatusEntity getItemStatus() {
        return this.itemStatus;
    }

    public void setItemStatus(ItemStatusEntity itemStatus) {
        this.itemStatus = itemStatus;
    }

}
