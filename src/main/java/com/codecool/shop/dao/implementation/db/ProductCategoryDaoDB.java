package com.codecool.shop.dao.implementation.db;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductCategoryDaoDB implements ProductCategoryDao {
    DbCreator dbCreator = new DbCreator();

    @Override
    public void add(ProductCategory category) {
        String query = "" +
                "INSERT INTO product_category (name, department, description) " +
                "VALUES (?, ?, ?)" +
                "RETURNING id; ";
        try (
                Connection connection = dbCreator.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
        ) {
            ps.setString(1, category.getName());
            ps.setString(2, category.getDepartment());
            ps.setString(3, category.getDescription());

            ResultSet rs = ps.executeQuery();
            rs.next();
            category.setId(rs.getInt("id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public ProductCategory find(int id) {
        String query = "" +
                "SELECT * FROM product_category " +
                "WHERE id = ?;";
        try (
                Connection connection = dbCreator.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
        ) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();

            ProductCategory found = new ProductCategory(
                    rs.getString("name"),
                    rs.getString("department"),
                    rs.getString("description")
            );
            found.setId(rs.getInt("id"));

            return found;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void remove(int id) {
        String query = "" +
                "DELETE FROM product_category " +
                "WHERE id = ?;";
        try (
                Connection connection = dbCreator.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
        ) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ProductCategory> getAll() {
        return null;
    }
}
