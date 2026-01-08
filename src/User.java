import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 2L;

    private String name;
    private String password;
    private String login;
    private int role;



    public User(String name, String password, String login, int Role) {
        this.name = name;
        this.password = password;
        this.login = login;
        this.role = Role; // 0 - Seller; 1 - Client
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public int getRole() {
        return role;
    }
}
