package mas.mockup.masMockup.web.database.product;


import mas.mockup.masMockup.web.database.product.description.ProductdescriptionBody;
import mas.mockup.masMockup.web.database.product.offerStatus.OfferStatus;
import mas.mockup.masMockup.web.database.product.transparency.TransparencyBody;

public class OfferBody {

   
    private TransparencyBody transparency;
    private ProductdescriptionBody productdescription;
    private double price;
    private int supplierID;
    private String imageURL;
    private OfferStatus offerStatus;
    

    public OfferBody() {
    }

    public OfferStatus getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(OfferStatus offerStatus) {
        this.offerStatus = offerStatus;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public OfferBody( TransparencyBody transparency, ProductdescriptionBody productdescription, double price,String imageURL,OfferStatus offerStatus, int supplierID) {
   
        this.transparency = transparency;
        this.productdescription = productdescription;
        this.price = price;
        this.setSupplierID(supplierID);
        this.setImageURL(imageURL);
        this.setOfferStatus(offerStatus);
    }


    public TransparencyBody getTransparency() {
        return this.transparency;
    }

    public void setTransparency(TransparencyBody transparency) {
        this.transparency = transparency;
    }

    public ProductdescriptionBody getProductdescription() {
        return this.productdescription;
    }

    public void setProductdescription(ProductdescriptionBody productdescription) {
        this.productdescription = productdescription;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

 

    
}
