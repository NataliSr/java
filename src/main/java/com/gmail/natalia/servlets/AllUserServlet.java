package com.gmail.natalia.servlets;

import com.gmail.natalia.User;
import com.gmail.natalia.controllers.UserController;
import com.gmail.natalia.daoimplementation.UserDAOMySQLImplementation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AllUserServlet extends HttpServlet {
    private UserController us;

    @Override
    public void init() throws ServletException {
        super.init();
        us = new UserController(new UserDAOMySQLImplementation());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = us.getUsers();
        req.setAttribute("users", users);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/all_user.jsp");
        rd.forward(req, resp);
    }
}
