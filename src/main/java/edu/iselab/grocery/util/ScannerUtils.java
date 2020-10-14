package edu.iselab.grocery.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

public class ScannerUtils {

    private static Scanner scanner = new Scanner(System.in);

    public static String getString() {
        return scanner.next();
    }
    
    public static void nextLine() {
        scanner.nextLine();
    }

    public static int getInt() {

        String str = getString();

        while (!NumberUtils.isCreatable(str)) {

            System.err.println(String.format("'%s' is not a valid integer", str));

            str = getString();
        }

        return NumberUtils.toInt(str);
    }

    public static double getDouble() {

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

}
