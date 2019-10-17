package com.codecool.shop.dao;

import com.codecool.shop.config.Configs;
import com.codecool.shop.dao.implementation.memory.SupplierDaoMem;

public class SupplierDaoFactory {
    public static SupplierDao create() {
        if (Configs.dbType == Configs.DbType.MEM) {
            return SupplierDaoMem.getInstance();
        } else {
            throw new RuntimeException();
        }
    }
}
