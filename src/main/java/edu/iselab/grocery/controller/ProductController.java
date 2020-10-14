package edu.iselab.grocery.controller;

import edu.iselab.grocery.util.ScannerUtils;

public class ProductController {

    public void start() {
        
        int option = 0;
        
        do {
            
            System.out.println("-------------");
            System.out.println("Products");
            System.out.println("-------------");
            System.out.println("  1 - Add");
            System.out.println("  2 - Remove");
            System.out.println("  3 - Search");
            System.out.println("  0 - Back");
            System.out.println("-------------");
            System.out.print("Option: ");
            
            option = ScannerUtils.getInt();
            
            
        } while(option != 0);
        
    }
    
    

}
