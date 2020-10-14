package edu.iselab.grocery;

import edu.iselab.grocery.controller.ProductController;
import edu.iselab.grocery.util.ConsoleUtils;

public class Launcher {
    
    public static ProductController productController = ProductController.getInstance();

    public static void main(String[] args) {

        int option = 0;
        
        do {
            
            ConsoleUtils.clear();
            
            ConsoleUtils.printRectangle("Main Menu");
            
            System.out.println(" 1 - Customers");
            System.out.println(" 2 - Products");
            System.out.println(" 3 - Orders");
            System.out.println(" 0 - Quit");
            
            ConsoleUtils.printLine();
            
            System.out.print("Option: ");
            
            option = ConsoleUtils.promptUserForAnInt();
            
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
