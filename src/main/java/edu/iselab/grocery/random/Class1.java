package edu.iselab.grocery.random;

import edu.iselab.grocery.persistence.model.Product;

public class Class1 {
    
    public class InnerClass{
        
        private Product p;
    }
    
    private InnerClass inner;
    
    public void execute() {
        
        inner.p.price = 2.3;
    }

}
