package mas.mockup.masMockup.persistence.products;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import mas.mockup.masMockup.persistence.accounts.SupplierEntity;
import mas.mockup.masMockup.persistence.products.description.DescriptionEntity;
import mas.mockup.masMockup.persistence.products.offerStatus.OfferStatusEntity;
import mas.mockup.masMockup.persistence.products.transperency.TransperencyEntity;

@Entity(name = "offers")
public class OfferEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offerid")
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

    @ManyToOne
    @JoinColumn(name = "offerStatus")
    private OfferStatusEntity offerStatusEntity;

    public OfferEntity() {
    }


    public OfferStatusEntity getOfferStatusEntity() {
        return offerStatusEntity;
    }


    public void setOfferStatusEntity(OfferStatusEntity offerStatusEntity) {
        this.offerStatusEntity = offerStatusEntity;
    }


    public SupplierEntity getSupplier() {
        return supplier;
    }


    public void setSupplier(SupplierEntity supplier) {
        this.supplier = supplier;
    }


    public OfferEntity(TransperencyEntity transparency, DescriptionEntity productdescription, double price, String imageurl,OfferStatusEntity offerStatusEntity, SupplierEntity supplier) {
     
        this.transparency = transparency;
        this.productdescription = productdescription;
        this.price = price;
        this.imageurl = imageurl;
        this.setSupplier(supplier);
        this.offerStatusEntity = offerStatusEntity;
    }

    public int getOfferId() {
        return this.articleId;
    }

    public void setOfferId(int articleId) {
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
