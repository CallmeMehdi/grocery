package edu.iselab.grocery.persistence.model;

public abstract class AbstractModel {

    public String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
