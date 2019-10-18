package com.codecool.shop.dao.implementation.db;

import com.codecool.shop.dao.BaseDao;
import com.codecool.shop.model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDaoDB implements BaseDao<Supplier> {

    @Override
    public void add(Supplier supplier) {
        String query = "" +
                "INSERT INTO SUPPLIER (name, description) " +
                "VALUES (?, ?)" +
                "RETURNING id; ";
        try (
                Connection connection = DbUtil.getConnection();
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
                Connection connection = DbUtil.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
        ) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next())
                return getSupplierFromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Supplier getSupplierFromResultSet(ResultSet rs) throws SQLException {
        Supplier supplier = new Supplier(
                rs.getString("name"),
                rs.getString("description")
        );
        supplier.setId(rs.getInt("id"));

        return supplier;
    }

    @Override
    public void remove(int id) {
        String query = "" +
                "DELETE FROM supplier " +
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
    public List<Supplier> getAll() {
        String query = "SELECT * FROM supplier;";
        try {
            ResultSet rs = DbUtil.executeQuery(query);

            List<Supplier> suppliers = new ArrayList<>();
            while (rs.next()) {
                Supplier supplier = getSupplierFromResultSet(rs);
                suppliers.add(supplier);
            }
            return suppliers;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
