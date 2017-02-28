package com.company;

public class List {

    private Item head;
    private Item tail;
    private Item ptr1;
    private Item ptr2;
    private int size;

    public List() {
        head = new Item();
        tail = new Item();
        head.next = tail;
        size = 0;
    }

    public void insert(int index, int value) {
        if (index <= size) {
            ptr1 = head;
            ptr2 = head.next;
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
        for (ptr1 = head.next; ptr1 != tail; ptr1 = ptr1.next) {
            System.out.print(ptr1.value + " ");
        }
        System.out.println();
    }

    public int locale(int value) {
        int i = 0;
        for (ptr1 = head.next; ptr1 != tail; ptr1 = ptr1.next) {
            if (ptr1.value == value) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int retrieve(int index) {
        if (index < size) {
            ptr1 = head.next;
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

class Item {
    int value;
    Item next;
}