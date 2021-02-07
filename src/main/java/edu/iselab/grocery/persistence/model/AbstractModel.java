package edu.iselab.grocery.persistence.model;

import java.time.LocalDateTime;

public abstract class AbstractModel extends AbstractDatabase {

    protected int id;

    protected LocalDateTime createdAt;

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
