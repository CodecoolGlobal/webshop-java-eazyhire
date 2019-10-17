package com.codecool.shop.config;

import com.codecool.shop.dao.*;
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
        DaoUtil.setup();

        ProductDao productDataStore = ProductDaoFactory.create();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoFactory.create();
        SupplierDao supplierDataStore = SupplierDaoFactory.create();

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
        productDataStore.add(new Product("Full stack developer", 1000000, "HUF", "Best full stack developers on the market, with unit testing experience.", developer, codecool));
        productDataStore.add(new Product("PHP developer", 479000, "HUF", "Need any PHP developer? Here you can find the ultimate geniuses.", developer, elte));
        productDataStore.add(new Product("Marketing Manager", 890000, "HUF", "Makes your company look fabololluos.", backoffice, corvinus));
        productDataStore.add(new Product("Sales ", 990000, "HUF", "They can sell anything, even your awful product.", backoffice, corvinus));
        productDataStore.add(new Product("Python developer", 300000, "HUF", "These scripting ninjas can and will do anything you need.", developer, codecool));
        productDataStore.add(new Product("Java developer", 500000, "HUF", "Java EE, Java SE, makes your system functional (or object-oriented).", developer, codecool));
    }
}
