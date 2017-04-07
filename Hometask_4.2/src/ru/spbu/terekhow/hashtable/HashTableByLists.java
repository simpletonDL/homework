package ru.spbu.terekhow.hashtable;

import ru.spbu.terekhow.exceptions.*;
import ru.spbu.terekhow.list.UniqueList;

import java.util.ArrayList;

/**
 * Hash table that working by lists.
 * @param <KeyType>
 *     Type of keys
 * @param <ValueType>
 *     Type of values.
 */
public class HashTableByLists<KeyType, ValueType> implements HashTable<KeyType, ValueType> {
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
            if (key.equals(pairToCompare.key)) {
                return true;
            }
            else
                return false;
        }
    }

    private UniqueList<Pair> table[];
    private int size;
    private Hash<KeyType> hash = new DefaultHash<KeyType>();

    private int countOfItems = 0;
    private int countOfCollision = 0;

    private int hashFunction(KeyType key) {
        return (hash.getHash(key)) % size;
    }

    /**
     * Create hash table with size: 100000.
     */
    public HashTableByLists() {
        this.size = 100000;
        table = new UniqueList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new UniqueList<Pair>();
        }
    }

    /**
     * Create hash table with size: size.
     */
    public HashTableByLists(int size) {
        this.size = size;
        table = new UniqueList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new UniqueList<Pair>();
        }
    }

    @Override
    public void setHash(Hash<KeyType> newHash) {
        ArrayList<Pair> backItems = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < table[i].getSize(); j++) {
                try {
                    Pair target = table[i].getElementFromIndex(j);
                    backItems.add(target);
                } catch (OutOfTheRange outOfTheRange) {
                    System.out.println(outOfTheRange.getMessage());
                }
            }
        }

        hash = newHash;
        countOfItems = 0;
        for (int i = 0; i < size; i++) {
            table[i] = new UniqueList<Pair>();
        }
        for (int i = 0; i < backItems.size(); i++) {
            Pair target = backItems.get(i);
            insert(target.key, target.value);
        }
    }

    @Override
    public void insert(KeyType key, ValueType value) {
        int hash = hashFunction(key);
        Pair newPair = new Pair(key, value);

        try {
            table[hash].pushBack(newPair);
            if (table[hash].getSize() == 2) {
                countOfCollision++;
            }
            countOfItems++;
        } catch (UnnecessaryAction e) {
            int index = table[hash].getIndexOfElement(newPair);
            try {
                table[hash].delete(index);
                table[hash].pushBack(newPair);
            } catch (ListException listException) {
                listException.printStackTrace();
            }
        } catch (ListException listException) {
            listException.printStackTrace();
        }
    }

    @Override
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
            return null;
        }
    }

    @Override
    public void delete(KeyType key) {
        int hash = hashFunction(key);
        int index = table[hash].getIndexOfElement(new Pair(key, null));
        try {
            table[hash].delete(index);
            if (table[hash].getSize() == 1) {
                countOfCollision--;
            }
            countOfItems--;
        } catch (OutOfTheRange outOfTheRange) {

        }
    }

    @Override
    public double getLoadFactor() {
        return (double) countOfItems / (double) size;
    }

    @Override
    public int getCountOfItems() {
        return countOfItems;
    }

    public int getMaxSizeOfList() {
        int maxSize = 0;
        for (int i = 0; i < size; i++) {
            if (maxSize < table[i].getSize()) maxSize = table[i].getSize();
        }
        return maxSize;
    }

    /**
     * Return average size of lists.
     */
    public double getAverageSizeOfList() {
        double averageSize = 0;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (table[i].getSize() != 0) {
                count++;
                averageSize += table[i].getSize();
            }
        }
        return averageSize/count;
    }

    /**
     * Return count of collision. Collision means that there are more than one element in the list.
     */
    public int getCountOfCollision() {
        return countOfCollision;
    }

    /**
     * Note: don`t to use this cast if the size of table so big!
     */
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += i + ": ";
            s += table[i];
            s += '\n';
        }
        return s;
    }
}
