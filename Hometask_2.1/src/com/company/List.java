package com.company;

public interface List {
    void insert(int index, String value);
    void pushBack(String value);
    void pushFront(String value);
    void delete(int index);

    int getIndexOfElement(String value);
    String retrieve(int index);

    void showInConsole();
    int getSize();
}