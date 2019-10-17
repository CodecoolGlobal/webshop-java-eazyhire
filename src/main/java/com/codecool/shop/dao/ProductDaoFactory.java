package com.codecool.shop.dao;

import com.codecool.shop.config.Configs;
import com.codecool.shop.dao.implementation.memory.ProductDaoMem;

public class ProductDaoFactory {
    public static ProductDao create(){
        if (Configs.dbType == Configs.DbType.MEM) {
         return ProductDaoMem.getInstance();
        } else {
            throw new RuntimeException();
        }
    }
}
