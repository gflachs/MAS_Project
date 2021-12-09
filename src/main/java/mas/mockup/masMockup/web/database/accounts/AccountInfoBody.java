package mas.mockup.masMockup.web.database.accounts;

import mas.mockup.masMockup.web.database.accounts.adress.AdressBody;
import mas.mockup.masMockup.web.database.accounts.contactPerson.ContactBody;

public class AccountInfoBody {

    private String firmenname;
    private String accountEmail;
    private String ustID;
    private String telefon;
    private ContactBody contactPerson;
    private AdressBody deliveryAdress;
    private String bankaccount;

    public AccountInfoBody() {
    }

    public AccountInfoBody(String firmenname, String accountEmail, String ustID, String telefon,
            ContactBody contactPerson, AdressBody deliveryAdress, String bankaccount) {
        this.firmenname = firmenname;
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

    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
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

    public ContactBody getContactPerson() {
        return this.contactPerson;
    }

    public void setContactPerson(ContactBody contactPerson) {
        this.contactPerson = contactPerson;
    }

    public AdressBody getDeliveryAdress() {
        return this.deliveryAdress;
    }

    public void setDeliveryAdress(AdressBody deliveryAdress) {
        this.deliveryAdress = deliveryAdress;
    }

}
