package mas.mockup.masMockup.persistence.accounts.contactPerson;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import mas.mockup.masMockup.persistence.accounts.AccountInfoEntity;
import mas.mockup.masMockup.persistence.accounts.SupplierEntity;

@Entity (name = "contactperson")
public class ContactPersonEntity {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "contactid")
    private int contactID;

    @Column(name = "vorname")
    private String surname;
    
    @Column(name = "nachname")
    private String lastname;

    @Column(name = "telefonnummer")
    private String telefonNumber;

    @OneToOne(mappedBy = "contactPerson")
    private SupplierEntity supplierEntity;

    @OneToOne(mappedBy = "contactPerson")    
    private AccountInfoEntity accountInfoEntity;


    public ContactPersonEntity() {
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

    public ContactPersonEntity(String surname, String lastname, String telefonNumber) {
      
        this.surname = surname;
        this.lastname = lastname;
        this.telefonNumber = telefonNumber;
    }

    public int getContactID() {
        return this.contactID;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTelefonNumber() {
        return this.telefonNumber;
    }

    public void setTelefonNumber(String telefonNumber) {
        this.telefonNumber = telefonNumber;
    }

}
