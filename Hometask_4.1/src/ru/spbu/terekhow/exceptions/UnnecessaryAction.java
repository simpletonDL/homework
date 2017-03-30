package ru.spbu.terekhow.exceptions;

public class UnnecessaryAction extends ListException {
    public UnnecessaryAction(){}
    public UnnecessaryAction(String msg) {
        super(msg);
    }
}
