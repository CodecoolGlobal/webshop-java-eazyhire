package com.codecool.shop.dao.factory;

import com.codecool.shop.config.Configs;
import com.codecool.shop.dao.OrderDao;
import com.codecool.shop.dao.UserDao;
import com.codecool.shop.dao.implementation.db.OrderDaoDB;
import com.codecool.shop.dao.implementation.db.UserDaoDB;
import com.codecool.shop.dao.implementation.memory.OrderDaoMem;
import com.codecool.shop.dao.implementation.memory.UserDaoMem;

public class UserDaoFactory {
    public static UserDao create() {
        if (Configs.dbType == Configs.DbType.MEM) {
            return UserDaoMem.getInstance();
        } if (Configs.dbType == Configs.DbType.JDBC) {
            return new UserDaoDB();
        } else {
            throw new RuntimeException();
        }
    }
}
