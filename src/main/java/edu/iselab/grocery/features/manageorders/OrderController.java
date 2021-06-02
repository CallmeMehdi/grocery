package edu.iselab.grocery.features.manageorders;

import edu.iselab.grocery.util.ConsoleUtils;

import java.util.HashSet;
import java.util.Set;

public class OrderController {

    private static OrderController instance;

    public OrderRepository orderRepository = OrderRepository.getInstance();

    public static OrderController getInstance() {

        if (instance == null) {
            instance = new OrderController();
        }

        return instance;
    }

    public void start() {

        while(true){

            ConsoleUtils.clearConsole();

            ConsoleUtils.printHeader("Order2");
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

        ConsoleUtils.clearConsole();

        ConsoleUtils.printHeader("Add Product");

        Cart cart = new Cart();

        Set<Item> items = new HashSet<>();

        Item item = new Item();

        item.setOrder(cart);
        item.setAmount(12);
        item.setValue(13);

        cart.setItems(items);

        double total = 0.0;

        for(Item i : cart.getItems()){
            total += i.getAmount() + i.getValue();
        }

        cart.setTotal(total);

//        order.getItems().add(item);

//        Product product = new Product();
//
//        product.setDescription(ConsoleUtils.promptUserForANotBlankString("Description"));
//        product.setPrice(ConsoleUtils.promptUserForADouble("Price"));
//        product.stock = ConsoleUtils.promptUserForAnInt("Stock");

        orderRepository.save(cart);

        ConsoleUtils.pressEnterToContinue("Successfully added. ");
    }

    protected void list() {

        ConsoleUtils.clearConsole();

        ConsoleUtils.printHeader("List of Products");

        ConsoleUtils.printTable(orderRepository.findAll(), "Id", "Total");

        ConsoleUtils.pressEnterToContinue();
    }

}
