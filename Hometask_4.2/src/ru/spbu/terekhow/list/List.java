package ru.spbu.terekhow.list;

import ru.spbu.terekhow.exceptions.ListException;

/**
 * Interface for any lists. It can be <b>used to implement</b>
 * classes like <b>linked list, double-linked list</b> and <b>{@link UniqueList}</b>.
 *
 * @param <T>
 * It is a type of items that make up the list.
 */
public interface List<T> {
    /**
     * Insert <b>value</b> before item located in the position of <b>index</b>.
     * @throws ListException
     * It have to be thrown in the case when user try to insert item in the position out of the list.
     * For instance, if user insert item in the position with index strictly more than size of list or
     * strictly less than zero.
     */
    void insert(int index, T value) throws ListException;

    /**
     * Insert <b>value</b> in the end of the list. It can be implemented like <b>insert(size, value)</b>
     */
    void pushBack(T value) throws ListException;

    /**
     * Insert <b>value</b> in the beginning of the list. It can be implemented like <b>insert(0, value)</b>
     */
    void pushFront(T value) throws ListException;

    /**
     * Delete the element from the position of <b>index</b>.
     * @throws ListException
     * It can be thrown if user try to delete item out of the list.
     */
    void delete(int index) throws  ListException;

    /**
     * Try to find <b>value</b> in the list.
     * @return
     * If there is the <b>value</b> in the list, return its index. In other case it have to return -1.
     */
    int getIndexOfElement(T value);

    /**
     * Return value in the position of <b>index</b>.
     * @return
     * Index of the element.
     * @throws ListException
     * It can be thrown if user try to get element out of the range.
     */
    T getElementFromIndex(int index) throws ListException;

    /**
     * Auxiliary method that show in console list from beginning to end.
     * It can be useful to debug.
     */
    void showInConsole();

    /**
     * I think, it is clear :D
     */
    int getSize();
}