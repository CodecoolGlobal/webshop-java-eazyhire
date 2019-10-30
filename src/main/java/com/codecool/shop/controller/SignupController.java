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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ProductDao productDataStore = ProductDaoFactory.create();
        BaseDao<ProductCategory> productCategoryDataStore = ProductCategoryDaoFactory.create();
        OrderDao orderDataStore = OrderDaoFactory.create();

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        List<ProductCategory> categories = productCategoryDataStore.getAll();
        String categoryParam = req.getParameter("category");
        int chosenId = (categoryParam == null) ? 1 : Integer.parseInt(req.getParameter("category"));

        ProductCategory chosenProductCategory = productCategoryDataStore.find(chosenId);
        context.setVariable("categories", categories);
        context.setVariable("products", productDataStore.getBy(chosenProductCategory));
        context.setVariable("chosencategory", chosenProductCategory);

        final Order order = orderDataStore.find(1);
        int sumQuantity = order == null ? 0 : order.getSumQuantity();
        context.setVariable("sumquantitiy", sumQuantity);

        // // Alternative setting of the template context
        // Map<String, Object> params = new HashMap<>();
        // params.put("category", productCategoryDataStore.find(1));
        // params.put("products", productDataStore.getBy(productCategoryDataStore.find(1)));
        // context.setVariables(params);
        System.out.println("index get");
        engine.process("product/index.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("new user: " + userName + " , pw: " + password);
        User user = new User(userName, password);
        System.out.println("user object: user");
        UserDao userDao = UserDaoFactory.create();
        userDao.add(user);
        doGet(req, resp);
    }

}

