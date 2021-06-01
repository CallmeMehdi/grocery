package edu.iselab.grocery;

import edu.iselab.grocery.features.manageproducts.ProductController;
import edu.iselab.grocery.util.ConsoleUtils;

public class Launcher {

    public static void main(String[] args) {

        int selectedOption = 0;

        do {

            ConsoleUtils.clearConsole();

            ConsoleUtils.printHeader("Grocery by ISE Lab", "An example of a grocery store system for academic purpose");
            ConsoleUtils.println("Menu:");
            ConsoleUtils.println("1 - Products");
            ConsoleUtils.println("0 - Quit");
            ConsoleUtils.printLine();
            ConsoleUtils.println("Option: ");

            selectedOption = ConsoleUtils.promptUserForAnInt();

            switch (selectedOption) {
                case 1:
                    ProductController.getInstance().start();
                    break;
                case 0:
                    ConsoleUtils.println("Bye!");
                    break;
                default:
                    ConsoleUtils.printError("Invalid option. Please try again");
            }

        } while(selectedOption != 0);
    }
}
