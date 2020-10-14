package edu.iselab.grocery.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import edu.iselab.grocery.persistence.model.Customer;

public class CustomerRepository {
    
    private static CustomerRepository instance;
    
    private List<Customer> customers;
    
    private CustomerRepository() {
        this.customers = new ArrayList<>();
    }
    
    public static CustomerRepository getInstance() {

        if (instance == null) {
            instance = new CustomerRepository();
        }

        return instance;
    }
    
    public List<Customer> findAll(){
        return customers;
    }

    public void save(Customer product) {
        this.customers.add(product);
    }
}
