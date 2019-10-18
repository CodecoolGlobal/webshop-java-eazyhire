package com.codecool.shop.dao.implementation.db;

import com.codecool.shop.dao.BaseDao;
import com.codecool.shop.model.ProductCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductCategoryDaoDBTest {
    private BaseDao<ProductCategory> productCategoryDao;

    @BeforeEach
    void setup(){
        DbUtil.resetDB();
        productCategoryDao = new ProductCategoryDaoDB();
    }

    @Test
    void addAndFind_nameEquals() {
        ProductCategory testProductCategory = new ProductCategory("test ProductCategory", "test_department","test desc of supp");
        productCategoryDao.add(testProductCategory);

        int newId = testProductCategory.getId();
        assertEquals(testProductCategory.getName(), productCategoryDao.find(newId).getName());
        assertEquals(testProductCategory.getDepartment(), productCategoryDao.find(newId).getDepartment());
        assertEquals(testProductCategory.getDescription(), productCategoryDao.find(newId).getDescription());
    }
}