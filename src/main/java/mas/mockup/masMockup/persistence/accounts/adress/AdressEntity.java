package mas.mockup.masMockup.persistence.accounts.adress;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import mas.mockup.masMockup.persistence.accounts.AccountInfoEntity;
import mas.mockup.masMockup.persistence.accounts.SupplierEntity;
import mas.mockup.masMockup.persistence.products.transperency.TransperencyEntity;

@Entity(name = "address")
public class AdressEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "adressid")
    private int adressID;

    @Column(name = "strasse")
    private String street;

    @Column(name = "hausnummer")
    private String houseNumber;

    @Column(name = "postleitzahl")
    private String zipCode;

    @Column(name = "stadt")
    private String city;

    @Column(name = "land")
    private String country;

    @OneToOne(mappedBy = "produktionsort")
    private TransperencyEntity transperence;

    @OneToOne(mappedBy = "deliveryAdress")
    private SupplierEntity supplierEntity;

    @OneToOne(mappedBy = "deliveryAdress")
    private AccountInfoEntity accountInfoEntity;

    public AdressEntity() {
    }

    public AdressEntity(String street, String houseNumber, String zipCode, String city, String country) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public AccountInfoEntity getAccountInfoEntity() {
        return accountInfoEntity;
    }

    public void setAccountInfoEntity(AccountInfoEntity accountInfoEntity) {
        this.accountInfoEntity = accountInfoEntity;
    }

    public SupplierEntity getSupplierEntity() {
        return supplierEntity;
    }

    public void setSupplierEntity(SupplierEntity supplierEntity) {
        this.supplierEntity = supplierEntity;
    }

    public int getAdressID() {
        return this.adressID;
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

    public void setTransperence(TransperencyEntity tEntity) {
        this.transperence = tEntity;
    }

    public TransperencyEntity getTransperenceEntity() {
        return this.transperence;
    }

}
