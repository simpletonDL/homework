package ru.spbu.terekhow;

public class LinkedList<T> implements List<T> {
    private static class Item<U> {
        public U value;
        public Item<U> next;

        public Item(U value, Item next) {
            this.value = value;
            this.next = next;
        }
    }

    private Item<T> head = new Item(null, null);
    private int size = 0;

    @Override
    public void insert(int index, T value) {

    }

    @Override
    public void pushBack(T value) {

    }

    @Override
    public void pushFront(T value) {

    }

    @Override
    public void delete(int index) {

    }

    @Override
    public int getIndexOfElement(T value) {
        return 0;
    }

    @Override
    public T retrieve(int index) {
        return null;
    }

    @Override
    public void showInConsole() {

    }

    @Override
    public int getSize() {
        return 0;
    }
}
