package ru.spbu.terekhow.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import ru.spbu.terekhow.hashtable.*;
import java.util.ArrayList;

public class TestHashTable {

    @Test
    public void testHashTable1() {
        final int MAX_STRING_LENGTH = 100;
        final int TABLE_SIZE = 100000;
        final int COUNT_STRINGS = 100000;

        HashTableByLists<String, Integer> table = new HashTableByLists<>(TABLE_SIZE);
        table.setHash(new StringPowHash());
        ArrayList<String> keyList = setHashTableRandomAndGetListOfItemsKeys(table,
                                                                            COUNT_STRINGS,
                                                                            MAX_STRING_LENGTH);
        ArrayList<Integer> actualList = getActualListByKeyList(keyList, table);
        ArrayList<Integer> expectedList = getExpectedList(COUNT_STRINGS);

        assertEquals(expectedList, actualList);
        showTableStatus(table);
    }

    @Test
    public void testSetHash() {
        HashTableByLists<String, Integer> table = new HashTableByLists<>(100000);
        table.setHash(new StringPowHash());

        ArrayList<String> keyList = setHashTableRandomAndGetListOfItemsKeys(table,
                                                                            100000,
                                                                            10);
        ArrayList<Integer> actualList = getActualListByKeyList(keyList, table);
        ArrayList<Integer> expectedList = getExpectedList(keyList.size());
        assertEquals(expectedList, actualList);

        table.setHash(new StringEasyHash());
        actualList = getActualListByKeyList(keyList, table);
        assertEquals(expectedList, actualList);

        table.setHash(new StringPowHash());
        actualList = getActualListByKeyList(keyList, table);
        assertEquals(expectedList, actualList);
    }//*/

    @Test
    public void testCountOfCollision() {
        HashTableByLists<Integer, Integer> table = new HashTableByLists<>(10);
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

    private ArrayList<String> setHashTableRandomAndGetListOfItemsKeys(HashTableByLists<String, Integer> table,
                                                                      int countOfStrings,
                                                                      int maxStringLength) {
        ArrayList<String> keyList = new ArrayList<>();
        for (int i = 0; i < countOfStrings; i++) {
            String s = generateRandomString(maxStringLength);
            while (table.getValue(s) != null) {
                s = generateRandomString(maxStringLength);
            }
            table.insert(s, i);
            keyList.add(s);
        }
        return keyList;
    }

    private ArrayList<Integer> getActualListByKeyList(ArrayList<String> keyList,
                                                      HashTableByLists<String, Integer> table) {
        ArrayList<Integer> actualList = new ArrayList<>();
        for (int i = 0; i < keyList.size(); i++) {
            String targetKey = keyList.get(i);
            actualList.add(table.getValue(targetKey));
        }
        return actualList;
    }

    private ArrayList<Integer> getExpectedList(int sizeOfKeyList) {
        ArrayList<Integer> expectedList = new ArrayList<>();
        for (int i = 0; i < sizeOfKeyList; i++) {
            expectedList.add(i);
        }
        return expectedList;
    }

    private String generateRandomString(int maxsize) {
        int size = (int) (1 + Math.random() * maxsize);
        String str = "";
        for (int i = 0; i < size; i++) {
            str += (char) 'a' + (int) (Math.random() * 26);
        }
        return str;
    }

    private <KeyType, ValueType> void showTableStatus(HashTableByLists<KeyType, ValueType> table) {
        System.out.println("Max size of list: " + table.getMaxSizeOfList());
        System.out.println("Average size of list: " + table.getAverageSizeOfList());
        System.out.println("Count of elements: " + table.getCountOfItems());
    }
}
