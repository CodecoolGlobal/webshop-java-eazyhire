package com.codecool.shop.dao.implementation.db;

import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.ProductDaoFactory;
import com.codecool.shop.model.LineItem;
import com.codecool.shop.model.Order;
import com.codecool.shop.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class OrderDaoDB implements OrderDao {

    @Override
    public void add(Order order) {
        insertOrder(order);
        for (LineItem lineItem : order.getItems()) {
            insertLineItem(lineItem, order.getId());
        }
    }

    private void insertLineItem(LineItem lineItem, int orderId) {
        String query = "" +
                "INSERT INTO line_item (order_id, product_id, quantity) " +
                "VALUES (?, ?, ?)" +
                "RETURNING id; ";
        try (
                Connection connection = DbUtil.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
        ) {
            ps.setInt(1, orderId);
            ps.setInt(2, lineItem.getProduct().getId());
            ps.setInt(3, lineItem.getQuantity());
            ResultSet rs = ps.executeQuery();
            rs.next();
            lineItem.setId(rs.getInt("id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertOrder(Order order) {
        String query = "" +
                "INSERT INTO cart (currency) " +
                "VALUES (?)" +
                "RETURNING id; ";
        try (
                Connection connection = DbUtil.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
        ) {
            ps.setString(1, order.getCurrency().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            order.setId(rs.getInt("id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order find(int id) {
        Order order = new Order();
        order.setItems(getLineItems(id));
        return getOrderData(id, order);
    }

    private List<LineItem> getLineItems(int id) {
        List<LineItem> lineItems = new LinkedList<>();
        String query = "" +
                "SELECT * " +
                "FROM line_item " +
                "WHERE order_id = ?; ";
        try (
                Connection connection = DbUtil.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                ProductDao productDao = ProductDaoFactory.create();
                Product product = productDao.find(rs.getInt("product_id"));

                LineItem lineItem = new LineItem(
                    product,
                    rs.getInt("quantity")
                );
                lineItem.setId(rs.getInt("id"));

                lineItems.add(lineItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lineItems;
    }

    private Order getOrderData(int id, Order order) {
        String query = "" +
                "SELECT * " +
                "FROM cart " +
                "WHERE cart.id = ?; ";
        try (
                Connection connection = DbUtil.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
        ) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                order.setId(rs.getInt("id"));
                return order;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void remove(int id) {
        // TODO
    }

    @Override
    public List<Order> getAll() {
        // TODO
        return null;
    }
}
