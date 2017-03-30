package ru.spbu.terekhow.exceptions;

/**
 * Exception that can be thrown in the case when something
 * try to get nonexistent subject. For example, it can be thrown
 * when user try to get index out of the size of array.
 */
public class OutOfTheRange extends ListException {
    /**
     * Empty constructor
     */
    public OutOfTheRange(){}

    /**
     * Create OutOfTheRange and set message <b>msg</b>.
     */
    public OutOfTheRange(String msg) {
        super(msg);
    }
}
