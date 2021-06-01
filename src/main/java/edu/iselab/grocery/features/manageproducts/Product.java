package edu.iselab.grocery.features.manageproducts;

import edu.iselab.grocery.database.AbstractModel;

public class Product extends AbstractModel {

    private String description;

    protected double price;

    public int stock;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + "\t" + description + "\t" + price + "\t" + stock;
    }
}
