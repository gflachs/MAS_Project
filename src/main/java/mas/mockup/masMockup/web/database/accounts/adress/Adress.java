package mas.mockup.masMockup.web.database.accounts.adress;

public class Adress {
    
    private int adressID;
    private String street;
    private String houseNumber;
    private String zipCode;

    public Adress() {
    }


    public Adress(int adressID, String street, String houseNumber, String zipCode) {
        this.adressID = adressID;
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
    }


    public int getAdressID() {
        return this.adressID;
    }

    public void setAdressID(int adressID) {
        this.adressID = adressID;
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
