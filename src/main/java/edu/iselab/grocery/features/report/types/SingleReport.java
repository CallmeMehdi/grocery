package edu.iselab.grocery.features.report.types;

import edu.iselab.grocery.features.managecarts.Cart;
import edu.iselab.grocery.util.ConsoleUtils;

import java.util.List;

public class SingleReport extends AbstractReport {

    @Override
    public void execute(){

        List<Cart> carts = cartRepository.findAll();

        double total = 0.0;

        for(Cart cart : carts){
            total += cart.getTotal();
        }

        ConsoleUtils.printTable(carts, "Id", "Total");
        ConsoleUtils.printLine();
        ConsoleUtils.println("Total: " + total);
    }
}
