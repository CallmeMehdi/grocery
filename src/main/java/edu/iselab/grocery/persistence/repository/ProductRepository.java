package edu.iselab.grocery.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import edu.iselab.grocery.persistence.model.Product;

public class ProductRepository extends AbstractRepository<Product> {

    private static ProductRepository instance;

    public static ProductRepository getInstance() {

        if (instance == null) {
            instance = new ProductRepository();
        }

        return instance;
    }

    public List<Product> findByDescription(String term) {

        List<Product> found = new ArrayList<>();

        if (term == null || term.isEmpty()) {
            return found;
        }

        for (Product product : findAll()) {

            if (product.getDescription().toLowerCase().contains(term.toLowerCase())) {
                found.add(product);
            }
        }

        return found;
    }
    
    public Product findById(int id) {

        for (Product product : findAll()) {

            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }
}
