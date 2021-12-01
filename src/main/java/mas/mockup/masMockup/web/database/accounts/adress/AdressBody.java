package mas.mockup.masMockup.web.database.accounts.adress;

public class AdressBody {
    
    private String street;
    private String houseNumber;
    private String zipCode;

    public AdressBody() {
    }


    public AdressBody(String street, String houseNumber, String zipCode) {
       
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return this.houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
