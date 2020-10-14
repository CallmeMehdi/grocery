package edu.iselab.grocery.persistence.model;

import java.time.LocalDateTime;

import edu.iselab.grocery.util.IdUtils;

public abstract class AbstractModel {

    protected int id;
    
    protected LocalDateTime createdAt;
    
    public AbstractModel() {
        this.id = IdUtils.getNextId();
    }

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
