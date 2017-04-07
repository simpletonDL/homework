package ru.spbu.terekhow.exceptions;

/**
 * Исклюсение для работы с очередью с приоритетами. Может быть
 * брошено при обращении к пустой очереди.
 */
public class EmptyQueue extends Exception {
    public EmptyQueue(){}

    public EmptyQueue(String s) {
        super(s);
    }
}
