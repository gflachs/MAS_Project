package mas.mockup.masMockup.web.database;

public class Users {
    
    private int id;
    private String email;
    private String password;
    private String userGroup;

    public Users(int id, String email, String password, String userGroup) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userGroup = userGroup;
    }

    public String getUserGroup() {
        return this.userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }


    public Users() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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
