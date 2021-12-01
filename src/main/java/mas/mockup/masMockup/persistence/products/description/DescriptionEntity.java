package mas.mockup.masMockup.persistence.products.description;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import mas.mockup.masMockup.persistence.products.ArticleEntity;

@Entity(name = "productdescription")
public class DescriptionEntity {
    
    @GeneratedValue
    @Id
    @Column(name = "descriptionid")
    private int ID;
    @Column(name = "produktname")
    private String produktname;
    @Column(name = "beschreibung")
    private String description;
    @Column(name = "inhaltsstoffe")
    private String ingridients;

    @OneToOne(mappedBy = "productdescription")
    private ArticleEntity articleEntity;


    public DescriptionEntity() {
    }

    public ArticleEntity getArticleEntity() {
        return articleEntity;
    }

    public void setArticleEntity(ArticleEntity articleEntity) {
        this.articleEntity = articleEntity;
    }

    public DescriptionEntity(String produktname, String description, String ingridients) {
      
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
