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
    @Column(name = "price")
    private double price;
    @Column(name = "imageurl")
    private String imageurl;
    @ManyToOne
    @JoinColumn(name = "supplierid")
    private SupplierEntity supplier;

    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
    private Set<OrderLineItemEntity> orderLineItems;

    public ArticleEntity() {
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


    public ArticleEntity(TransperencyEntity transparency, DescriptionEntity productdescription, double price, String imageurl, SupplierEntity supplier) {
     
        this.transparency = transparency;
        this.productdescription = productdescription;
        this.price = price;
        this.imageurl = imageurl;
        this.setSupplier(supplier);
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
