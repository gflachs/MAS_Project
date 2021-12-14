package mas.mockup.masMockup.web.database.banf.banfitem;

public class BanfItemChangePriceAndAmountRequest {

    private int amount;
    private double price;

    public BanfItemChangePriceAndAmountRequest(int amount, double price) {
        this.amount = amount;
        this.price = price;
    }

    public BanfItemChangePriceAndAmountRequest() {

    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
