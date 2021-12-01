package mas.mockup.masMockup.web.database.product.transparency;

import mas.mockup.masMockup.web.database.accounts.adress.AdressBody;


public class TransparencyBody {
    
    private String produzent;
    private AdressBody produktionsort;

    public TransparencyBody() {
    }

    public TransparencyBody (String produzent, AdressBody produktionsort) {
        this.produzent = produzent;
        this.produktionsort = produktionsort;
    }

    public String getProduzent() {
        return this.produzent;
    }

    public void setProduzent(String produzent) {
        this.produzent = produzent;
    }

    public AdressBody getProduktionsort() {
        return this.produktionsort;
    }

    public void setProduktionsort(AdressBody produktionsort) {
        this.produktionsort = produktionsort;
    }
    
    
}
