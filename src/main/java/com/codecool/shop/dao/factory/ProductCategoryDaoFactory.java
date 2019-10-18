package com.codecool.shop.dao.factory;

import com.codecool.shop.config.Configs;
import com.codecool.shop.dao.BaseDao;
import com.codecool.shop.dao.implementation.db.ProductCategoryDaoDB;
import com.codecool.shop.dao.implementation.memory.ProductCategoryDaoMem;
import com.codecool.shop.model.ProductCategory;

public class ProductCategoryDaoFactory {
    public static BaseDao<ProductCategory> create() {
        if (Configs.dbType == Configs.DbType.MEM) {
            return ProductCategoryDaoMem.getInstance();
        } else  if (Configs.dbType == Configs.DbType.JDBC) {
            return new ProductCategoryDaoDB();
        } else {
            throw new RuntimeException();
        }
    }

}
