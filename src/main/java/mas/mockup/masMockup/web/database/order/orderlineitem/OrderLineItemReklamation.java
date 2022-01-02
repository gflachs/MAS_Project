package mas.mockup.masMockup.web.database.order.orderlineitem;

import mas.mockup.masMockup.web.database.product.Article;

public class OrderLineItemReklamation {

    private long id;
    private String artikelName;
    private int amount;
    private double price;

    public OrderLineItemReklamation() {
    }

    public OrderLineItemReklamation(long id, String artikelName, int amount, double price) {
        this.id = id;
        this.artikelName = artikelName;
        this.amount = amount;
        this.price = price;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArtikelName() {
        return this.artikelName;
    }

    public void setArtikelName(String artikelName) {
        this.artikelName = artikelName;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderLineItemReklamation id(long id) {
        setId(id);
        return this;
    }

    public OrderLineItemReklamation artikelName(String artikelName) {
        setArtikelName(artikelName);
        return this;
    }

    public OrderLineItemReklamation amount(int amount) {
        setAmount(amount);
        return this;
    }

    public OrderLineItemReklamation price(double price) {
        setPrice(price);
        return this;
    }

}
