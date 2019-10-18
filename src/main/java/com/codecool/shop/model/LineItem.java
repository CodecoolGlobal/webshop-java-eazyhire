package com.codecool.shop.model;


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
    public float getTotalPrice() {
        return product.getDefaultPrice() * quantity;
    }

    public String getTotalPriceString() {
        return (int) getTotalPrice() + " " + product.getDefaultCurrency().toString();
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

