package mas.mockup.masMockup.web.database.product;

import mas.mockup.masMockup.web.database.product.description.Productdescription;
import mas.mockup.masMockup.web.database.product.offerStatus.OfferStatus;
import mas.mockup.masMockup.web.database.product.transparency.Transparency;

public class Offer {

    private int offerID;
    private Transparency transparency;
    private Productdescription productdescription;
    private double price;
    
    private int supplierID;
    private String imageURl;
    private OfferStatus offerStatus;

    public Offer() {
    }

    public OfferStatus getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(OfferStatus offerStatus) {
        this.offerStatus = offerStatus;
    }

    public String getImageURl() {
        return imageURl;
    }

    public void setImageURl(String imageURl) {
        this.imageURl = imageURl;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public Offer(int offerID, Transparency transparency, Productdescription productdescription, double price,String imageUrl,OfferStatus offerStatus, int supplierID) {
        this.offerID = offerID;
        this.transparency = transparency;
        this.productdescription = productdescription;
        this.price = price;
        this.supplierID = supplierID;
        this.setImageURl(imageUrl);
        this.offerStatus = offerStatus;
    }

    public int getOfferID() {
        return this.offerID;
    }

    public void setOfferID(int articleId) {
        this.offerID = articleId;
    }

    public Transparency getTransparency() {
        return this.transparency;
    }

    public void setTransparency(Transparency transparency) {
        this.transparency = transparency;
    }

    public Productdescription getProductdescription() {
        return this.productdescription;
    }

    public void setProductdescription(Productdescription productdescription) {
        this.productdescription = productdescription;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
