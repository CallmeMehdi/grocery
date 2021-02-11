package edu.iselab.grocery.random;

import edu.iselab.grocery.persistence.model.Product;
import edu.iselab.grocery.util.ConsoleUtils;

public class MultipleInnerClasses {
    
    public class FirstInnerClass{
        
        private Product p;
    }
    
    public class SecondInnerClass {
        
        private FirstInnerClass inner;
        
        public void execute() {
            
            inner.p.price = 2.3;
            
            System.out.println(inner.p.price);
        }
    }
    
    private FirstInnerClass firstInner;
    
    private SecondInnerClass secondInner;
    
    public void execute() {
        
        firstInner.p.price = 2.3;
        secondInner.inner.p.price = ConsoleUtils.promptUserForADouble();
        
        System.out.println(secondInner.inner.p.price);
        
        ImplementAPublicInterface a = new ImplementAPublicInterface();
        
        a.getNsm();
        
        System.out.println(a.getS(2, 3));
    }

}
