package mas.mockup.masMockup.persistence.accounts;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import mas.mockup.masMockup.persistence.accounts.adress.AdressEntity;
import mas.mockup.masMockup.persistence.accounts.contactPerson.ContactPersonEntity;
import mas.mockup.masMockup.persistence.orders.OrderEntity;

@Entity (name = "accounts")
public class AccountInfoEntity {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "accountid")
    private int accountID;

    @Column(name = "email")
    private String accountEmail;
    
    @Column(name = "ustid")
    private String ustID;

    @Column(name = "telefon")
    private String telefon;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contactpersonid")
    private ContactPersonEntity contactPerson;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deliveryadressid")
    private AdressEntity deliveryAdress;

    @Column(name = "bankaccount")
    private String bankaccount;

    @OneToMany(mappedBy = "accountInfoEntity")
    private Set<OrderEntity> orderEntities;

    public AccountInfoEntity() {
    }


    public Set<OrderEntity> getOrderEntities() {
        return orderEntities;
    }


    public void setOrderEntities(Set<OrderEntity> orderEntities) {
        this.orderEntities = orderEntities;
    }


    public String getBankaccount() {
        return bankaccount;
    }


    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }


    public AccountInfoEntity(String accountEmail, String ustID, String telefon, ContactPersonEntity contactPerson, AdressEntity deliveryAdress, String bankaccount) {
     
        this.accountEmail = accountEmail;
        this.ustID = ustID;
        this.telefon = telefon;
        this.contactPerson = contactPerson;
        this.deliveryAdress = deliveryAdress;
        this.bankaccount = bankaccount;
    }


    public int getAccountID() {
        return this.accountID;
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

    public ContactPersonEntity getContactPerson() {
        return this.contactPerson;
    }

    public void setContactPerson(ContactPersonEntity contactPerson) {
        this.contactPerson = contactPerson;
    }

    public AdressEntity getDeliveryAdress() {
        return this.deliveryAdress;
    }

    public void setDeliveryAdress(AdressEntity deliveryAdress) {
        this.deliveryAdress = deliveryAdress;
    }

}
