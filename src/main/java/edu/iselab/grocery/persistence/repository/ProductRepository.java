package edu.iselab.grocery.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import edu.iselab.grocery.persistence.model.Product;

public class ProductRepository {
    
    private List<Product> products;
    
    public ProductRepository() {
        this.products = new ArrayList<>();
    }
    
    public List<Product> findAll(){
        return products;
    }
}
