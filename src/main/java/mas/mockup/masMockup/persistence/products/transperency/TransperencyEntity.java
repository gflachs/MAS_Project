package mas.mockup.masMockup.persistence.products.transperency;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import mas.mockup.masMockup.persistence.accounts.adress.AdressEntity;
import mas.mockup.masMockup.persistence.products.ArticleEntity;

@Entity(name = "transparenz")
public class TransperencyEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "transparenzid")
    private int id;
    @Column(name = "produzentenname")
    private String produzent;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adressid")
    private AdressEntity produktionsort;

    @OneToOne(mappedBy = "transparency")
    private ArticleEntity articleEntity;

    public TransperencyEntity() {
    }

    public ArticleEntity getArticleEntity() {
        return articleEntity;
    }

    public void setArticleEntity(ArticleEntity articleEntity) {
        this.articleEntity = articleEntity;
    }

    public TransperencyEntity ( String produzent, AdressEntity produktionsort) {
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

    public AdressEntity getProduktionsort() {
        return this.produktionsort;
    }

    public void setProduktionsort(AdressEntity produktionsort) {
        this.produktionsort = produktionsort;
    }
}
