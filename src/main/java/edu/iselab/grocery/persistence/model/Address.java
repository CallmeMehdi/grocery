package edu.iselab.grocery.persistence.model;

public class Address {
    
    private String address;

    private String city;
    
    public String publicField;
    
    protected String protectedField;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    protected void protectedMethod() {
        System.out.println(publicField);
    }
}