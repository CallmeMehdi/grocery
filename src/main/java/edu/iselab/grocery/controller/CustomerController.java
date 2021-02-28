package edu.iselab.grocery.controller;

import org.apache.commons.lang3.exception.CloneFailedException;

import edu.iselab.grocery.persistence.model.Customer;
import edu.iselab.grocery.random.ImplementAPublicInterface;

public class CustomerController {
    
    private static CustomerController instance;
    
    private ImplementAPublicInterface pub = new ImplementAPublicInterface();
    
    private String[] names;
    
    private CloneNotSupportedException[] exceptions;
    
    private CloneFailedException[] clones;
    
    public static CustomerController getInstance() {

        if (instance == null) {
            instance = new CustomerController();
        }

        return instance;
    }

    public void add() {
        
        Customer c = new Customer();
        
        System.out.println(c.getsnm());
        
        pub.getNsm();  
    }
    
    public Customer findBySecondName(String name) {

        Customer c = new Customer();

        if (c.getsnm().equalsIgnoreCase(name)) {
            return c;
        }

        if (name.equalsIgnoreCase(c.getsnm())) {
            return c;
        }

        return null;
    }
    
}
