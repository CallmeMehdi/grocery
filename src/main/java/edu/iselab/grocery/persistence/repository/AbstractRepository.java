package edu.iselab.grocery.persistence.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import edu.iselab.grocery.persistence.model.AbstractModel;
import edu.iselab.grocery.util.IdUtils;

public class AbstractRepository<T extends AbstractModel> {

    private List<T> elements;

    protected AbstractRepository() {
        this.elements = new ArrayList<>();
    }
    
    public List<T> findAll() {
        return elements;
    }

    public void save(T element) {
        
        element.setId(IdUtils.getNextId());
        element.setCreatedAt(LocalDateTime.now());
        
        this.elements.add(element);
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