package edu.iselab.grocery.persistence.model;

public class Customer extends AbstractModel {

    private String name;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
