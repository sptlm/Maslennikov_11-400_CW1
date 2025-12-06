package kfu.itis.maslennikov.hw7.entity;

public class User {

    private Integer id;

    private String login;
    private String password;

    private String name;
    private String lastname;

    private String image;

    public User(Integer id, String login, String password, String name, String lastname, String image) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.image = image;
    }

    public User(){}

    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getImage() {
        return image;
    }
}
