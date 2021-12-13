package mas.mockup.masMockup.persistence.products;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import mas.mockup.masMockup.persistence.accounts.SupplierEntity;
import mas.mockup.masMockup.persistence.banf.banfitem.BanfItemEntity;
import mas.mockup.masMockup.persistence.orders.orderlineitem.OrderLineItemEntity;
import mas.mockup.masMockup.persistence.products.description.DescriptionEntity;
import mas.mockup.masMockup.persistence.products.transperency.TransperencyEntity;

@Entity(name = "articles")
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "articleid")
    private int articleId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transperenceid")
    private TransperencyEntity transparency;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productdescriptionid")
    private DescriptionEntity productdescription;
    @Column(name = "preis")
    private double price;
    @Column(name = "bild")
    private String imageurl;
    @ManyToOne
    @JoinColumn(name = "supplierid")
    private SupplierEntity supplier;
    @Column(name = "lagermenge")
    private int lagermenge;
    @Column(name = "mindestmenge")
    private int mindestmenge;
    @Column(name = "einkaufspreis")
    private double einkaufspreis;

    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
    private Set<OrderLineItemEntity> orderLineItems;

    @OneToMany(mappedBy = "article")
    private Set<BanfItemEntity> banfItemEntities;

    public ArticleEntity() {
    }

    public Set<BanfItemEntity> getBanfItemEntities() {
        return banfItemEntities;
    }

    public void setBanfItemEntities(Set<BanfItemEntity> banfItemEntities) {
        this.banfItemEntities = banfItemEntities;
    }

    public ArticleEntity(TransperencyEntity transparency, DescriptionEntity productdescription, double price,
            String imageurl, SupplierEntity supplier, int lagermenge, int mindestmenge, double einkaufspreis) {
        this.transparency = transparency;
        this.productdescription = productdescription;
        this.price = price;
        this.imageurl = imageurl;
        this.supplier = supplier;
        this.lagermenge = lagermenge;
        this.mindestmenge = mindestmenge;
        this.einkaufspreis = einkaufspreis;
    }

    public double getEinkaufspreis() {
        return einkaufspreis;
    }

    public void setEinkaufspreis(double einkaufspreis) {
        this.einkaufspreis = einkaufspreis;
    }

    public int getMindestmenge() {
        return mindestmenge;
    }

    public void setMindestmenge(int mindestmenge) {
        this.mindestmenge = mindestmenge;
    }

    public int getLagermenge() {
        return lagermenge;
    }

    public void setLagermenge(int lagermenge) {
        this.lagermenge = lagermenge;
    }

    public Set<OrderLineItemEntity> getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(Set<OrderLineItemEntity> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }

    public SupplierEntity getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierEntity supplier) {
        this.supplier = supplier;
    }

    public int getArticleId() {
        return this.articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public TransperencyEntity getTransparency() {
        return this.transparency;
    }

    public void setTransparency(TransperencyEntity transparency) {
        this.transparency = transparency;
    }

    public DescriptionEntity getProductdescription() {
        return this.productdescription;
    }

    public void setProductdescription(DescriptionEntity productdescription) {
        this.productdescription = productdescription;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageurl() {
        return this.imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
