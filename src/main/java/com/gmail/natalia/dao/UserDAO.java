package com.gmail.natalia.dao;

import com.gmail.natalia.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    public void addUser(User user) throws SQLException;

    public List<User> getUsers() throws SQLException;

}
