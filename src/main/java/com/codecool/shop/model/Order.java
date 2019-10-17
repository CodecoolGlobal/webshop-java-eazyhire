package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class Order {

    private List<LineItem> items;
    private int id;
    private Currency currency = Currency.getInstance("HUF");

    public Order(){}


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

    /**
     * Set quantity for a product already in the Order.
     * @param productId id of the product
     * @param quantity new quantity
     */
    public void setQuantityForProduct(int productId, int quantity) {
        for (LineItem item : items) {
            if (item.getProduct().getId() == productId) {
                if (quantity == 0) {
                    removeItem(item);
                } else {
                    item.setQuantity(quantity);
                }
                return;
            }
        }
    }

    private void removeItem(LineItem item) {
        items.remove(item);
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
        return (int)getTotalPrice() + " " + currency.toString() + "/month";
    }

    @Override
    public String toString() {
        return "Order{" +
                "items=" + items +
                ", id=" + id +
                '}';
    }
}


