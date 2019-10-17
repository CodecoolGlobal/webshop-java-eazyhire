package com.codecool.shop.dao;

import com.codecool.shop.dao.implementation.memory.ProductDaoMem;

public class ProductDaoFactory {
    private static String daoConfig = "mem";

    public static ProductDao create(){
        if (daoConfig.equals("mem")) {
         return ProductDaoMem.getInstance();
        } else {
            throw new RuntimeException();
        }
    }
}
