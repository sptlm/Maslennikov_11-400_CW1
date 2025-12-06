package kfu.itis.maslennikov.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionUtil {

    private static Connection connection;

    public static Connection getConnection(){
        AppConfig appConfig = AppConfigUtil.loadConfig();
        if(connection == null){
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(
                        appConfig.DBUrl(),
                        appConfig.DBUser(),
                        appConfig.DBPassword()
                );
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
