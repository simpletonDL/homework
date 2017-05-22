package ru.spbu.terekhow.exceptions;

import ru.spbu.terekhow.list.UniqueList;

/**
 * Exception that can be thrown when some action is
 * unnecessary. For instance you can see how it works
 * in the method {@link UniqueList#insert(int, Object)}.
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
