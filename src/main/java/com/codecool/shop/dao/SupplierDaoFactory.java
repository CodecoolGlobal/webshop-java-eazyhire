package com.codecool.shop.dao;

import com.codecool.shop.dao.implementation.memory.SupplierDaoMem;
import com.codecool.shop.model.Supplier;

public class SupplierDaoFactory {
    private static String daoConfig = "mem";

    public static SupplierDao create() {
        if (daoConfig.equals("mem")) {
            return SupplierDaoMem.getInstance();
        } else {
            throw new RuntimeException();
        }
    }
}
