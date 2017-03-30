package ru.spbu.terekhow.exceptions;

/**
 * Exception that can be thrown when some action is
 * unnecessary. For instance you can see how it works
 * in the method {@link ru.spbu.terekhow.UniqueList#insert(int, Object)}.
 */
public class UnnecessaryAction extends ListException {
    /**
     * Empty constructor
     */
    public UnnecessaryAction(){}

    /**
     * Create UnnecessaryAction and set message <b>msg</b>.
     */
    public UnnecessaryAction(String msg) {
        super(msg);
    }
}
