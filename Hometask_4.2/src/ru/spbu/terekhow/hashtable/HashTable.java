package ru.spbu.terekhow.hashtable;

import ru.spbu.terekhow.exceptions.ListException;
import ru.spbu.terekhow.exceptions.OutOfTheRange;
import ru.spbu.terekhow.exceptions.UnnecessaryAction;
import ru.spbu.terekhow.list.UniqueList;

import javax.swing.*;
import java.security.Key;

public class HashTable<KeyType, ValueType> {
    public class Pair {
        KeyType key;
        ValueType value;

        public Pair(KeyType key, ValueType value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return ("(" + key +", " + value + ")");
        }

        @Override
        public boolean equals(Object obj) {
            Pair pairToCompare = (Pair) obj;
            if (key == pairToCompare.key) {
                return true;
            }
            else
                return false;
        }
    }

    public UniqueList<Pair> table[];
    private int size;

    public HashTable(int size) {
        this.size = size;
        table = new UniqueList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new UniqueList<Pair>();
        }
    }

    private int hashFunction(KeyType key) {
        return (key.hashCode()) % size;
    }

    public void insert(KeyType key, ValueType value) throws ListException {
        int hash = hashFunction(key);
        Pair newPair = new Pair(key, value);
        try {
            table[hash].pushBack(newPair);
        } catch (UnnecessaryAction e) {
            int index = table[hash].getIndexOfElement(newPair);
            table[hash].delete(index);
            table[hash].pushBack(newPair);
        } catch (ListException e) {
            e.printStackTrace();
        }
    }

    public void showInConsole() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            table[i].showInConsole();
        }
    }

    public ValueType getValue(KeyType key) {
        int hash = hashFunction(key);
        int index = table[hash].getIndexOfElement(new Pair(key, null));
        if (index == -1) {
            return null;
        }
        try {
            return table[hash].getElementFromIndex(index).value;
        } catch (OutOfTheRange outOfTheRange) {
            outOfTheRange.printStackTrace();
        }
        return null;
    }
}
