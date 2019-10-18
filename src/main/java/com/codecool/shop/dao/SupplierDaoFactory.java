package com.codecool.shop.dao;

import com.codecool.shop.config.Configs;
import com.codecool.shop.dao.implementation.db.SupplierDaoDB;
import com.codecool.shop.dao.implementation.memory.SupplierDaoMem;
import com.codecool.shop.model.Supplier;

public class SupplierDaoFactory {
    public static BaseDao<Supplier> create() {
        if (Configs.dbType == Configs.DbType.MEM) {
            return SupplierDaoMem.getInstance();
        } if (Configs.dbType == Configs.DbType.JDBC) {
            return new SupplierDaoDB();
        } else {
            throw new RuntimeException();
        }
    }
}
