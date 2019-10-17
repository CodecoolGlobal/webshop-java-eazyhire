package com.codecool.shop.dao.implementation.db;

import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SupplierDaoDB implements SupplierDao {
    DbCreator dbCreator = new DbCreator();

    @Override
    public void add(Supplier supplier) {
        String query = "" +
                "INSERT INTO SUPPLIER (name, description) " +
                "VALUES (?, ?)" +
                "RETURNING id; ";
        try (
                Connection connection = dbCreator.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
        ) {
            ps.setString(1, supplier.getName());
            ps.setString(2, supplier.getDescription());

            ResultSet rs = ps.executeQuery();
            rs.next();
            supplier.setId(rs.getInt("id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Supplier find(int id) {
        String query = "" +
                "SELECT * FROM supplier " +
                "WHERE id = ?;";
        try (
                Connection connection = dbCreator.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
        ) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();

            Supplier found = new Supplier(
                    rs.getString("name"),
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
                "DELETE FROM supplier " +
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
    public List<Supplier> getAll() {
        return null;
    }
}
