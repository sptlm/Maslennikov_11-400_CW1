package kfu.itis.maslennikov.hw7.dto;

public class UserDto {

    private String name;
    private String lastname;
    private String image;

    private String login;

    public UserDto(String name, String login, String lastname, String image) {
        this.name = name;
        this.login = login;
        this.lastname = lastname;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getLastname() {
        return lastname;
    }

    public String getImage() {
        return image;
    }
}
