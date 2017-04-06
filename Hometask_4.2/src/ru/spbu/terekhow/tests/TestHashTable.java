package ru.spbu.terekhow.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import ru.spbu.terekhow.Main;
import ru.spbu.terekhow.hashtable.HashTable;
import ru.spbu.terekhow.hashtable.StringEasyHash;
import ru.spbu.terekhow.hashtable.StringPowHash;

import java.util.ArrayList;

public class TestHashTable {

    @Test
    public void test() {
        HashTable<String, Integer> table = new HashTable<>(100000);
        table.setHash(new StringEasyHash());

        ArrayList<String> tableItems = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            String s = Integer.toString((int)(Math.random() * 10000000000.0));
            while (table.getValue(s) != null) {
                s = Integer.toString((int)(Math.random() * 10000000000.0));
            }
            table.insert(s, i);
            tableItems.add(s);
        }

        for (int i = 0; i < 100000; i++) {
            assertEquals(i, (int) table.getValue(tableItems.get(i)));
        }

        System.out.println(table.getMaxSizeOfList());
        System.out.println(table.getAverageSizeOfList());
        assertEquals(100000, table.getCountOfItems());
    }
}
