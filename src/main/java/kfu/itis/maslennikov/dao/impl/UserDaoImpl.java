package kfu.itis.maslennikov.dao.impl;

import kfu.itis.maslennikov.dao.UserDao;
import kfu.itis.maslennikov.entity.User;
import kfu.itis.maslennikov.util.DatabaseConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    //Лучше передавать в конструкторе, взяв из конфига (Dependency injection)
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    public List<User> getAll() {
        String sql = "select * from users";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            List<User> users = new ArrayList<>();
            if(resultSet != null){
                while(resultSet.next()){
                    users.add(
                            new User(
                                    resultSet.getInt("id"),
                                    resultSet.getString("login"),
                                    resultSet.getString("password"),
                                    resultSet.getString("name"),
                                    resultSet.getString("lastname")
                                    )
                    );
                }
            }
            return users;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(User user) {
        String sql = "insert into users (name, lastname, login, password) values(?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public User getById(Integer id) {
        return null;
    }
    @Override
    public User getByLogin(String login){
        String sql = "select * from users where login = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();


            List<User> users = new ArrayList<>();
            if(resultSet != null){
                if (resultSet.next()){
                    return
                            new User(
                                    resultSet.getInt("id"),
                                    resultSet.getString("login"),
                                    resultSet.getString("password"),
                                    resultSet.getString("name"),
                                    resultSet.getString("lastname")
                            );
                }
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
