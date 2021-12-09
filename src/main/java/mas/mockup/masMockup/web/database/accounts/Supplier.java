package mas.mockup.masMockup.web.database.accounts;

import java.util.List;

import mas.mockup.masMockup.web.database.accounts.adress.Adress;
import mas.mockup.masMockup.web.database.accounts.contactPerson.ContactPerson;

public class Supplier {

    private int accountID;
    private String firmenname;
    private String accountEmail;
    private String ustID;
    private String telefon;
    private ContactPerson contactPerson;
    private Adress deliveryAdress;
    private String bankaccount;

    public Supplier() {
    }

    public Supplier(int accountID, String firmenname,
            String accountEmail, String ustID, String telefon,
            ContactPerson contactPerson, Adress deliveryAdress, String bankaccount) {
        this.firmenname = firmenname;
        this.accountID = accountID;
        this.accountEmail = accountEmail;
        this.ustID = ustID;
        this.telefon = telefon;
        this.contactPerson = contactPerson;
        this.deliveryAdress = deliveryAdress;
        this.bankaccount = bankaccount;
    }

    public String getFirmenname() {
        return firmenname;
    }

    public void setFirmenname(String firmenname) {
        this.firmenname = firmenname;
    }

    public int getAccountID() {
        return this.accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getAccountEmail() {
        return this.accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public String getUstID() {
        return this.ustID;
    }

    public void setUstID(String ustID) {
        this.ustID = ustID;
    }

    public String getTelefon() {
        return this.telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public ContactPerson getContactPerson() {
        return this.contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Adress getDeliveryAdress() {
        return this.deliveryAdress;
    }

    public void setDeliveryAdress(Adress deliveryAdress) {
        this.deliveryAdress = deliveryAdress;
    }

    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }

}
