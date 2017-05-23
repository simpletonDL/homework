package sample.application;

/**
 * It is class of exception. In can be thrown when
 * something try to divide by zero.
 */
public class DivisionByZeroException extends Exception {
    public DivisionByZeroException() {};
    public DivisionByZeroException(String msg) {
        super(msg);
    }
}
