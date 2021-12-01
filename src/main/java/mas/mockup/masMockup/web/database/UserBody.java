package mas.mockup.masMockup.web.database;

public class UserBody {

    private String email;
    private String password;

    public UserBody(int id, String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserBody() {
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
