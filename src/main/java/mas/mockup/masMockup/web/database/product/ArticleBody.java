package mas.mockup.masMockup.web.database.product;




import mas.mockup.masMockup.web.database.product.description.ProductdescriptionBody;

import mas.mockup.masMockup.web.database.product.transparency.TransparencyBody;

public class ArticleBody {

    private TransparencyBody transparency;
    private ProductdescriptionBody productdescription;
    private double price;
    private String imageurl;
    private int supplierID;


    public ArticleBody() {
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public ArticleBody(TransparencyBody transparency, ProductdescriptionBody productdescription, double price, String imageurl, int supplierID) {
    
        this.transparency = transparency;
        this.productdescription = productdescription;
        this.price = price;
        this.imageurl = imageurl;
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
