package ru.spbu.terekhow.hashtable;

/**
 * This hash for string. Summed up char`s keycode multiplied by pow of 31.
 * This hash is so fast.
 */
public class StringPowHash implements Hash<String> {
    private final int MAXINT = 2147483647;

    @Override
    public int getHash(String str) {
        long hash = 0;
        long pow = 1;
        for (int i = 0; i < str.length(); i++) {
            hash += str.charAt(i) * pow;
            pow *= 31;
            hash %= MAXINT;
            pow %= MAXINT;
        }
        return (int) hash;
    }
}
