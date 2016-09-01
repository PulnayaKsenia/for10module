package ua.goit.tenthmodule;

import java.util.Scanner;

public class ScannerUtil {
    public static final Scanner in = new Scanner(System.in);

    public static String readString() {
        return in.next();
    }

    public static int readNumber() {
        return in.nextInt();
    }
}
