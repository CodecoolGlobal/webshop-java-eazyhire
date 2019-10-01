package com.codecool.shop.model;


public class LineItem {
    /**
     * Constructs an item from the product and quantity.
     *
     * @param aProduct  the product
     * @param aQuantity the item quantity
     */

    private int quantity;
    private Product product;

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Computes the total cost of this line item.
     *
     * @return the total price
     */
    public float getTotalPrice() {
        return product.getDefaultPrice() * quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity() {
        this.quantity += 1;
    }

    public void decreaseQuantity() {
        this.quantity -= 1;
    }
}

