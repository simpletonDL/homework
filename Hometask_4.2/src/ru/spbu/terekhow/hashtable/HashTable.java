package ru.spbu.terekhow.hashtable;

/**
 * Interface for hash tables. Hash table keep pairs (key, value) and
 * allow to do the functions below.
 * @param <KeyType>
 *     Type of key
 * @param <ValueType>
 *     Type of value
 */
public interface HashTable<KeyType, ValueType> {
    /**
     * Insert value in the place of key. Note, that if
     * some value have already been in the place of key,
     * value wil be overwrite.
     */
    void insert(KeyType key, ValueType value);

    /**
     * Return value int the place of key, or null, if it is empty.
     * Note, that if you want to check existence of value in hash table,
     * you need to compare result this function and null.
     */
    ValueType getValue(KeyType key);

    /**
     * Delete value from key`s place. If it doesn`t exist, nothing happened.
     */
    void delete(KeyType key);

    /**
     * Set new Hash and redo creation of table. It means, that
     * all key`s rehashing.
     */
    void setHash(Hash<KeyType> newHash);

    /**
     * Return load factor of the table. Load factor = count of collision / size of table.
     */
    double getLoadFactor();

    /**
     * Return count of items in the table.
     */
    int getCountOfItems();
}
