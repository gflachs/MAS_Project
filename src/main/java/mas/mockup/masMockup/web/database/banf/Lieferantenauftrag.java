package mas.mockup.masMockup.web.database.banf;

import java.util.Date;
import java.util.Set;

import mas.mockup.masMockup.web.database.banf.banfitem.Banfitem;

public class Lieferantenauftrag {

    private long lieferauftragsID;
    private Date orderDate;
    private Set<Banfitem> banfItems;
    private int supplierID;
    private Date abholDatum;
    private int importeurBestellungsid;

    public Lieferantenauftrag() {
    }

    public int getImporteurBestellungsid() {
        return importeurBestellungsid;
    }

    public void setImporteurBestellungsid(int importeurBestellungsid) {
        this.importeurBestellungsid = importeurBestellungsid;
    }

    public Lieferantenauftrag(long lieferauftragsID, Date orderDate, Set<Banfitem> banfItems, int supplierID,
            Date abholDatum, int importeurBestellungsid) {
        this.lieferauftragsID = lieferauftragsID;
        this.orderDate = orderDate;
        this.banfItems = banfItems;
        this.supplierID = supplierID;
        this.abholDatum = abholDatum;
        this.setImporteurBestellungsid(importeurBestellungsid);
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

    public int getSupplierID() {
        return this.supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public Date getAbholDatum() {
        return this.abholDatum;
    }

    public void setAbholDatum(Date abholDatum) {
        this.abholDatum = abholDatum;
    }

    public Lieferantenauftrag lieferauftragsID(long lieferauftragsID) {
        setLieferauftragsID(lieferauftragsID);
        return this;
    }

    public Lieferantenauftrag orderDate(Date orderDate) {
        setOrderDate(orderDate);
        return this;
    }

    public Lieferantenauftrag banfItems(Set<Banfitem> banfItems) {
        setBanfItems(banfItems);
        return this;
    }

    public Lieferantenauftrag supplierID(int supplierID) {
        setSupplierID(supplierID);
        return this;
    }

    public Lieferantenauftrag abholDatum(Date abholDatum) {
        setAbholDatum(abholDatum);
        return this;
    }

}
