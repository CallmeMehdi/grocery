package edu.iselab.grocery.persistence.model;

import java.time.LocalDateTime;

public class Product extends AbstractModel {

    private String description;
    
    private double price;
    
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
        return description + "\t" + price;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
