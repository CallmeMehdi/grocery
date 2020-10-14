package edu.iselab.grocery.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.math.NumberUtils;

import de.vandermeer.asciitable.AsciiTable;

public class ConsoleUtils {

    private static Scanner scan = new Scanner(System.in);
    
    public static String getString() {
        return scan.nextLine();
    }
    
    public static String promptUserForAString() {

        String str = getString();

        return str;
    }
    
    public static int promptUserForAnInt() {

        String str = getString();

        while (!NumberUtils.isCreatable(str)) {

            System.err.println(String.format("'%s' is not a valid integer", str));

            str = getString();
        }

        return NumberUtils.toInt(str);
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
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println();
        System.out.println("Press ENTER to continue...");
        
        try {
            br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public final static void clear() {
        
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
    
    public static void printRectangle(String text) {
        
        AsciiTable table = new AsciiTable();
        
        table.getContext().setWidth(50);
        
        table.addRule();
        table.addRow(text);
        table.addRule();
        
        System.out.println(table.render());
    }
    
    public static void printLine() {
        printLine(50);
    }
    
    private static void printLine(int size) {

        for (int i = 0; i < size; i++) {
            System.out.print("─");
        }

        System.out.println();
    }
}
