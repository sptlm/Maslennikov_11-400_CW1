package kfu.itis.maslennikov.web.dto;

public class UserDto {

    private String name;
    private String lastname;
    private String image;
    private String cloud_image;

    private String login;

    public UserDto(String login, String name, String lastname, String image, String cloud_image) {
        this.name = name;
        this.lastname = lastname;
        this.image = image;
        this.cloud_image = cloud_image;
        this.login = login;
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

    public String getCloud_image() {
        return cloud_image;
    }
}
