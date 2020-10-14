package edu.iselab.grocery.persistence.model;

import edu.iselab.grocery.util.IdUtils;

public abstract class AbstractModel {

    public int id;
    
    public AbstractModel() {
        this.id = IdUtils.getNextId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getPhoneNumber() {
        return "";
    }

    public void setPhoneNumber(String phoneNumber) {
        
    }
}
