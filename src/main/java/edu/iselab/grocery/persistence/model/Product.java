package edu.iselab.grocery.persistence.model;

public class Product extends AbstractModel {

    private String description;
    
    public double price;
    
    public int amount;
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description + "\t" + price;
    }    
}
