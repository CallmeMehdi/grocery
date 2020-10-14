package edu.iselab.grocery.persistence.model;

import java.time.LocalDateTime;

import edu.iselab.grocery.util.IdUtils;

public abstract class AbstractModel {

    public int id;
    
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
}
