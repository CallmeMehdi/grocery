package edu.iselab.grocery;

import edu.iselab.grocery.controller.ProductController;
import edu.iselab.grocery.util.ScannerUtils;

public class Launcher {
    
    public static ProductController productController = new ProductController();

    public static void main(String[] args) {

        int option = 0;
        
        do {
            
            System.out.println("-------------");
            System.out.println("Menu");
            System.out.println("-------------");
            System.out.println("  1 - Customers");
            System.out.println("  2 - Products");
            System.out.println("  3 - Orders");
            System.out.println("  0 - Quit");
            System.out.println("-------------");
            System.out.print("Option: ");
            
            option = ScannerUtils.getInt();
            
            switch (option) {
                case 2:
                    productController.start();
                    break;
                default:
                    System.err.println("Invalid option. Please try again");
            }
            
        } while(option != 0);
        
        System.out.println("Bye!");
    }
}
