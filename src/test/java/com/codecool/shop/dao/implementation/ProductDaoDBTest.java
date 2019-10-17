package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.implementation.db.ProductDaoDB;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductDaoDBTest {

    @Test
    void add() {
        ProductDaoDB productDaoDB = new ProductDaoDB();
        // TODO
        Product product = new Product(
                "Test Name",
                1000,
                "EUR",
                "worker",
                new ProductCategory(
                        "test prod cat",
                        "test department",
                        "decsription of cat"
                ),
                new Supplier(
                        "test supplier",
                        "test desc of supp"
                )
        );

        productDaoDB.add(product);
        assertEquals(product.getName(), productDaoDB.getAll().get(1).getName());

    }
}