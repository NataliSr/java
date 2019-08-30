package com.gmail.natalia.daoimplementation;

import com.gmail.natalia.User;
import com.gmail.natalia.dao.UserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOMySQLImplementation implements UserDAO {

    private final String DB_CONNECTION = "jdbc:mysql://localhost:3306/users?serverTimezone=Europe/Kiev";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "natalia123";

    public UserDAOMySQLImplementation() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addUser(User user) throws SQLException {



        try (Connection cn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD)) {
            try (PreparedStatement ps = cn.prepareStatement("INSERT INTO users (last_name, name, phone) VALUES(?, ?, ?)")) {
                ps.setString(1, user.getLastName());
                ps.setString(2, user.getName());
                ps.setString(3, user.getPhone());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }


    }

    @Override
    public List<User> getUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        try (Connection cn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD)) {
            try (PreparedStatement ps = cn.prepareStatement("select * from users")) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    String lastName = rs.getString("last_name");
                    String name  = rs.getString("name");
                    String phone = rs.getString("phone");
                    User user = new User(lastName, name, phone);
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return users;
    }
}
