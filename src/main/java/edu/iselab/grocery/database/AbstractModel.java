package edu.iselab.grocery.database;

import java.time.LocalDateTime;

public abstract class AbstractModel {

    public static long ID_COUNTER = 1;

    protected Long id;

    protected LocalDateTime createdAt;

    public LocalDateTime lastModifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
