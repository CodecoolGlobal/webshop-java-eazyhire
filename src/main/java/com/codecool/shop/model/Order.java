package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class Order {

    private List<LineItem> items;
    private int id;
    private Currency currency;


    public Order(Product product) {
        this.items = new ArrayList<>();
        items.add(new LineItem(product, 1));
        currency = product.getDefaultCurrency();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSumQuantity() {
        int sum = 0;
        for (LineItem item : items) {
            sum += item.getQuantity();
        }
        return sum;
    }

    public List<LineItem> getItems() {
        return new ArrayList<>(items);
    }

    public float getTotalPrice() {
        float sum = 0;
        for (LineItem item : items) {
            sum += item.getTotalPrice();
        }
        return sum;
    }

    public String getTotalPriceString() {
        return getTotalPrice() + " " + currency.toString();
    }

    @Override
    public String toString() {
        return "Order{" +
                "items=" + items +
                ", id=" + id +
                '}';
    }
}


