package ru.spbu.terekhow.operators;

/**
 * Operator which represented operand, i.e. number.
 */
public class NumberOperator extends  Operator {
    private int value;

    public NumberOperator(int value) {
        this.value = value;
    }

    @Override
    public int solve() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
