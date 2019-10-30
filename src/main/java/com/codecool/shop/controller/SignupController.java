package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.BaseDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.UserDao;
import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.dao.factory.OrderDaoFactory;
import com.codecool.shop.dao.factory.ProductCategoryDaoFactory;
import com.codecool.shop.dao.factory.ProductDaoFactory;
import com.codecool.shop.dao.factory.UserDaoFactory;
import com.codecool.shop.model.Order;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/signup"})

public class SignupController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("new user: " + userName + " , pw: " + password);
        User user = new User(userName, password);
        System.out.println("user object: user");
        UserDao userDao = UserDaoFactory.create();
        userDao.add(user);
        resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath()));
    }

}

