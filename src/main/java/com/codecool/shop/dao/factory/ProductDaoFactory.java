package com.codecool.shop.dao.factory;

import com.codecool.shop.config.Configs;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.db.ProductDaoDB;
import com.codecool.shop.dao.implementation.memory.ProductDaoMem;

public class ProductDaoFactory {
    public static ProductDao create(){
        if (Configs.dbType == Configs.DbType.MEM) {
            return ProductDaoMem.getInstance();
        } if (Configs.dbType == Configs.DbType.JDBC) {
            return new ProductDaoDB();
        } else {
            throw new RuntimeException();
        }

    }
}
