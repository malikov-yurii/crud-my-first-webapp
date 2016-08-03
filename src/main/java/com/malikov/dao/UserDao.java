package com.malikov.dao;

import com.malikov.model.User;

import java.util.List;

/**
 * Created by Malikov on 7/29/2016.
 */
public interface UserDao {
    public void addUser(User user);
    public void updateUser(User user);
    public void removeUser(int id);
    public User getUserById(int id);
    public User getUserByName(String name);
    public List<User> listUsers();

}
