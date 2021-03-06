package services;

import dataaccess.UserDB;
import java.util.List;
import models.User;

public class UserService {
    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    }
    
    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }
    
    public void insert(String email, Boolean active, String firstName, String lastName, String password) throws Exception {
        User user = new User(email, active, firstName, lastName, password);
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }
    
    public void update(String email, Boolean active, String firstName, String lastName, String password) throws Exception {
        //User user = new User(email, active, firstName, lastName, password);
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        //user.setRole(role);
        userDB.update(user);
    }
    
    public void delete(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        userDB.delete(user);
    }
}

