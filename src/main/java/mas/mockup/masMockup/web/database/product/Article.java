package mas.mockup.masMockup.web.database.product;
import mas.mockup.masMockup.web.database.product.description.Productdescription;
import mas.mockup.masMockup.web.database.product.transparency.Transparency;

public class Article {

    private int articleId;
    private Transparency transparency;
    private Productdescription productdescription;
    private double price;
    private String imageurl;
    private int supplierID;

    public Article() {
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public Article(int articleId, Transparency transparency, Productdescription productdescription, double price, String imageurl, int supplierID) {
        this.articleId = articleId;
        this.transparency = transparency;
        this.productdescription = productdescription;
        this.price = price;
        this.imageurl = imageurl;
        this.supplierID = supplierID;
    }

    public int getArticleId() {
        return this.articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
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

    public String getImageurl() {
        return this.imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }



    
}
