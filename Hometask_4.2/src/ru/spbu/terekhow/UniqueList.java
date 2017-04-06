package ru.spbu.terekhow;

import ru.spbu.terekhow.exceptions.*;

public class UniqueList<T> extends SingleLinkedList<T> implements List<T> {

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
        ptr1.next = new Item(value, ptr2);
        size++;
    }
}
