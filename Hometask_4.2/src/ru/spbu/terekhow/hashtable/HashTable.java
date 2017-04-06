package ru.spbu.terekhow.hashtable;

import ru.spbu.terekhow.exceptions.ListException;
import ru.spbu.terekhow.exceptions.OutOfTheRange;
import ru.spbu.terekhow.exceptions.UnnecessaryAction;
import ru.spbu.terekhow.list.UniqueList;

import java.util.ArrayList;

public class HashTable<KeyType, ValueType> {
    private class Pair {
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
            //System.out.print(toString() + " == " + pairToCompare + " " + (key.equals(pairToCompare.key)) + "\n");
            if (key.equals(pairToCompare.key)) {
                return true;
            }
            else
                return false;
        }
    }

    private UniqueList<Pair> table[];
    private int size;
    public Hash<KeyType> hash = new DefaultHash<KeyType>();

    public HashTable(int size) {
        this.size = size;
        table = new UniqueList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new UniqueList<Pair>();
        }
    }

    public void setHash(Hash<KeyType> newHash) {
        ArrayList<Pair> backItems = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < table[i].getSize(); j++) {
                try {
                    Pair target = table[i].getElementFromIndex(j);
                    backItems.add(target);
                } catch (OutOfTheRange e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        hash = newHash;
        for (int i = 0; i < size; i++) {
            table[i] = new UniqueList<Pair>();
        }
        for (int i = 0; i < backItems.size(); i++) {
            Pair target = backItems.get(i);
            insert(target.key, target.value);
        }//*/
    }

    private int hashFunction(KeyType key) {
        return (hash.getHash(key)) % size;
    }

    public void insert(KeyType key, ValueType value) {
        int hash = hashFunction(key);
        Pair newPair = new Pair(key, value);

        try {
            table[hash].pushBack(newPair);
        } catch (UnnecessaryAction unnecessaryAction) {
            int index = table[hash].getIndexOfElement(newPair);
            try {
                table[hash].delete(index);
                table[hash].pushBack(newPair);
            } catch (ListException listException) {
                System.out.println("Can`t insert " + newPair + ", troubles in HashTable.");
            }
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
        } catch (OutOfTheRange e) {
            System.out.println("Can`t get " + key + ", troubles in HashTable.");
            return null;
        }
    }

    public void delete(KeyType key) {
        int hash = hashFunction(key);
        int index = table[hash].getIndexOfElement(new Pair(key, null));
        try {
            table[hash].delete(index);
        } catch (OutOfTheRange outOfTheRange) {

        }
    }

    //В пизду такой код
    public void showInConsole() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            table[i].showInConsole();
        }
        System.out.println();
    }
}
