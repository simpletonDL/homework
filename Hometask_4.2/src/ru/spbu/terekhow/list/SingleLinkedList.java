package ru.spbu.terekhow.list;

import ru.spbu.terekhow.exceptions.*;

public class SingleLinkedList<T> implements List<T> {
    protected class Item {
        public T value;
        public Item next;

        public Item(T value, Item next) {
            this.value = value;
            this.next = next;
        }
    }

    protected Item head = new Item(null, null);
    protected int size = 0;

    @Override
    public void insert(int index, T value) throws ListException {
        if (index > size || index < 0)
            throw new OutOfTheRange("Index is more than size or less than 0");

        Item ptr1 = head;
        for (int i = 0; i < index; i++) {
            ptr1 = ptr1.next;
        }
        Item ptr2 = ptr1.next;
        ptr1.next = new Item(value, ptr2);
        size++;
    }

    /**
     * Insert the <b>value</b> in the end of the list.
     *
     * @throws ListException The same as {@link SingleLinkedList#insert(int, Object)},
     * but the exception {@link ru.spbu.terekhow.exceptions.OutOfTheRange} haven`t to happen.
     */
    @Override
    public void pushBack(T value) throws ListException {
        insert(size, value);
    }

    /**
     * Insert the <b>value</b> in the beginning of the list.
     *
     * @throws ListException The same as {@link SingleLinkedList#insert(int, Object)},
     * but the exception {@link ru.spbu.terekhow.exceptions.OutOfTheRange} haven`t to happen.
     */
    @Override
    public void pushFront(T value) throws ListException {
        insert(0, value);
    }

    /**
     * Delete the element from the position of <b>index</b>.
     *
     * @throws OutOfTheRange It is thrown when user try to delete item from empty list.
     */
    @Override
    public void delete(int index) throws OutOfTheRange {
        if (index >= size || index < 0) {
            throw new OutOfTheRange("Try to delete nonexistent element");
        }

        Item current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        current.next = current.next.next;
        size--;
    }

    /**
     * @return If value have been found, method return it`s index. In other case return -1.
     */
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

    /**
     * @throws OutOfTheRange It is thrown when user try to get element from position out of the list.
     */
    @Override
    public T getElementFromIndex(int index) throws OutOfTheRange {
        if (index >= size || index < 0)
            throw new OutOfTheRange("Try to get out index");
        Item current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        List listToCompare = (List) obj;
        if (this.getSize() != listToCompare.getSize()) {
            return false;
        }
        for (int i = 0; i < this.getSize(); i++) {
            try {
                if (this.getElementFromIndex(i) != listToCompare.getElementFromIndex(i)) {
                    return false;
                }
            } catch (ListException e) {
                System.out.println("Something going wrong when try to check equality of SingleLinkedList");
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String s = "";
        for (Item current = head.next; current != null; current = current.next) {
            s += current.value;
            if (current.next != null) {
                s += ", ";
            }
        }
        return s;
    }
}