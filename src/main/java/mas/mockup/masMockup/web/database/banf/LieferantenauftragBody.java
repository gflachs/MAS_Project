package mas.mockup.masMockup.web.database.banf;

import java.util.Date;
import java.util.Set;

import mas.mockup.masMockup.web.database.banf.banfitem.Banfitem;

public class LieferantenauftragBody {

    private Date orderDate;
    private Set<Banfitem> banfItems;
    private int supplierID;

    public LieferantenauftragBody() {
    }

    public LieferantenauftragBody(Date orderDate, Set<Banfitem> banfItems, int supplierID) {
        this.orderDate = orderDate;
        this.banfItems = banfItems;
        this.supplierID = supplierID;
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

    public LieferantenauftragBody orderDate(Date orderDate) {
        setOrderDate(orderDate);
        return this;
    }

}
