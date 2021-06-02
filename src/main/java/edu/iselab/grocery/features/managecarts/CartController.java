package edu.iselab.grocery.features.managecarts;

import edu.iselab.grocery.features.manageproducts.Product;
import edu.iselab.grocery.features.manageproducts.ProductRepository;
import edu.iselab.grocery.util.ConsoleUtils;

import java.io.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CartController {

    private static CartController instance;

    public CartRepository cartRepository = CartRepository.getInstance();

    public ProductRepository productRepository = ProductRepository.getInstance();

    public static CartController getInstance() {

        if (instance == null) {
            instance = new CartController();
        }

        return instance;
    }

    public void start() {

        while(true){

            ConsoleUtils.clearConsole();

            ConsoleUtils.printHeader("Orders");
            ConsoleUtils.println("Menu:");
            ConsoleUtils.println("1 - Add Order");
            ConsoleUtils.println("2 - List");
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
                case 0:
                    return;
                default:
                    ConsoleUtils.printError(" Invalid option. Please try again");
            }
        }
    }

    private void add() {

        Cart cart = new Cart();

        while(true) {

            ConsoleUtils.clearConsole();

            ConsoleUtils.printHeader("Add Order");

            ConsoleUtils.println("Menu:");
            ConsoleUtils.println("1 - Add Item");
            ConsoleUtils.println("2 - List Items");
            ConsoleUtils.println("3 - Save");
            ConsoleUtils.println("0 - Back");
            ConsoleUtils.printLine();

            ConsoleUtils.println("Total Cart: "+cart.getTotal());

            int option = ConsoleUtils.promptUserForAnInt("Option");

            switch (option) {
                case 1:
                    addNewItem(cart);
                    break;
                case 2:
                    listItems(cart);
                    break;
                case 3:
                    cartRepository.save(cart);
                    ConsoleUtils.pressEnterToContinue("Successfully added. ");
                    return;
                case 0:
                    return;
                default:
                    ConsoleUtils.printError(" Invalid option. Please try again");
            }
        }
    }

    public void addNewItem(Cart cart){

        ConsoleUtils.printHeader("Search by Id");

        long id = (long) ConsoleUtils.promptUserForAnInt("Search for");

        Product found = productRepository.findById(id);

        if (found == null) {
            ConsoleUtils.printError("Product not found");
            return;
        }

        int amount = ConsoleUtils.promptUserForAnInt("Amount");

        if (found.stock - amount <= 0) {
            ConsoleUtils.printError("There is no stock");
            return;
        }

        Item item = new Item();

        item.setAmount(amount);
        item.setValue(found.getPrice());
        item.setProductId(found.getId());
        item.productName = found.getDescription();

        cart.addItem(item);

        found.stock -= amount;
    }

    public void listItems(Cart cart){
        ConsoleUtils.printTable(cart.getItems(), "Id", "Product Name", "Value", "Amount", "Price");
        ConsoleUtils.pressEnterToContinue();
    }

    protected void list() {

        ConsoleUtils.clearConsole();

        ConsoleUtils.printHeader("List of Products");

        ConsoleUtils.printTable(cartRepository.findAll(), "Id", "Total");

        ConsoleUtils.pressEnterToContinue();
    }

}
