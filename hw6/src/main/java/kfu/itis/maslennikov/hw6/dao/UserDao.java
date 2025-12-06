package kfu.itis.maslennikov.hw6.dao;

import kfu.itis.maslennikov.hw6.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getAll();

    void save(User user);

    User getById(Integer id);

    User getByLogin(String login);
}
