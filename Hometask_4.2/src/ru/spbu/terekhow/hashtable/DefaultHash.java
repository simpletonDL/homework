package ru.spbu.terekhow.hashtable;

/**
 * This hash is default. It works only with classes,
 * in which the function hashCode() has been overwrote.
 * If you want to use it in your classes, you mast to
 * overwrite (you class).hashCode().
 */
public class DefaultHash<T> implements Hash<T> {
    @Override
    public int getHash(T key) {
        return key.hashCode();
    }
}
