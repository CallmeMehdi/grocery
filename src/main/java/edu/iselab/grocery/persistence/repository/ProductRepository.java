package edu.iselab.grocery.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import edu.iselab.grocery.persistence.model.Product;

public class ProductRepository {
    
    private static ProductRepository instance;
    
    private List<Product> products;
    
    private ProductRepository() {
        this.products = new ArrayList<>();
    }
    
    public static ProductRepository getInstance() {

        if (instance == null) {
            instance = new ProductRepository();
        }

        return instance;
    }
    
    public List<Product> findAll(){
        return products;
    }

    public void save(Product product) {
        this.products.add(product);
    }
}
