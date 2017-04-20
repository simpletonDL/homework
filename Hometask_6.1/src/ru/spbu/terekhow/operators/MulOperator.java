package ru.spbu.terekhow.operators;

/**
 * Operator of multiplication.
 */
public class MulOperator extends Operator {
    @Override
    public int solve() {
        return leftOperand.solve() * rightOperand.solve();
    }

    @Override
    public String toString() {
        return buildStringOperator("*");
    }
}
