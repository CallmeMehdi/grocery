package edu.iselab.grocery.features.manageproducts;

import edu.iselab.grocery.database.AbstractModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Product extends AbstractModel {

    @Id
    @GeneratedValue
    private Long id;

    private String description;

    protected double price;

    public int stock;

    private LocalDateTime createdAt;

    public LocalDateTime lastModifiedDate;

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

    @Override
    public String toString() {
        return id + "\t" + description + "\t" + price + "\t" + stock;
    }
}
