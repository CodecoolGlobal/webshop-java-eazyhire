package com.codecool.shop.dao;

import com.codecool.shop.config.Configs;
import com.codecool.shop.dao.implementation.db.ProductCategoryDaoDB;
import com.codecool.shop.dao.implementation.memory.ProductCategoryDaoMem;

public class ProductCategoryDaoFactory {
    public static ProductCategoryDao create() {
        if (Configs.dbType == Configs.DbType.MEM) {
            return ProductCategoryDaoMem.getInstance();
        } else  if (Configs.dbType == Configs.DbType.JDBC) {
            return new ProductCategoryDaoDB();
        } else {
            throw new RuntimeException();
        }
    }

}
