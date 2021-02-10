package edu.iselab.grocery.persistence.model;

public class Customer extends AbstractModel {

    private String fullName;

    protected String secondName;
    
    private String phoneNumber;
    
    private String birthday;
    
    protected Address address = new Address();

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
    
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }    
    
    public String getsnm() {
        return secondName;
    }
}
