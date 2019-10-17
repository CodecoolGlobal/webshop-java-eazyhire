package com.codecool.shop.dao.implementation.db;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductCategoryDaoDBTest {

    @BeforeEach
    void resetDB(){
        DbCreator dbCreator = new DbCreator();
        dbCreator.executeUpdateFromFile("src/main/java/com/codecool/shop/dao/implementation/db/sql/db_init.sql");

    }

    @Test
    void addAndFind_nameEquals() {
        ProductCategory testProductCategory = new ProductCategory("test ProductCategory", "test_department","test desc of supp");
        ProductCategoryDao productCategoryDao = new ProductCategoryDaoDB();
        productCategoryDao.add(testProductCategory);

        int newId = testProductCategory.getId();
        assertEquals(testProductCategory.getName(), productCategoryDao.find(newId).getName());
    }
}