package ru.spbu.terekhow;

import ru.spbu.terekhow.exceptions.ListException;
import ru.spbu.terekhow.exceptions.OutOfTheRange;
import ru.spbu.terekhow.exceptions.UnnecessaryAction;

public class UniqueList<T> implements List<T> {
    private class Item {
        public T value;
        public Item next;

        public Item(T value, Item next) {
            this.value = value;
            this.next = next;
        }
    }

    private Item head = new Item(null, null);
    private int size = 0;

    @Override
    public void insert(int index, T value) throws OutOfTheRange, UnnecessaryAction {
        if (index > size)
            throw new OutOfTheRange("Index is more than size");
        if (getIndexOfElement(value) != -1)
            throw new UnnecessaryAction("The element is already exist");

        Item ptr1 = head;
        for (int i = 0; i < index; i++) {
            ptr1 = ptr1.next;
        }
        Item ptr2 = ptr1.next;
        Item newItem = new Item(value, ptr2);
        ptr1.next = newItem;
        size++;
    }

    @Override
    public void pushBack(T value) throws ListException {
        insert(size, value);
    }

    @Override
    public void pushFront(T value) throws ListException {
        insert(0, value);
    }

    @Override
    public void delete(int index) throws OutOfTheRange {
        if (index >= size)
            throw new OutOfTheRange("Try to delete nonexistent element");

        Item current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.next = current.next.next;
        size--;
    }

    @Override
    public int getIndexOfElement(T value) {
        int i = 0;
        for (Item current = head.next; current != null; current = current.next) {
            if (current.value.equals(value)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public T getElementFromIndex(int index) throws OutOfTheRange {
        if (index >= size)
            throw new OutOfTheRange("Try to get out index");
        Item current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public void showInConsole() {
        for (Item current = head.next; current != null; current = current.next) {
            System.out.print(current.value + " ");
        }
        System.out.println();
    }

    @Override
    public int getSize() {
        return size;
    }
}
