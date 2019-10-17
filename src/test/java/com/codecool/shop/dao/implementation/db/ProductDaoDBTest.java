package com.codecool.shop.dao.implementation.db;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductDaoDBTest {
    private ProductDao productDao;

    @BeforeEach
    void setup(){
        DbUtil.resetDB();
        productDao = new ProductDaoDB();
    }

    @Test
    void add_nameEquals() {
        ProductCategory productCategory = new ProductCategoryDaoDB().find(1);
        Supplier supplier = new SupplierDaoDB().find(1);
        Product product = new Product(
                "Test Name",
                1000,
                "EUR",
                "worker",
                productCategory,
                supplier
        );

        productDao.add(product);
        assertEquals(product.getName(), productDao.getAll().get(6).getName());

    }
}