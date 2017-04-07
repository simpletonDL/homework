package ru.spbu.terekhow.hashtable;

/**
 * This is hash for strings. Summed up keycodes of chars.
 * I don`t advise to use it, when you need to hash so many string.
 */
public class StringEasyHash implements Hash<String> {
    private final int MAXINT = 2147483647;

    @Override
    public int getHash(String str) {
        long hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash += str.charAt(i);
            hash %= MAXINT;
        }
        return (int) hash;
    }
}
