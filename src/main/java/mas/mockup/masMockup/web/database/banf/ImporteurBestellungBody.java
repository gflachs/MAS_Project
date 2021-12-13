package mas.mockup.masMockup.web.database.banf;

import java.util.Set;

public class ImporteurBestellungBody {

    private Set<Lieferantenauftrag> lieferauftraege;

    public ImporteurBestellungBody() {
    }

    public ImporteurBestellungBody(Set<Lieferantenauftrag> lieferauftraege) {
        this.lieferauftraege = lieferauftraege;
    }

    public Set<Lieferantenauftrag> getLieferauftraege() {
        return this.lieferauftraege;
    }

    public void setLieferauftraege(Set<Lieferantenauftrag> lieferauftraege) {
        this.lieferauftraege = lieferauftraege;
    }

}
