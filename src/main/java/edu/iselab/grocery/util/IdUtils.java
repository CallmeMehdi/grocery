package edu.iselab.grocery.util;

public class IdUtils {

    private static int UUID = 1;

    public static int getNextId() {
        return UUID++;
    }

}
