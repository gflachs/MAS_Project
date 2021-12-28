package mas.mockup.masMockup.persistence.banf;

import java.io.File;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import mas.mockup.masMockup.persistence.accounts.SupplierEntity;
import mas.mockup.masMockup.persistence.banf.banfitem.BanfItemEntity;

@Entity(name = "lieferauftrag")
public class LieferauftragEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lieferauftragid")
    private long lieferauftragsID;
    @Column(name = "orderdate")
    private Date orderDate;
    @OneToMany(mappedBy = "lieferauftragEntity")
    private Set<BanfItemEntity> banfItems;
    @ManyToOne
    @JoinColumn(name = "lieferantenid")
    private SupplierEntity supplier;
    @Column(name = "abholDatum")
    private Date abholDatum;
    @Column(name = "bezahlt")
    private boolean bezahlt;
    @Column(name = "rechnung")
    private File rechnung;
    @ManyToOne
    @JoinColumn(name = "importeurbestellungsid")
    ImporteuerBestellungEntity importBestellung;

    public LieferauftragEntity() {
    }

    public File getRechnung() {
        return rechnung;
    }

    public void setRechnung(File rechnung) {
        this.rechnung = rechnung;
    }

    public boolean isBezahlt() {
        return bezahlt;
    }

    public void setBezahlt(boolean bezahlt) {
        this.bezahlt = bezahlt;
    }

    public LieferauftragEntity(Date orderDate, SupplierEntity supplier,
            Date abholDatum, ImporteuerBestellungEntity importBestellung) {
        this.orderDate = orderDate;
        this.supplier = supplier;
        this.abholDatum = abholDatum;
        this.importBestellung = importBestellung;
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

    public Set<BanfItemEntity> getBanfItems() {
        return this.banfItems;
    }

    public void setBanfItems(Set<BanfItemEntity> banfItems) {
        this.banfItems = banfItems;
    }

    public SupplierEntity getSupplier() {
        return this.supplier;
    }

    public void setSupplier(SupplierEntity supplier) {
        this.supplier = supplier;
    }

    public Date getAbholDatum() {
        return this.abholDatum;
    }

    public void setAbholDatum(Date abholDatum) {
        this.abholDatum = abholDatum;
    }

    public ImporteuerBestellungEntity getImportBestellung() {
        return this.importBestellung;
    }

    public void setImportBestellung(ImporteuerBestellungEntity importBestellung) {
        this.importBestellung = importBestellung;
    }

}
