package com.company;

public class StackByPointers implements Stack {

    private class Item {
        String value;
        Item previous;
    }

    private Item bottom;
    private Item top;
    private int size;

    public StackByPointers() {
        bottom = new Item();
        top = bottom;
    }

    @Override
    public void push(String value) {
        Item newItem = new Item();
        newItem.value = value;
        newItem.previous = top;
        top = newItem;
        size++;
    }

    @Override
    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return "";
        } else {
            String s = top.value;
            top = top.previous;
            return s;
        }
    }

    @Override
    public void show() {
        Item ptr = top;
        recursionShow(ptr);
        System.out.println();
    }

    private void recursionShow(Item ptr) {
        if (ptr != bottom) {
            recursionShow(ptr.previous);
            System.out.print(ptr.value + " ");
        }
    }

    @Override
    public String top() {
        if (!isEmpty()) {
            return top.value;
        } else {
            System.out.println("Stack is empty");
            return "";
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (top == bottom);
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
