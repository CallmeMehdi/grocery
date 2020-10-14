package edu.iselab.grocery.persistence.model;

import java.time.LocalDateTime;

public abstract class AbstractModel {

    protected int id;
    
    protected LocalDateTime createdAt;
    
    private String address;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }  
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
