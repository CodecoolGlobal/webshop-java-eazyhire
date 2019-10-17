package com.codecool.shop.dao.implementation.db;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoDB implements ProductDao {
    DbCreator dbCreator = new DbCreator();

    @Override
    public void add(Product product) {
        String query = "" +
                "INSERT INTO product (category_id, supplier_id, name, description, def_price, def_currency)\n" +
                "VALUES (?, ?, ?, ?, ?, ?);";
        try (
                Connection connection = dbCreator.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
        ) {
            ps.setInt(1, product.getProductCategory().getId());
            ps.setInt(2, product.getSupplier().getId());
            ps.setString(3, product.getName());
            ps.setString(4, product.getDescription());
            ps.setFloat(5, product.getDefaultPrice());
            ps.setString(6, product.getDefaultCurrency().toString());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product find(int id) {
        String query = "" +
                "SELECT * FROM product " +
                "WHERE id = ?;";
        try (
                Connection connection = dbCreator.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
        ) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            ProductCategoryDao pcd = new ProductCategoryDaoDB();
            SupplierDao sd = new SupplierDaoDB();
            rs.next();
            Product found = new Product(
                    rs.getString("name"),
                    rs.getFloat("def_price"),
                    rs.getString("def_currency"),
                    rs.getString("description"),
                    pcd.find(rs.getInt("category_id")),
                    sd.find(rs.getInt("supplier_id"))
            );
            return found;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void remove(int id) {
        String query = "" +
                "DELETE FROM product " +
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
    public List<Product> getAll() {
        String query = "SELECT * FROM product";
        try {
            ResultSet rs = dbCreator.executeQuery(query);

            // TODO
            ProductCategory testCategory = new ProductCategory(
                    "test prod cat",
                    "test department",
                    "decsription of cat"
            );
            Supplier testSupplier = new Supplier(
                    "test supplier",
                    "test desc of supp"
            );

            List<Product> products = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product(
                        rs.getString("name"),
                        rs.getFloat("def_price"),
                        rs.getString("def_currency"),
                        rs.getString("description"),
                        testCategory,
                        testSupplier
                );
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        return null;
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        return null;
    }
}
