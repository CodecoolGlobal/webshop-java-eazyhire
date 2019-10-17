package com.codecool.shop.dao;

import com.codecool.shop.config.Configs;
import com.codecool.shop.dao.implementation.db.OrderDaoDB;
import com.codecool.shop.dao.implementation.memory.OrderDaoMem;

public class OrderDaoFactory {
    public static OrderDao create() {
        if (Configs.dbType == Configs.DbType.MEM) {
            return OrderDaoMem.getInstance();
        } if (Configs.dbType == Configs.DbType.JDBC) {
            return new OrderDaoDB();
        } else {
            throw new RuntimeException();
        }
    }
}
