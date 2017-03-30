package ru.spbu.terekhow.exceptions;

/**
 * Class for exception, that can be thrown in the methods
 * of interface {@link ru.spbu.terekhow.List}. If you want
 * to create new exception to use in your own classes implements
 * List you will need to inherit you exception from this class,
 * because List`s methods throw`s exactly ListException.
 */
public class ListException extends Exception {
    /**
     * Empty constructor
     */
    public ListException(){}

    /**
     * Create ListException and set message <b>msg</b>.
     */
    public ListException(String msg) {
        super(msg);
    }
}
