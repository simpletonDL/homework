package ru.spbu.terekhow;

public interface List<T> {
    void insert(int index, T value);
    void pushBack(T value);
    void pushFront(T value);
    void delete(int index);

    int getIndexOfElement(T value);
    T retrieve(int index);

    void showInConsole();
    int getSize();
}