package edu.iselab.grocery.features.manageproducts;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.CWC_LongestWordMax;
import edu.iselab.grocery.util.ConsoleUtils;

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

        int selectedOption = 0;

        do {

            ConsoleUtils.clearConsole();

            ConsoleUtils.printHeader("Products");

            ConsoleUtils.println("Menu:");
            ConsoleUtils.println("1 - Add Product");
            ConsoleUtils.println("2 - List Product");
            ConsoleUtils.println("3 - Search by Id");
            ConsoleUtils.println("4 - Edit Product");
            ConsoleUtils.println("0 - Back");
            ConsoleUtils.printLine();
            ConsoleUtils.println("Option: ");

            selectedOption = ConsoleUtils.promptUserForAnInt();

            switch (selectedOption) {
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
                    edit();
                    break;
                case 0:
                    break;
                default:
                    System.err.println(" Invalid option. Please try again");
            }

        } while(selectedOption != 0);
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

        AsciiTable table = new AsciiTable();

        table.addRule();
        table.addRow("Id", "Description", "Price", "Stock", "Last Modified Date");

        for (Product product : productRepository.findAll()) {

            table.addRule();

            table.addRow(
                product.getId(),
                product.getDescription(),
                product.getPrice(),
                product.stock,
                product.lastModifiedDate
            );
        }

        table.addRule();

        table.getContext().setWidth(50);
        table.getRenderer().setCWC(new CWC_LongestWordMax(50));

        System.out.println(table.render());

        ConsoleUtils.pressEnterToContinue();
    }

    public void searchById() {

        ConsoleUtils.clearConsole();

        ConsoleUtils.printHeader("Search by Id");

        long term = (long) ConsoleUtils.promptUserForAnInt("Search for");

        Product found = productRepository.findById(term);

        if (found == null) {
            ConsoleUtils.printError("Product not found");
        } else {
            ConsoleUtils.println(found);
        }
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
