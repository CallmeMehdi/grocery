package edu.iselab.grocery.random;

import edu.iselab.grocery.persistence.model.Product;
import edu.iselab.grocery.util.ConsoleUtils;

public class MultipleInnerClasses {
    
    public class FirstInnerClass{
        
        private Product p;
    }
    
    public class SecondInnerClass {
        
        private FirstInnerClass inner;
    }
    
    private FirstInnerClass firstInner;
    
    private SecondInnerClass secondInner;
    
    public void execute() {
        
        firstInner.p.price = 2.3;
        secondInner.inner.p.price = ConsoleUtils.promptUserForADouble();
    }

}
