package ru.spbu.terekhow;

import ru.spbu.terekhow.exceptions.EmptyQueue;

/**
 * Реализует очередь с приоритетами на списках.
 * @param <ValueType>
 *     Тип элементов.
 */
public class PriorityQueueByPointers<ValueType> implements PriorytyQueue<ValueType> {
    private class Item {
        public ValueType value;
        public int priority;
        public Item next;

        public Item(ValueType value, int priority, Item next) {
            this.value = value;
            this.next = next;
            this.priority = priority;
        }
    }

    private Item head = new Item(null, 0, null);

    public void enqueue(ValueType value, int priority) {
        Item current = head;
        while (current.next != null && priority <= current.next.priority) {
            current = current.next;
        }
        Item newItem = new Item(value, priority, current.next);
        current.next = newItem;
    }

    public ValueType dequeue() throws EmptyQueue {
        if (head.next == null) {
            throw new EmptyQueue("Try to delete from empty queue");
        }
        ValueType res = head.next.value;
        head.next = head.next.next;
        return res;
    }

    /**
     * Красивенько преобразует очередь с приоритетами в строку.
     * @return
     */
    @Override
    public String toString() {
        String str = "";
        Item current = head.next;
        while (current != null) {
            str += "(" + current.priority + ", " + current.value + ") ";
            current = current.next;
        }
        return str;
    }
}
