package com.gmail.natalia.controllers;

import com.gmail.natalia.User;
import com.gmail.natalia.dao.UserDAO;

import java.sql.SQLException;
import java.util.List;

public class UserController {
    private UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void addUser(User user) {
        try {
            userDAO.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getUsers() {
        try {
            return userDAO.getUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
