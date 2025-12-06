package kfu.itis.maslennikov.web.dao;

import kfu.itis.maslennikov.web.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getAll();

    void save(User user);

    User getById(Integer id);

    User getByLogin(String login);
}
