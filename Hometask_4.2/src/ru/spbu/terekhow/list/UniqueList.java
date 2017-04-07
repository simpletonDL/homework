package ru.spbu.terekhow.list;

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
    public void insert(int index, T value) throws ListException {
        if (index > size || index < 0)
            throw new OutOfTheRange("Index is more than size");
        if (getIndexOfElement(value) != -1)
            throw new UnnecessaryAction("The element is already exist");

        super.insert(index, value);
    }
}
