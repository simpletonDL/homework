package com.company;

public class StackByPointers implements Stack {

    private class Item {
        public String value;
        public Item previous;

        public Item(String value, Item previous) {
            this.value = value;
            this.previous = previous;
        }
    }

    private Item bottom = new Item("", null);
    private Item top = bottom;
    private int size = 0;

    @Override
    public void push(String value) {
        Item newItem = new Item(value, top);
        top = newItem;
        size++;
    }

    @Override
    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return "";
        }
        String s = top.value;
        top = top.previous;
        return s;
    }

    @Override
    public void showInConsole() {
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
