package ru.spbu.terekhow.tree;

/**
 * Expression, which can be thrown in the case, when arithmetic expression is incorrect.
 */
public class NotCorrectArithmeticExpressionException extends Exception {
    public NotCorrectArithmeticExpressionException() {}

    public NotCorrectArithmeticExpressionException(String s) {
        super(s);
    }
}
