package edu.iselab.grocery.random;

import edu.iselab.grocery.persistence.model.Product;

public class Class1 {
    
    public class InnerClass{
        
        private Product p;
    }
    
    public class InnerClass2 {
        
        private InnerClass inner;
    }
    
    private InnerClass inner;
    
    private InnerClass2 inner2;
    
    public void execute() {
        
        inner.p.price = 2.3;
        inner2.inner.p.price = 4.5;
    }

}
