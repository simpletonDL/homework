package ru.spbu.terekhow.hashtable;

/**
 * Interface for hashing keys. If you want to create
 * you own hash function for some class, you need to
 * create new class implements Hash and overwrite
 * getHash.
 * @param <T>
 *     Key type.
 */
public interface Hash<T> {
    /**
     * Return hash of the key.
     */
    int getHash(T key);
}
