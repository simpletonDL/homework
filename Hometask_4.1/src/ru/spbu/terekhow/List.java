package ru.spbu.terekhow;

import ru.spbu.terekhow.exceptions.ListException;

public interface List<T> {
    void insert(int index, T value) throws ListException;
    void pushBack(T value) throws ListException;
    void pushFront(T value) throws ListException;
    void delete(int index) throws  ListException;

    int getIndexOfElement(T value);
    T getElementFromIndex(int index) throws ListException;

    void showInConsole();
    int getSize();
}