package kfu.itis.maslennikov.service.impl;

import kfu.itis.maslennikov.dao.UserDao;
import kfu.itis.maslennikov.dao.impl.UserDaoImpl;
import kfu.itis.maslennikov.dto.UserDto;
import kfu.itis.maslennikov.entity.User;
import kfu.itis.maslennikov.service.UserService;
import kfu.itis.maslennikov.util.PasswordUtil;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService, Serializable {

    private final static UserDao userDao = new UserDaoImpl();

    @Override
    public List<UserDto> getAll() {
        return userDao.getAll().stream().map(u -> new UserDto(u.getName(), u.getLogin())).collect(Collectors.toList());
    }

    public static boolean signUp(String login, String password, String name, String lastname){
        if (userDao.getByLogin(login) != null){
            return false;
        } else {
            //users.put(login, password);
            userDao.save(
                    new User(0,
                            login,
                            PasswordUtil.encrypt(password),
                            name,
                            lastname
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
}
