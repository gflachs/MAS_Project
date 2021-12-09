package mas.mockup.masMockup.web.database.product;

import mas.mockup.masMockup.web.database.product.description.ProductdescriptionBody;

import mas.mockup.masMockup.web.database.product.transparency.TransparencyBody;

public class ArticleBody {

    private TransparencyBody transparency;
    private ProductdescriptionBody productdescription;
    private double price;
    private String imageurl;
    private int supplierID;
    private int lagermenge;
    private int mindestmenge;
    private double einkaufspreis;

    public ArticleBody() {

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

    public ArticleBody(TransparencyBody transparency, ProductdescriptionBody productdescription, double price,
            String imageurl, int supplierID, int lagermenge, int mindestmenge, double einkaufspreis) {
        this.transparency = transparency;
        this.productdescription = productdescription;
        this.price = price;
        this.imageurl = imageurl;
        this.supplierID = supplierID;
        this.setLagermenge(lagermenge);
        this.setMindestmenge(mindestmenge);
        this.setEinkaufspreis(einkaufspreis);
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
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

    public String getImageurl() {
        return this.imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

}
