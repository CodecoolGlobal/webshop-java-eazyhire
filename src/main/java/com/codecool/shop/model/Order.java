package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<LineItem> items;
    private int id;

    public Order(Product product) {
        this.items = new ArrayList<>();
        items.add(new LineItem(product, 1));
    }

    public void addProduct(Product product) {
        for (LineItem item : items) {
            if (item.getProduct().equals(product)) {
                item.increaseQuantity();
                return;
            }
        }
        items.add(new LineItem(product, 1));
    }

}


