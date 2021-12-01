package mas.mockup.masMockup.persistence.orders.orderlineitem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import mas.mockup.masMockup.persistence.orders.OrderEntity;
import mas.mockup.masMockup.persistence.orders.orderlineitem.itemstatus.ItemStatusEntity;
import mas.mockup.masMockup.persistence.products.ArticleEntity;

@Entity(name = "orderlineitem")
public class OrderLineItemEntity {

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
    @JoinColumn(name = "orderid")
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "status")
    private ItemStatusEntity itemStatus;

    public OrderLineItemEntity(ArticleEntity article, int amount, double price,OrderEntity orderEntity, ItemStatusEntity itemStatus) {
        this.article = article;
        this.amount = amount;
        this.price = price;
        this.orderEntity = orderEntity;
        this.itemStatus = itemStatus;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public OrderLineItemEntity() {
    }

    public ItemStatusEntity getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatusEntity itemStatus) {
        this.itemStatus = itemStatus;
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
    
}
