package ru.spbu.terekhow.hashtable;

public class StringEasyHash implements Hash<String> {
    final int MAXINT = 2147483647;

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
