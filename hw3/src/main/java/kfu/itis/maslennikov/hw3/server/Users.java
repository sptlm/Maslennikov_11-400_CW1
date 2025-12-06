package kfu.itis.maslennikov.hw3.server;

import java.util.HashMap;
import java.util.Map;

public class Users {
    private static Map<String, String> users = new HashMap<>();

    /// returns true if user added and false, if it already was in the map
    public static boolean signUp(String login, String password){
        if (users.containsKey(login)){
            return false;
        } else {
            users.put(login, password);
            return true;
        }
    }

    public static boolean userExists(String login){
        return users.containsKey(login);
    }

    public static boolean checkPassword(String login, String password){
        return users.containsKey(login) && users.get(login).equals(password);
    }
}
