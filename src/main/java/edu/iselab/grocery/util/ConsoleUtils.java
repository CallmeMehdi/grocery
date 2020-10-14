package edu.iselab.grocery.util;

import org.apache.commons.lang3.SystemUtils;

public class ConsoleUtils {

    public final static void clearConsole() {
        
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

}
