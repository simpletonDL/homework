package com.company;

public class List {

    private class Item {
        int value;
        Item next;
    }

    private Item head;
    private int size;

    public List() {
        head = new Item();
        size = 0;
    }

    public void insert(int index, int value) {
        if (index <= size) {
            Item ptr1 = head;
            Item ptr2 = head.next;

            for (int i = 0; i < index; i++) {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }

            Item newItem = new Item();
            newItem.value = value;
            ptr1.next = newItem;
            newItem.next = ptr2;
            size++;
        } else {
            System.out.println("Out of the range");
        }
    }

    public void delete(int index) {
        if (index < size) {
            Item ptr1;
            ptr1 = head;

            for (int i = 0; i < index; i++) {
                ptr1 = ptr1.next;
            }

            ptr1.next = ptr1.next.next;
            size--;
        } else {
            System.out.println("List is empty");
        }
    }

    public void show() {
        for (Item ptr1 = head.next; ptr1 != null; ptr1 = ptr1.next) {
            System.out.print(ptr1.value + " ");
        }
        System.out.println();
    }

    public int locale(int value) {
        int i = 0;
        for (Item ptr1 = head.next; ptr1 != null; ptr1 = ptr1.next) {
            if (ptr1.value == value) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int retrieve(int index) {
        if (index < size) {
            Item ptr1 = head.next;
            for (int i = 0; i < index; i++) {
                ptr1 = ptr1.next;
            }
            return ptr1.value;
        } else {
            return -1;
        }
    }

    public int getSize() {
        return size;
    }
}