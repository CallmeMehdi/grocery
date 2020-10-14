package edu.iselab.grocery.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import edu.iselab.grocery.persistence.model.Product;

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
    
    public List<Product> findByDescription(String term) {

        List<Product> found = new ArrayList<>();

        if (term == null || term.isEmpty()) {
            return found;
        }

//        for (Product product : findAll()) {
//
//            if (product.getDescription().contains(term)) {
//                found.add(product);
//            }
//        }

        return found;
    }
}
