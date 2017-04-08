package ru.spbu.terekhow;

import ru.spbu.terekhow.exceptions.EmptyQueue;

/**
 * Интерфейс очереди с целочисленными приоритетами.
 * @param <ValueType>
 *     Тип хранимого значения.
 */
public interface PriorytyQueue<ValueType> {
    /**
     * Добавлет элемент value с приоритетом priority
     * @param value
     * Значение
     * @param priority
     * Приоритет
     */
    void enqueue(ValueType value, int priority);

    /**
     * Удаляет элемент с наибольшим приоритетом и возвращает его.
     * @return
     * Значение элемента с наибольшим приоритетом
     * @throws EmptyQueue
     * Бросается когда происходит удаление из пустой очереди
     */
    public ValueType dequeue() throws EmptyQueue;
}
