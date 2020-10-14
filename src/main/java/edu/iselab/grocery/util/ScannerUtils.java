package edu.iselab.grocery.util;

import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

public class ScannerUtils {

    private static Scanner scanner = new Scanner(System.in);

    public static String getString() {
        return scanner.next();
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

}
