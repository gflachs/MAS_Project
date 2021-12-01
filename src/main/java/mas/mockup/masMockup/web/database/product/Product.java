package mas.mockup.masMockup.web.database.product;

public class Product {
    
    private int id;
    private String description;
    private float price;
    private String imageSrc;
    
    public Product(int id, String shortDescription, float price, String imageSrc) {
        this.setId(id);
        this.setShortDescription(shortDescription);
        this.setPrice(price);
        this.setImageSrc(imageSrc);
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getShortDescription() {
        return description;
    }

    public void setShortDescription(String shortDescription) {
        this.description = shortDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
