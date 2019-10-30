package com.codecool.shop.dao.implementation.db;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoDB implements UserDao {

    @Override
    public void add(User user) {
        String query = "" +
                "INSERT INTO users (name, password) " +
                "VALUES (?, ?) " +
                "RETURNING id; ";

        try (
                Connection connection = DbUtil.getConnection();
                PreparedStatement ps = connection.prepareStatement(query);
        ) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());

            ResultSet rs = ps.executeQuery();
            rs.next();
            user.setId(rs.getInt("id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public User find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List getAll() {
        return null;
    }
}
