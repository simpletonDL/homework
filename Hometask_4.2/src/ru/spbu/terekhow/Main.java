package ru.spbu.terekhow;

import org.omg.CORBA.INTERNAL;
import ru.spbu.terekhow.exceptions.ListException;
import ru.spbu.terekhow.hashtable.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ListException {

        HashTable<String, Integer> table = new HashTable<>(9);
        table.setHash(new StringEasyHash());

        table.insert("ab", 1);
        table.insert("ba", 1);

        table.showInConsole();

        table.setHash(new StringPowHash());
        table.showInConsole();

        /*table.insert(112, 1);
        table.insert(52, 2);
        table.insert(1, 3);
        table.insert(51, 4);
        table.insert(261, 5);
        table.insert(57, 4);
        table.insert(267, 51);
        table.insert(513, 4);
        table.insert(212, 5);
        table.showInConsole();
        System.out.println(table.getValue(26));//*/
        Hash a = new StringPowHash();
    }
}