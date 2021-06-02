package edu.iselab.grocery.features.manageorders;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
//    @JoinColumn(name="order_id", nullable=false)
    private Cart order;

    private Long productId;

    protected double value;

    private int amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cart getOrder() {
        return order;
    }

    public void setOrder(Cart order) {
        this.order = order;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
