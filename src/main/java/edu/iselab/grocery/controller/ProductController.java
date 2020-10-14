package edu.iselab.grocery.controller;

import edu.iselab.grocery.persistence.model.Product;
import edu.iselab.grocery.persistence.repository.ProductRepository;
import edu.iselab.grocery.util.ScannerUtils;

public class ProductController {
    
    private static ProductController instance;
    
    public ProductRepository productRepository; 
    
    private ProductController() {
        productRepository = ProductRepository.getInstance();
    }
    
    public static ProductController getInstance() {

        if (instance == null) {
            instance = new ProductController();
        }

        return instance;
    }

    public void start() {
        
        int option = 0;
        
        do {
            
            System.out.println("-------------");
            System.out.println("Products");
            System.out.println("-------------");
            System.out.println("  1 - Add");
            System.out.println("  2 - Remove");
            System.out.println("  3 - Search");
            System.out.println("  4 - List");
            System.out.println("  0 - Back");
            System.out.println("-------------");
            System.out.print("Option: ");
            
            option = ScannerUtils.getInt();
            
            switch (option) {
                case 1:
                    add();
                    break;
                case 4:
                    list();
                    break;
                default:
                    System.err.println("Invalid option. Please try again");
            }
            
        } while(option != 0);
        
    }
    
    public void list() {
        
        System.out.println("Description \t Price");
        
        for(Product product : productRepository.findAll()) {
            System.out.println(product);
        }
        
        System.out.println("Press ENTER to continue...");
        ScannerUtils.getString();
    }
    
    public void add() {
        
        Product product = new Product();
        
        System.out.print("Description: ");
        product.setDescription(ScannerUtils.getString());
        
        System.out.print("Price: ");
        product.setPrice(ScannerUtils.getDouble());
        
        productRepository.save(product);
    }
    
    
    

}