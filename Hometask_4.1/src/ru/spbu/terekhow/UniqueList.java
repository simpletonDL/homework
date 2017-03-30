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

    /**
     * Insert <b>value</b> before item located in the position of <b>index</b>.
     * If value has already been in the list, the item does not be inserted.
     * @throws OutOfTheRange
     * It is thrown if user try to insert out of the list.
     * @throws UnnecessaryAction
     * It is thrown if user try to insert already existed element.
     */
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

    /**
     * Insert the <b>value</b> in the end of the list.
     * @throws ListException
     * The same as {@link ru.spbu.terekhow.UniqueList#insert(int, Object)},
     * but the exception {@link ru.spbu.terekhow.exceptions.OutOfTheRange} haven`t to happen.
     */
    @Override
    public void pushBack(T value) throws ListException {
        insert(size, value);
    }

    /**
     * Insert the <b>value</b> in the beginning of the list.
     * @throws ListException
     * The same as {@link ru.spbu.terekhow.UniqueList#insert(int, Object)},
     * but the exception {@link ru.spbu.terekhow.exceptions.OutOfTheRange} haven`t to happen.
     */
    @Override
    public void pushFront(T value) throws ListException {
        insert(0, value);
    }

    /**
     * Delete the element from the position of <b>index</b>.
     * @throws OutOfTheRange
     * It is thrown when user try to delete item from empty list.
     */
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

    /**
     * @return
     * If value have been found, method return it`s index. In other case return -1.
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
     * @throws OutOfTheRange
     * It is thrown when user try to get element from position out of the list.
     */
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
