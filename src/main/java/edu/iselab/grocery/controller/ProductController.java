package edu.iselab.grocery.controller;

import java.util.Arrays;
import java.util.List;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestWordMax;
import edu.iselab.grocery.persistence.model.Product;
import edu.iselab.grocery.persistence.repository.ProductRepository;
import edu.iselab.grocery.util.ConsoleUtils;

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
            
            ConsoleUtils.clear();
            
            ConsoleUtils.printRectangle("Products");
            
            System.out.println(" 1 - Add");
            System.out.println(" 2 - Remove");
            System.out.println(" 3 - Search by Id");
            System.out.println(" 4 - Search by Description");
            System.out.println(" 5 - List");
            System.out.println(" 0 - Back");
            
            ConsoleUtils.printLine();
            
            System.out.print(" Option: ");
            
            option = ConsoleUtils.promptUserForAnInt();
            
            switch (option) {
                case 1:
                    add();
                    break;
                case 2:
                    remove();
                    break;
                case 3:
                    searchById();
                    break;
                case 4:
                    searchByDescription();
                    break;
                case 5:
                    list();
                    break;
                default:
                    System.err.println(" Invalid option. Please try again");
            }
            
        } while(option != 0);
        
    }
    
    public void remove() {

        ConsoleUtils.clear();
        
        ConsoleUtils.printRectangle("Remove");
        
        System.out.print(" Search for id: ");
        int id = ConsoleUtils.promptUserForAnInt();

        Product removed = productRepository.removeById(id);
        
        System.out.println();
        
        if (removed == null) {
            System.err.println(" Product not foud");
        } else {
            System.out.println(" Successfully removed");
        }
            
        ConsoleUtils.pressEnterToContinue();
    }
    
    public void searchById() {

        ConsoleUtils.clear();
        
        ConsoleUtils.printRectangle("Search by Id");
        
        System.out.print(" Search for: ");
        int term = ConsoleUtils.promptUserForAnInt();

        Product found = productRepository.findById(term);

        if (found == null) {
            System.err.println(" Product not found");
        } else {
            list(Arrays.asList(found));
        }
    }
    
    private void searchByDescription() {
        
        ConsoleUtils.clear();
        
        ConsoleUtils.printRectangle("Search by Description");
        
        System.out.print(" Search for: ");
        String term = ConsoleUtils.promptUserForANotBlankString();
        
        List<Product> found = productRepository.findByDescription(term);
        
        list(found);
    }
    
    private void list() {
        
        ConsoleUtils.clear();
        
        ConsoleUtils.printRectangle("List of Products");
        
        list(productRepository.findAll());
    }
    
    private void list(List<Product> products) {
        
        AsciiTable table = new AsciiTable();
        
        table.addRule();
        table.addRow("Id","Description","Price", "Created At");
                
        for (Product product : products) {
            
            table.addRule();
            table.addRow(
                product.getId(), 
                product.getDescription(), 
                product.price,
                product.getCreatedAt()
            );
        }
        
        table.addRule();
        
        table.getContext().setWidth(50);
        table.getRenderer().setCWC(new CWC_LongestWordMax(50));
        
        System.out.println(table.render());
        
        ConsoleUtils.pressEnterToContinue();
    }
    
    private void add() {
        
        ConsoleUtils.clear();
        
        ConsoleUtils.printRectangle("New Product");
        
        Product product = new Product();
        
        System.out.print(" Description: ");
        product.setDescription(ConsoleUtils.promptUserForANotBlankString());
        
        System.out.print(" Price: ");
        product.price = ConsoleUtils.promptUserForADouble();
        
        productRepository.save(product);
        
        System.out.println();
        System.out.println(" Successfully added");
            
        ConsoleUtils.pressEnterToContinue();
    }
}
