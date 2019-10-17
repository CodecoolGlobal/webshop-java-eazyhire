package com.codecool.shop.dao.implementation.db;

import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Supplier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SupplierDaoDBTest {

    @Test
    void addAndFind_nameEquals() {
        Supplier testSupplier = new Supplier("test supplier", "test desc of supp");
        SupplierDao supplierDao = new SupplierDaoDB();
        supplierDao.add(testSupplier);

        int newId = testSupplier.getId();
        assertEquals(testSupplier.getName(), supplierDao.find(newId).getName());
    }

}