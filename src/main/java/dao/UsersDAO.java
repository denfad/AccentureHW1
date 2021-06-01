package dao;

import models.User;

import java.util.ArrayList;
import java.util.List;

public class UsersDAO {
    private static UsersDAO instance;
    private List<User> users;
    private UsersDAO(){
        users = new ArrayList<>();
        users.add(new User("login", "password"));
    }

    public static UsersDAO getInstance(){
        if(instance == null){
            instance = new UsersDAO();
        }
        return instance;
    }

    public List<User> getUsers() {
        return users;
    }
}
