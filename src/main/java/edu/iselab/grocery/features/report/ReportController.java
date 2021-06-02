package edu.iselab.grocery.features.report;

import edu.iselab.grocery.features.managecarts.CartRepository;
import edu.iselab.grocery.features.report.types.SingleReport;
import edu.iselab.grocery.util.ConsoleUtils;

public class ReportController {

    private static ReportController instance;

    public CartRepository cartRepository = CartRepository.getInstance();

    public static ReportController getInstance() {

        if (instance == null) {
            instance = new ReportController();
        }

        return instance;
    }

    public void start() {

        while(true){

            ConsoleUtils.clearConsole();

            ConsoleUtils.printHeader("Report");
            ConsoleUtils.println("Menu:");
            ConsoleUtils.println("1 - Simple Report");
            ConsoleUtils.println("2 - Full Report");
            ConsoleUtils.println("0 - Back");
            ConsoleUtils.printLine();

            int option = ConsoleUtils.promptUserForAnInt("Option");

            switch (option) {
                case 1:
                    new SingleReport().execute();
                    break;
                case 2:
                    fullReport();
                    break;
                case 0:
                    return;
                default:
                    ConsoleUtils.printError(" Invalid option. Please try again");
            }
        }
    }



    public void fullReport(){

    }
}
