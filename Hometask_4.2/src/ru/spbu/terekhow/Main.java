package ru.spbu.terekhow;

import ru.spbu.terekhow.exceptions.ListException;
import ru.spbu.terekhow.hashtable.HashTable;
import ru.spbu.terekhow.list.List;
import ru.spbu.terekhow.list.UniqueList;

import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws ListException {
        HashTable<Integer, Integer> table = new HashTable<>(10);
        table.insert(112, 1);
        table.insert(52, 2);
        table.insert(1, 3);
        table.insert(51, 4);
        table.insert(261, 5);
        System.out.println(table.getValue(52));
        table.showInConsole();
    }
}