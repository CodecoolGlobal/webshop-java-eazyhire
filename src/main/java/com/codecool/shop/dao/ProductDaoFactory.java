package com.codecool.shop.dao;

import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Product;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class ProductDaoFactory {
    private static String daoConfig = "mem";

    public static ProductDao createProductDao(){
        if (daoConfig.equals("mem")) {
         return ProductDaoMem.getInstance();
        }
        else {
            throw new NotImplementedException();
        }

    }
}
