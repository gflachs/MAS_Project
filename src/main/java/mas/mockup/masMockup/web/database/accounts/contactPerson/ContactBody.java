package mas.mockup.masMockup.web.database.accounts.contactPerson;

public class ContactBody {

    private String surname;
    private String lastname;
    private String telefonNumber;

    public ContactBody() {
    }

    public ContactBody(String surname, String lastname, String telefonNumber) {

        this.surname = surname;
        this.lastname = lastname;
        this.telefonNumber = telefonNumber;
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
