package com.company;

public class SingleLinkedList implements List {
    private class Item {
        public String value;
        public Item next;

        public Item(String value, Item next) {
            this.value = value;
            this.next = next;
        }
    }

    private Item head = new Item("", null);
    private int size = 0;

    @Override
    public void insert(int index, String value) {
        if (index <= size) {
            Item ptr1 = head;

            for (int i = 0; i < index; i++) {
                ptr1 = ptr1.next;
            }
            Item ptr2 = ptr1.next;

            Item newItem = new Item(value, ptr2);
            ptr1.next = newItem;
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
            size--;
        } else {
            System.out.println("List is empty");
        }
    }

    @Override
    public void showInConsole() {
        for (Item current = head.next; current != null; current = current.next) {
            System.out.print(current.value + " ");
        }
        System.out.println();
    }

    @Override
    public int getIndexOfElement(String value) {
        int i = 0;
        for (Item ptr1 = head.next; ptr1 != null; ptr1 = ptr1.next) {
            if (ptr1.value.equals(value)) {
                return i;
            }
            i++;
        }
        System.out.println("Value haven`t founded");
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
    public int getSize() {
        return size;
    }
}