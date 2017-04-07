package ru.spbu.terekhow;

import ru.spbu.terekhow.exceptions.ListException;
import ru.spbu.terekhow.hashtable.*;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;

public class Main {
    public static void main(String arg[]) {
        System.out.println(generateRandomString());
        System.out.println(generateRandomString());
        System.out.println(generateRandomString());
        System.out.println(generateRandomString());
        System.out.println(generateRandomString());
        System.out.println(generateRandomString());
        System.out.println(generateRandomString());
        System.out.println(generateRandomString());
        System.out.println(generateRandomString());
        System.out.println(generateRandomString());
    }

    public static String generateRandomString() {
        int size = (int) (1 + Math.random() * 100.0);
        String str = "";
        for (int i = 0; i < size; i++) {
            char a = (char) ('a' + (int) (Math.random() * 26));
            str += a;
        }
        return str;
    }
}