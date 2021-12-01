package mas.mockup.masMockup.web.database.product.description;


public class ProductdescriptionBody {
  
    private String produktname;
    private String description;
    private String ingridients;


    public ProductdescriptionBody() {
    }

    public ProductdescriptionBody(String produktname, String description, String ingridients) {
    
        this.produktname = produktname;
        this.description = description;
        this.ingridients = ingridients;
    }

  

    public String getProduktname() {
        return this.produktname;
    }

    public void setProduktname(String produktname) {
        this.produktname = produktname;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngridients() {
        return this.ingridients;
    }

    public void setIngridients(String ingridients) {
        this.ingridients = ingridients;
    }

}
