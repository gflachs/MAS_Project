package mas.mockup.masMockup.web.database.banf;

import java.io.File;
import java.util.Date;
import java.util.Set;

import mas.mockup.masMockup.web.database.accounts.Supplier;
import mas.mockup.masMockup.web.database.banf.banfitem.Banfitem;

public class Lieferantenauftrag {

    private long lieferauftragsID;
    private Date orderDate;
    private Set<Banfitem> banfItems;
    private Supplier supplier;
    private Date abholDatum;
    private int importeurBestellungsid;
    private boolean bezahlt;
    private File rechnung;

    public Lieferantenauftrag() {
    }

    public Lieferantenauftrag(long lieferauftragsID, Date orderDate, Set<Banfitem> banfItems,
            Supplier supplier,
            Date abholDatum, int importeurBestellungsid, boolean bezahlt, File rechnung) {
        this.lieferauftragsID = lieferauftragsID;
        this.orderDate = orderDate;
        this.banfItems = banfItems;
        this.supplier = supplier;
        this.abholDatum = abholDatum;
        this.importeurBestellungsid = importeurBestellungsid;
        this.bezahlt = bezahlt;
        this.rechnung = rechnung;
    }

    public long getLieferauftragsID() {
        return this.lieferauftragsID;
    }

    public void setLieferauftragsID(long lieferauftragsID) {
        this.lieferauftragsID = lieferauftragsID;
    }

    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Set<Banfitem> getBanfItems() {
        return this.banfItems;
    }

    public void setBanfItems(Set<Banfitem> banfItems) {
        this.banfItems = banfItems;
    }

    public Supplier getSupplier() {
        return this.supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Date getAbholDatum() {
        return this.abholDatum;
    }

    public void setAbholDatum(Date abholDatum) {
        this.abholDatum = abholDatum;
    }

    public int getImporteurBestellungsid() {
        return this.importeurBestellungsid;
    }

    public void setImporteurBestellungsid(int importeurBestellungsid) {
        this.importeurBestellungsid = importeurBestellungsid;
    }

    public boolean isBezahlt() {
        return this.bezahlt;
    }

    public boolean getBezahlt() {
        return this.bezahlt;
    }

    public void setBezahlt(boolean bezahlt) {
        this.bezahlt = bezahlt;
    }

    public File getRechnung() {
        return this.rechnung;
    }

    public void setRechnung(File rechnung) {
        this.rechnung = rechnung;
    }

}
