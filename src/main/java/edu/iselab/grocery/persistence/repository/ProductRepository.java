package edu.iselab.grocery.persistence.repository;

import edu.iselab.grocery.persistence.model.Product;

public class ProductRepository extends AbstractRepository<Product> {
    
    private static ProductRepository instance;
    
    public static ProductRepository getInstance() {

        if (instance == null) {
            instance = new ProductRepository();
        }

        return instance;
    }
  
}
