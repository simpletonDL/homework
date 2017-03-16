package com.company;

public class DoubleLinkedList implements List {
    private class Item {
        public String value;
        public Item next, previous;

        public Item(String value, Item next, Item previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Item() {}
    }

    private Item head = new Item();
    private Item tail = new Item();
    private int size = 0;

    public DoubleLinkedList() {
        head.next = tail;
        tail.previous = head;
    }

    @Override
    public void insert(int index, String value) {
        if (index <= size) {
            Item current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Item newItem = new Item(value, current.next, current);
            current.next = newItem;
            newItem.next.previous = newItem;
            size++;
        } else {
            System.out.println("Out of the range");
        }
    }

    @Override
    public void pushBack(String value) {
        insert(size, value);
    }

    @Override
    public void pushFront(String value) {
        insert(0, value);
    }

    @Override
    public void delete(int index) {
        if (index < size) {
            Item current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }

            current.next = current.next.next;
            current.next.previous = current;
            size--;
        } else {
            System.out.println("List is empty");
        }
    }

    @Override
    public int getIndexOfElement(String value) {
        int i = 0;
        for (Item current = head.next; current != tail; current = current.next) {
            if (current.value.equals(value)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public String retrieve(int index) {
        if (index < size) {
            Item ptr1 = head.next;
            for (int i = 0; i < index; i++) {
                ptr1 = ptr1.next;
            }
            return ptr1.value;
        } else {
            System.out.println("Out of the range");
            return "";
        }
    }

    @Override
    public void showInConsole() {
        for (Item current = head.next; current != tail; current = current.next) {
            System.out.print(current.value + " ");
        }
        System.out.println();
    }

    @Override
    public int getSize() {
        return size;
    }

    public void showInConsoleInReverseOrder() {
        for (Item current = tail.previous; current != head; current = current.previous)
            System.out.print(current.value + " ");
        System.out.println();
    }
}
