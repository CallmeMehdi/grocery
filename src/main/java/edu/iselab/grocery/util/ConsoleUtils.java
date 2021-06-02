package edu.iselab.grocery.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import de.vandermeer.asciitable.CWC_LongestWordMax;
import edu.iselab.grocery.features.manageproducts.Product;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.math.NumberUtils;

import de.vandermeer.asciitable.AsciiTable;

public class ConsoleUtils {

    private final static Scanner scan = new Scanner(System.in);

    public static final String RESET = "\u001B[0m";

    public static final String PURPLE = "\u001B[35m";

    private static String getString() {
        return scan.nextLine();
    }

    public static void printLogo(){

        println(PURPLE + "   _____"                                                  + RESET);
        println(PURPLE + " / ____|"                                                  + RESET);
        println(PURPLE + "| |  __   _ __    ___     ___    ___   _ __   _   _"       + RESET);
        println(PURPLE + "| | |_ | | '__|  / _ \\   / __|  / _ \\ | '__| | | | |"    + RESET);
        println(PURPLE + "| |__| | | |    | (_) | | (__  |  __/ | |    | |_| |"      + RESET);
        println(PURPLE + " \\_____| |_|     \\___/   \\___|  \\___| |_|     \\__, |" + RESET);
        println(PURPLE + "                                               __/ |"      + RESET);
        println(PURPLE + "                                              |___/"       + RESET);
        println("An example of a grocery store system for academic purpose");
        printLine();
    }

    public static String promptUserForAString() {

        String str = getString();

        return str;
    }

    public static String promptUserForANotBlankString(String field) {
        ConsoleUtils.print(field + ": ");
        return promptUserForANotBlankString();
    }

    public static String promptUserForANotBlankString() {

        String str = getString();

        while (str == null || str.trim().isEmpty()) {

            System.err.println(String.format("'%s' is not a valid string", str));

            str = getString();
        }

        return str;
    }

    public static int promptUserForAnInt(String field) {

        ConsoleUtils.print(field + ": ");
        String str = getString();

        while (!NumberUtils.isCreatable(str)) {

            System.err.println(String.format("'%s' is not a valid integer", str));

            System.out.println(field + ": ");
            str = getString();
        }

        return NumberUtils.toInt(str);
    }

    public static double promptUserForADouble(String field) {

        ConsoleUtils.print(field + ": ");
        String str = getString();

        while (!NumberUtils.isCreatable(str)) {

            System.err.println(String.format("'%s' is not a valid double", str));

            ConsoleUtils.print(field + ": ");
            str = getString();
        }

        return NumberUtils.toDouble(str);
    }

    public static void pressEnterToContinue() {
        pressEnterToContinue("");
    }

    public static void pressEnterToContinue(String header) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println();
        System.out.print(header + "Press ENTER to continue...");

        try {
            br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearConsole() {

        try {

            if (SystemUtils.IS_OS_WINDOWS) {
                Runtime.getRuntime().exec("cls");
            } else if (SystemUtils.IS_OS_MAC) {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }

        } catch (final Exception e) {
            // Handle any exceptions.
        }
    }

    public static void printHeader(String text) {

        ConsoleUtils.printLine();
        ConsoleUtils.println(text);
        ConsoleUtils.printLine();
    }

    public static void printLine() {
        printLine(60);
    }

    public static void println(Object text) {
        System.out.println(text);
    }

    private static void printLine(int size) {

        for (int i = 0; i < size - 1; i++) {
            System.out.print("─");
        }

        System.out.println();
    }

    public static void printError(String error) {
        System.err.println(error);
    }

    public static void print(String text) {
        System.out.print(text);
    }

    public static <T> void printTable(Set<T> items, Object... header) {
        printTable(new ArrayList<>(items), header);
    }
    public static <T> void printTable(List<T> items, Object... header) {

        AsciiTable table = new AsciiTable();

        table.addRule();
        table.addRow(header);

        for (T item : items) {

            table.addRule();

            String[] parts = item.toString().split("\t");

            table.addRow((Object[]) parts);
        }

        table.addRule();

        table.getContext().setWidth(60);
        table.getRenderer().setCWC(new CWC_LongestWordMax(60));

        System.out.println(table.render());
    }
}
