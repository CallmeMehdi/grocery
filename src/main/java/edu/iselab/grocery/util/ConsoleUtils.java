package edu.iselab.grocery.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.math.NumberUtils;

import de.vandermeer.asciitable.AsciiTable;

public class ConsoleUtils {

    private final static Scanner scan = new Scanner(System.in);

    private static String getString() {
        return scan.nextLine();
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
        return promptUserForAnInt();
    }

    public static int promptUserForAnInt() {

        String str = getString();

        while (!NumberUtils.isCreatable(str)) {

            System.err.println(String.format("'%s' is not a valid integer", str));

            str = getString();
        }

        return NumberUtils.toInt(str);
    }

    public static double promptUserForADouble(String field) {
        ConsoleUtils.print(field + ": ");
        return promptUserForADouble();
    }

    public static double promptUserForADouble() {

        String str = getString();

        while (!NumberUtils.isCreatable(str)) {

            System.err.println(String.format("'%s' is not a valid double", str));

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

    public static void printHeader(String... texts) {

        AsciiTable table = new AsciiTable();

        table.getContext().setWidth(60);

        table.addRule();

        for(String text : texts) {
            table.addRow(text);
        }

        table.addRule();

        println(table.render());
    }

    public static void printLine() {
        printLine(60);
    }

    public static void println(Object text){
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
}
