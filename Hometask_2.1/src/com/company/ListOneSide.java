package com.company;

public class ListOneSide implements List {

    private class Item {
        String value;
        Item next;
    }

    private Item head;
    private int size;

    public ListOneSide() {
        head = new Item();
        size = 0;
    }

    @Override
    public void insert(int index, String value) {
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

    @Override
    public void show() {
        for (Item ptr1 = head.next; ptr1 != null; ptr1 = ptr1.next) {
            System.out.print(ptr1.value + " ");
        }
        System.out.println();
    }

    @Override
    public int locale(String value) {
        int i = 0;
        for (Item ptr1 = head.next; ptr1 != null; ptr1 = ptr1.next) {
            if (ptr1.value == value) {
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