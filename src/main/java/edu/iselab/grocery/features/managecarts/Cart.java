package edu.iselab.grocery.features.managecarts;

import edu.iselab.grocery.database.AbstractModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart extends AbstractModel {

    @Id
    @GeneratedValue
    private Long id;

    protected double total = 0.0;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="card_id")
    private Set<Item> items = new HashSet<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public void addItem(Item item){

        item.setOrder(this);

        items.add(item);

        total += (item.getAmount() * item.getValue());
    }

    @Override
    public String toString() {
        return id + "\t" + total;
    }
}
