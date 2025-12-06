package kfu.itis.maslennikov.hw8.service.impl;

import kfu.itis.maslennikov.hw8.dao.UserDao;
import kfu.itis.maslennikov.hw8.dao.impl.UserDaoImpl;
import kfu.itis.maslennikov.hw8.dto.UserDto;
import kfu.itis.maslennikov.hw8.entity.User;
import kfu.itis.maslennikov.hw8.service.FileUploadService;
import kfu.itis.maslennikov.hw8.service.UserService;
import kfu.itis.maslennikov.hw8.util.PasswordUtil;

import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final static UserDao userDao = new UserDaoImpl();

    @Override
    public List<UserDto> getAll() {
        return userDao.getAll().stream().map(u -> new UserDto(u.getName(), u.getLogin(), u.getLastname(), u.getImage(), u.getCloud_image())).collect(Collectors.toList());
    }

    public static boolean signUp(String login, String password, String name, String lastname, Part part){
        if (userDao.getByLogin(login) != null){
            return false;
        } else {
            Map<String, String> paths;
            try {
                paths = FileUploadService.uploadFile(part);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            userDao.save(
                    new User(0,
                            login,
                            PasswordUtil.encrypt(password),
                            name,
                            lastname,
                            paths.get("image"),
                            paths.get("cloud_image")
                    )
            );
            return true;
        }
    }

    public static boolean userExists(String login){
        //return users.containsKey(login);
        return userDao.getByLogin(login) != null;
    }

    public static boolean checkPassword(String login, String password){
        User user = userDao.getByLogin(login);
        return user != null && user.getPassword().equals(PasswordUtil.encrypt(password));
    }

    @Override
    public UserDto getByLogin(String login) {
        User u = userDao.getByLogin(login);
        return  new UserDto(u.getLogin(),u.getName(), u.getLastname(), u.getImage(), u.getCloud_image());
    }

}
