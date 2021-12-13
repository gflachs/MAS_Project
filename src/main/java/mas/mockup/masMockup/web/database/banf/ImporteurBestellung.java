package mas.mockup.masMockup.web.database.banf;

import java.util.Date;
import java.util.Set;

public class ImporteurBestellung {

    private int bestellID;
    private Set<Lieferantenauftrag> lieferauftraege;
    private Boolean geliefert;

    public ImporteurBestellung() {
    }

    public ImporteurBestellung(int bestellID, Set<Lieferantenauftrag> lieferauftraege, Boolean geliefert) {
        this.bestellID = bestellID;
        this.lieferauftraege = lieferauftraege;
        this.geliefert = geliefert;
    }

    public int getBestellID() {
        return this.bestellID;
    }

    public void setBestellID(int bestellID) {
        this.bestellID = bestellID;
    }

    public Set<Lieferantenauftrag> getLieferauftraege() {
        return this.lieferauftraege;
    }

    public void setLieferauftraege(Set<Lieferantenauftrag> lieferauftraege) {
        this.lieferauftraege = lieferauftraege;
    }

    public Boolean getAbholDatum() {
        return this.geliefert;
    }

    public void setAbholDatum(Boolean geliefert) {
        this.geliefert = geliefert;
    }

}
