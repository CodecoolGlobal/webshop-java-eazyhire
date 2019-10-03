package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier elte = new Supplier("Elte", "Top hungarian University");
        supplierDataStore.add(elte);
        Supplier codecool = new Supplier("Codecool", "Best private school for those who want to learn coding");
        supplierDataStore.add(codecool);
        Supplier corvinus = new Supplier("Corvinus", "Accounting and business school");
        supplierDataStore.add(corvinus);

        //setting up a new product category
        ProductCategory developer = new ProductCategory("Developer", "IT", "Responsible for generating code");
        productCategoryDataStore.add(developer);
        ProductCategory backoffice = new ProductCategory("Backoffice", "IT", "Responsible for administration");
        productCategoryDataStore.add(backoffice);

        //setting up products and printing it
        productDataStore.add(new Product("JAVA developer", 500000, "HUF", "Best java developers on the market, with unit test experience.", developer, codecool));
        productDataStore.add(new Product("PHP developer", 479000, "HUF", "Need any PHP developer? Here you can find the ultimate geniuses of Elte's IT faculty.", developer, elte));
        productDataStore.add(new Product("Marketing Manager", 890000, "HUF", "Makes your company look fabololuos", backoffice, corvinus));
        productDataStore.add(new Product("Sales ", 990000, "HUF", "They can sell anything, even your awful product", backoffice, corvinus));
    }
}
