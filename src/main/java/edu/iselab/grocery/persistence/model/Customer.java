package edu.iselab.grocery.persistence.model;

import java.util.ArrayList;
import java.util.List;

public class Customer extends AbstractModel {

    private String name;
    
    private List<Address> addresses;
    
    public Customer() {
        this.addresses = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
