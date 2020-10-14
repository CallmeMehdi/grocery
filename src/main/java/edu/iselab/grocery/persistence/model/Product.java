package edu.iselab.grocery.persistence.model;

public class Product extends AbstractModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
