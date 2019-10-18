package com.codecool.shop.dao.implementation.db;

import com.codecool.shop.dao.BaseDao;
import com.codecool.shop.model.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SupplierDaoDBTest {
    private BaseDao<Supplier> supplierDao;

    @BeforeEach
    void setUp() {
        DbUtil.resetDB();
        supplierDao = new SupplierDaoDB();
    }

    @Test
    void addAndFind_nameEquals() {
        Supplier testSupplier = new Supplier("test supplier", "test desc of supp");
        supplierDao.add(testSupplier);
        int newId = testSupplier.getId();

        assertEquals(testSupplier.getName(), supplierDao.find(newId).getName());
    }

    @Test
    void findNonexistent_returnNull() {
        BaseDao<Supplier> supplierDao = new SupplierDaoDB();
        assertNull(supplierDao.find(0));
    }

    @Test
    void addRemoveFind_returnNull() {
        Supplier testSupplier = new Supplier("test supplier", "test desc of supp");
        supplierDao.add(testSupplier);
        int newId = testSupplier.getId();

        supplierDao.remove(newId);

        assertNull(supplierDao.find(newId));
    }
}