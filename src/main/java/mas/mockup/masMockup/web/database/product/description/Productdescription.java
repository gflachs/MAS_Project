package mas.mockup.masMockup.web.database.product.description;


public class Productdescription {
    
    
    private int ID;
    private String produktname;
    private String description;
    private String ingridients;


    public Productdescription() {
    }

    public Productdescription(int ID,String produktname, String description, String ingridients) {
        this.ID = ID;
        this.produktname = produktname;
        this.description = description;
        this.ingridients = ingridients;
    }

    public void setID (int ID) {
        this.ID = ID;
    }

    public int getID () {
        return this.ID;
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
