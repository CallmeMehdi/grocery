package edu.iselab.grocery.features.manageproducts;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestWordMax;
import edu.iselab.grocery.util.ConsoleUtils;

import java.io.Console;
import java.util.Arrays;
import java.util.List;

public class ProductController {

    private static ProductController instance;

    public ProductRepository productRepository = ProductRepository.getInstance();

    public static ProductController getInstance() {

        if (instance == null) {
            instance = new ProductController();
        }

        return instance;
    }

    public void start() {

        while(true){

            ConsoleUtils.clearConsole();

            ConsoleUtils.printHeader("Products");
            ConsoleUtils.println("Menu:");
            ConsoleUtils.println("1 - Add Product");
            ConsoleUtils.println("2 - List Product");
            ConsoleUtils.println("3 - Search by Id");
            ConsoleUtils.println("4 - Search by Description");
            ConsoleUtils.println("5 - Edit Product");
            ConsoleUtils.println("0 - Back");
            ConsoleUtils.printLine();

            int option = ConsoleUtils.promptUserForAnInt("Option");

            switch (option) {
                case 1:
                    add();
                    break;
                case 2:
                    list();
                    break;
                case 3:
                    searchById();
                    break;
                case 4:
                    searchByDescription();
                    break;
                case 5:
                    edit();
                    break;
                case 0:
                    return;
                default:
                    ConsoleUtils.printError(" Invalid option. Please try again");
            }
        }
    }

    private void add() {

        ConsoleUtils.clearConsole();

        ConsoleUtils.printHeader("Add Product");

        Product product = new Product();

        product.setDescription(ConsoleUtils.promptUserForANotBlankString("Description"));
        product.setPrice(ConsoleUtils.promptUserForADouble("Price"));
        product.stock = ConsoleUtils.promptUserForAnInt("Stock");

        productRepository.save(product);

        ConsoleUtils.pressEnterToContinue("Successfully added. ");
    }

    protected void list() {

        ConsoleUtils.clearConsole();

        ConsoleUtils.printHeader("List of Products");

        ConsoleUtils.printTable(productRepository.findAll(), "Id", "Description", "Price", "Stock");

        ConsoleUtils.pressEnterToContinue();
    }

    public void searchById() {

        ConsoleUtils.clearConsole();

        ConsoleUtils.printHeader("Search by Id");

        long id = (long) ConsoleUtils.promptUserForAnInt("Search for");

        Product found = productRepository.findById(id);

        if (found == null) {
            ConsoleUtils.printError("Product not found");
        } else {
            ConsoleUtils.printTable(Arrays.asList(found), "Id", "Description", "Price", "Stock");
        }

        ConsoleUtils.pressEnterToContinue();
    }

    public void searchByDescription() {

        ConsoleUtils.clearConsole();

        ConsoleUtils.printHeader("Search by Description");

        String term = ConsoleUtils.promptUserForANotBlankString("Search for");

        List<Product> found = productRepository.findByDescription(term);

        ConsoleUtils.printTable(found, "Id", "Description", "Price", "Stock");

        ConsoleUtils.pressEnterToContinue();
    }

    public void edit() {

        ConsoleUtils.clearConsole();

        ConsoleUtils.printHeader("Edit Product");

        long term = (long) ConsoleUtils.promptUserForAnInt("Product Id");

        Product found = productRepository.findById(term);

        if (found == null) {
            ConsoleUtils.printError("Product not found");
            return;
        }

        found.setDescription(ConsoleUtils.promptUserForANotBlankString("Description"));
        found.setPrice(ConsoleUtils.promptUserForADouble("Price"));
        found.stock = ConsoleUtils.promptUserForAnInt("Stock");

        productRepository.save(found);

        ConsoleUtils.pressEnterToContinue("Successfully added. ");
    }
}
