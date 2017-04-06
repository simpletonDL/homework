package ru.spbu.terekhow.hashtable;

import ru.spbu.terekhow.exceptions.ListException;
import ru.spbu.terekhow.exceptions.OutOfTheRange;
import ru.spbu.terekhow.exceptions.UnnecessaryAction;
import ru.spbu.terekhow.list.List;
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

    private int countOfItems = 0;
    private int countOfCollision = 0;

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
        countOfItems = 0;
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

    public int getCountOfCollision() {
        return countOfCollision;
    }

    public double getLoadFactor() {
        return (double) countOfItems / (double) size;
    }

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

    //В пизду такой код
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
