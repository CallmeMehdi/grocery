package edu.iselab.grocery.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import edu.iselab.grocery.persistence.model.AbstractModel;

public class AbstractRepository<T extends AbstractModel> {

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
    
    public T findById(int id) {

        for (T product : findAll()) {

            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }
    
    public T removeById(int id) {

        T found = findById(id);

        if (found != null) {
            elements.remove(found);
        }

        return found;
    }
}
