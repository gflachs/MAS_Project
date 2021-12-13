package mas.mockup.masMockup.persistence.banf;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "importteuerbestellung")
public class ImporteuerBestellungEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bestellID;
    @OneToMany(mappedBy = "importBestellung")
    private Set<LieferauftragEntity> lieferauftraege;
    @Column
    private Boolean geliefert;

    public ImporteuerBestellungEntity() {
    }

    public ImporteuerBestellungEntity(Boolean geliefert) {

        this.geliefert = geliefert;
    }

    public int getBestellID() {
        return this.bestellID;
    }

    public void setBestellID(int bestellID) {
        this.bestellID = bestellID;
    }

    public Set<LieferauftragEntity> getLieferauftraege() {
        return this.lieferauftraege;
    }

    public void setLieferauftraege(Set<LieferauftragEntity> lieferauftraege) {
        this.lieferauftraege = lieferauftraege;
    }

    public Boolean getAbholDatum() {
        return this.geliefert;
    }

    public void setAbholDatum(Boolean geliefert) {
        this.geliefert = geliefert;
    }
}
