package mas.mockup.masMockup.web.database.product.transparency;



import mas.mockup.masMockup.web.database.accounts.adress.Adress;


public class Transparency {
    
    private int id;
    private String produzent;
    private Adress produktionsort;

    public Transparency() {
    }

    public Transparency (int id, String produzent, Adress produktionsort) {
        this.id = id;
        this.produzent = produzent;
        this.produktionsort = produktionsort;
    }

    public void setid (int id) {
        this.id = id;
    }

    public int getid () {
        return this.id;
    }

    public String getProduzent() {
        return this.produzent;
    }

    public void setProduzent(String produzent) {
        this.produzent = produzent;
    }

    public Adress getProduktionsort() {
        return this.produktionsort;
    }

    public void setProduktionsort(Adress produktionsort) {
        this.produktionsort = produktionsort;
    }
    
    
}
