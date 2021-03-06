package mas.mockup.masMockup.web.database.banf;

import java.util.Date;
import java.util.Set;

import mas.mockup.masMockup.web.database.banf.banfitem.Banfitem;

public class Banf {

    private int banfID;
    private Date orderDate;
    private Set<Banfitem> banfItems;
    private int supplierID;
    private BanfStatus status;

    public Banf() {
    }

    public Banf(int banfID, Date orderDate, Set<Banfitem> banfItems, int supplierID, BanfStatus status) {
        this.banfID = banfID;
        this.orderDate = orderDate;
        this.banfItems = banfItems;
        this.supplierID = supplierID;
        this.status = status;
    }

    public int getBanfID() {
        return this.banfID;
    }

    public void setBanfID(int banfID) {
        this.banfID = banfID;
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

    public BanfStatus getStatus() {
        return this.status;
    }

    public void setStatus(BanfStatus status) {
        this.status = status;
    }

}
