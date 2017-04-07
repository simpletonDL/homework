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
    public void testHashTable1() {
        final int MAXSTRINGLENGTH = 200;

        HashTable<String, Integer> table = new HashTable<>(100000);
        table.setHash(new StringPowHash());

        ArrayList<String> tableItems = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            String s = generateRandomString(MAXSTRINGLENGTH);
            while (table.getValue(s) != null) {
                s = generateRandomString(MAXSTRINGLENGTH);
            }
            table.insert(s, i);
            tableItems.add(s);
        }

        for (int i = 0; i < 100000; i++) {
            assertEquals(i, (int) table.getValue(tableItems.get(i)));
        }

        System.out.println("Max size of list: " + table.getMaxSizeOfList());
        System.out.println("Average size of list: " + table.getAverageSizeOfList());
        assertEquals(100000, table.getCountOfItems());
    }

    @Test
    public void testHashTable2() {
        HashTable<String, Integer> table = new HashTable<>(100000);
        table.setHash(new StringPowHash());

        ArrayList<String> tableItems = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            String s = Integer.toString((int) (Math.random() * 1000000000));
            while (table.getValue(s) != null) {
                s = Integer.toString((int) (Math.random() * 1000000000));
            }
            table.insert(s, i);
            tableItems.add(s);
        }

        for (int i = 0; i < 100000; i++) {
            assertEquals(i, (int) table.getValue(tableItems.get(i)));
        }

        System.out.println("Max size of list: " + table.getMaxSizeOfList());
        System.out.println("Averqage size of list: " + table.getAverageSizeOfList());
        assertEquals(100000, table.getCountOfItems());
    }

    @Test
    public void testCountOfCollision() {
        HashTable<Integer, Integer> table = new HashTable<>(10);
        table.insert(1, 1);
        table.insert(11, 2);
        table.insert(111, 3);
        table.insert(1111, 4);
        assertEquals(1, table.getCountOfCollision());
        table.insert(2, 1);
        table.insert(22, 2);
        assertEquals(2, table.getCountOfCollision());
        table.delete(1);
        table.delete(11);
        table.delete(111);
        assertEquals(1, table.getCountOfCollision());
        table.delete(22);
        assertEquals(0, table.getCountOfCollision());
        table.insert(3, 1);
        assertEquals(0, table.getCountOfCollision());
        table.insert(3, 1);
        assertEquals(0, table.getCountOfCollision());
        table.insert(3, 2);
        assertEquals(0, table.getCountOfCollision());
        table.insert(13, 1);
        assertEquals(1, table.getCountOfCollision());
    }

    public String generateRandomString(int maxsize) {
        int size = (int) (1 + Math.random() * maxsize);
        String str = "";
        for (int i = 0; i < size; i++) {
            str += (char) 'a' + (int) (Math.random() * 26);
        }
        return str;
    }
}
