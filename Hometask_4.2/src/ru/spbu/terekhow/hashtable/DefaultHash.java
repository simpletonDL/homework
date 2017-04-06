package ru.spbu.terekhow.hashtable;

public class DefaultHash<T> implements Hash<T> {
    @Override
    public int getHash(T key) {
        return key.hashCode();
    }
}
