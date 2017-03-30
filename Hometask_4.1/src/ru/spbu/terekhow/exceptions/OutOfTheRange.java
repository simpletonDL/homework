package ru.spbu.terekhow.exceptions;

public class OutOfTheRange extends ListException {
    public OutOfTheRange(){}
    public OutOfTheRange(String msg) {
        super(msg);
    }
}
