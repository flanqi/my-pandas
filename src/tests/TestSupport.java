package tests;

import java.io.*;
import java.util.Scanner;

public class TestSupport {
    public static boolean compareFiles(String f1, String f2) throws FileNotFoundException {
        Scanner s1 = new Scanner(new File(f1));
        Scanner s2 = new Scanner(new File(f2));

        String r1 = "";
        String r2 = "";

        while (s1.hasNext()) {
            r1 += s1.nextLine();
            r2 += s2.nextLine();
        }

        s1.close();
        s2.close();


        return r1.equals(r2);
    }


}
