package com.codecool.shop.controller;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.dao.factory.UserDaoFactory;
import com.codecool.shop.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.security.crypto.bcrypt.BCrypt;


@WebServlet(urlPatterns = {"/signup"})

public class SignupController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        User user = new User(userName, hashPassword);
       
        UserDao userDao = UserDaoFactory.create();
        userDao.add(user);
        resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath()));
    }

}

