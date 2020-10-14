package edu.iselab.grocery.persistence.repository;

import java.util.ArrayList;
import java.util.List;

public class AbstractRepository<T> {

    private List<T> elements;

    protected AbstractRepository() {
        this.elements = new ArrayList<>();
    }
    
    public List<T> findAll() {
        return elements;
    }

    public void save(T product) {
        this.elements.add(product);
    }
}
