package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.dao.OrderDaoFactory;
import com.codecool.shop.model.Order;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/cart"})
public class CartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());

        OrderDao orderDataStore = OrderDaoFactory.create();
        final Order order = orderDataStore.find(1);
        context.setVariable("order", order);

        engine.process("product/cart.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        int newQuantity = Integer.parseInt(req.getParameter("quantity"));
        System.out.println("Modify quantity, productId: " + productId + ", quantity: " + newQuantity);
        OrderDao orderDao = OrderDaoFactory.create();
        Order currentOrder = orderDao.find(1);
        currentOrder.setQuantityForProduct(productId, newQuantity);

        orderDao.update(currentOrder);

        doGet(req, resp);
    }
}

