package edu.iselab.grocery;

import edu.iselab.grocery.database.SQLDatabase;
import edu.iselab.grocery.features.managecarts.CartController;
import edu.iselab.grocery.features.manageproducts.ProductController;
import edu.iselab.grocery.features.report.ReportController;
import edu.iselab.grocery.util.ConsoleUtils;

public class Launcher {

    public static void main(String[] args) {

        SQLDatabase.getInstance().open();

        while (true) {

            ConsoleUtils.clearConsole();

            ConsoleUtils.printLogo();
            ConsoleUtils.println("Menu:");
            ConsoleUtils.println("1 - Products");
            ConsoleUtils.println("2 - Orders");
            ConsoleUtils.println("3 - Reports");
            ConsoleUtils.println("0 - Quit");
            ConsoleUtils.printLine();

            int option = ConsoleUtils.promptUserForAnInt("Option");

            switch (option) {
                case 1:
                    ProductController.getInstance().start();
                    break;
                case 2:
                    CartController.getInstance().start();
                    break;
                case 3:
                   ReportController.getInstance().start();
                    break;
                case 0:
                    quit();
                    break;
                default:
                    ConsoleUtils.printError("Invalid option. Please try again");
            }
        }
    }

    protected static void quit(){
        ConsoleUtils.println("Bye!");
        SQLDatabase.getInstance().close();
        System.exit(1);
    }
}
