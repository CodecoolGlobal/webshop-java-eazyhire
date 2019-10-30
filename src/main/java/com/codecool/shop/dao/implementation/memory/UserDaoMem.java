package com.codecool.shop.dao.implementation.memory;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.User;

import java.util.List;

public class UserDaoMem implements UserDao {
    private static UserDaoMem instance = null;

    private UserDaoMem(){}

    public static UserDaoMem getInstance(){
        if (instance == null) {
            instance = new UserDaoMem();
        }
        return instance;
    }


    @Override
    public void add(User user) {

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
