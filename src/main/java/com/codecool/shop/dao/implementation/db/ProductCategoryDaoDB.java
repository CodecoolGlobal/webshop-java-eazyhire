package com.codecool.shop.dao.implementation.db;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDaoDB implements ProductCategoryDao {

    @Override
    public void add(ProductCategory category) {
        String query = "" +
                "INSERT INTO product_category (name, department, description) " +
                "VALUES (?, ?, ?)" +
                "RETURNING id; ";
        try (
                Connection connection = DbUtil.getConnection();
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
                Connection connection = DbUtil.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
        ) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
                return getProductCategoryFromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ProductCategory getProductCategoryFromResultSet(ResultSet rs) throws SQLException {
        ProductCategory productCategory = new ProductCategory(
                rs.getString("name"),
                rs.getString("department"),
                rs.getString("description")
        );
        productCategory.setId(rs.getInt("id"));

        return productCategory;
    }

    @Override
    public void remove(int id) {
        String query = "" +
                "DELETE FROM product_category " +
                "WHERE id = ?;";
        try (
                Connection connection = DbUtil.getConnection();
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
        String query = "SELECT * FROM product_category;";
        try {
            ResultSet rs = DbUtil.executeQuery(query);

            List<ProductCategory> productCategories = new ArrayList<>();
            while (rs.next()) {
                ProductCategory pc = getProductCategoryFromResultSet(rs);
                productCategories.add(pc);
            }
            return productCategories;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

