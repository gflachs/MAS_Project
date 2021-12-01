package mas.mockup.masMockup.persistence.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name ="users")
public class UserEntity {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "userid")
    private int id;

    @Column(name = "useremail")
    private String email;

    @Column(name = "userpassword")
    private String password;

    @Column(name = "usergroup")
    private String userGroup;

    public UserEntity(String email, String password, String userGroup) {
        this.email = email;
        this.password = password;
        this.userGroup = userGroup;
    }

    public UserEntity() {
    }


    public String getUserGroup() {
        return this.userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }


    
    public int getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
