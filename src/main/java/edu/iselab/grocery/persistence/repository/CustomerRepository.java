package edu.iselab.grocery.persistence.repository;

import edu.iselab.grocery.persistence.model.Customer;

public class CustomerRepository extends AbstractRepository<Customer> {
    
    private static CustomerRepository instance;
    
    public CustomerRepository() {
        
    }
    
    public static CustomerRepository getInstance() {

        if (instance == null) {
            instance = new CustomerRepository();
        }

        return instance;
    }
}
