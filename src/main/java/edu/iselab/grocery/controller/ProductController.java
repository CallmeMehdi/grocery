package edu.iselab.grocery.controller;

import java.util.List;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestWordMax;
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
            
            System.out.println("───────────────");
            System.out.println("Products");
            System.out.println("───────────────");
            System.out.println("  1 - Add");
            System.out.println("  2 - Remove");
            System.out.println("  3 - Search by Description");
            System.out.println("  4 - List");
            System.out.println("  0 - Back");
            System.out.println("───────────────");
            System.out.print("Option: ");
            
            option = ScannerUtils.getInt();
            
            switch (option) {
                case 1:
                    add();
                    break;
                case 3:
                    searchByDescription();
                    break;
                case 4:
                    list();
                    break;
                default:
                    System.err.println("Invalid option. Please try again");
            }
            
        } while(option != 0);
        
    }
    
    private void searchByDescription() {
        
        System.out.println("──────────────────────");
        System.out.println("Search by Description");
        System.out.println("──────────────────────");
        
        System.out.print("Search for: ");
        String term = ScannerUtils.getString();
        
        List<Product> found = productRepository.findByDescription(term);
        
        list(found);
    }
    
    private void list() {
        
        System.out.println("───────────────");
        System.out.println("List of Products");
        System.out.println("───────────────");
        
        list(productRepository.findAll());
    }
    private void list(List<Product> products) {
        
        AsciiTable table = new AsciiTable();
        
        table.addRule();
        table.addRow("Id","Description","Price");
                
        for (Product product : products) {
            
            table.addRule();
            table.addRow(
                product.getId(), 
                product.getDescription(), 
                product.getPrice()
            );
        }
        
        table.addRule();
        
        table.getContext().setWidth(50);
        table.getRenderer().setCWC(new CWC_LongestWordMax(50));
        
        System.out.println(table.render());
        
        ScannerUtils.pressEnterToContinue();
    }
    
    private void add() {
        
        System.out.println("───────────────");
        System.out.println("New Product");
        System.out.println("───────────────");
        
        Product product = new Product();
        
        System.out.print("Description: ");
        product.setDescription(ScannerUtils.getString());
        
        System.out.print("Price: ");
        product.setPrice(ScannerUtils.getDouble());
        
        productRepository.save(product);
    }
}
