package com.gmail.natalia.servlets;
import com.gmail.natalia.User;
import com.gmail.natalia.controllers.UserController;
import com.gmail.natalia.daoimplementation.UserDAOMySQLImplementation;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class AddUserServlet extends HttpServlet {
    private UserController us;

    @Override
    public void init() throws ServletException {
        super.init();
        us = new UserController(new UserDAOMySQLImplementation());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lastName = req.getParameter("last_name");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");

        User user = new User(lastName, name, phone);
        us.addUser(user);

    }
}
