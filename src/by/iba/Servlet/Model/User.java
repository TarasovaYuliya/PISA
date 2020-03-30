package by.iba.Servlet.Model;

public class User {
    private int id;
    private String login;
    private byte[] pass;

    public User(int id, String login, byte[] pass) {
        this.id = id;
        this.login = login;
        this.pass = pass;
    }

    public User(String login, byte[] pass) {
        this.login = login;
        this.pass = pass;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public byte[] getPass() {
        return pass;
    }

    public void setPass(byte[] pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
