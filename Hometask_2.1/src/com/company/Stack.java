package com.company;

public interface Stack {
    void push(String value);
    String pop();
    void showInConsole();
    String top();
    int getSize();
    boolean isEmpty();
    boolean isFull();
}
