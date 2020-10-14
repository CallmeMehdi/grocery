package edu.iselab.grocery.persistence.model;

public class Customer extends AbstractModel {

    private String fullName;
    
    private String phoneNumber;
    
    private String birthday;
    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }    
}
