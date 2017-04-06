package ru.spbu.terekhow.hashtable;

public class StringPowHash implements Hash<String> {
    final int MAXINT = 2147483647;

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
