package com.codecool.shop.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LineItem {
    private Integer id;
    private Product product;
    private int quantity;

    /**
     * Constructs an item from the product and quantity.
     *
     * @param product  the product
     * @param quantity the item quantity
     */
    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Computes the total cost of this line item.
     *
     * @return the total price
     */
    public double getTotalPrice() {
        return product.getDefaultPrice() * quantity;
    }

    public String getTotalPriceString() {
        return Math.round(getTotalPrice()) + " " + product.getDefaultCurrency().toString();
    }

    public void increaseQuantity() {
        this.quantity += 1;
    }

    public void decreaseQuantity() {
        this.quantity -= 1;
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}

