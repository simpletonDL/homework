package ru.spbu.terekhow.operators;

/**
 * Operator of subtraction.
 */
public class SubOperator extends Operator {
    @Override
    public int solve() {
        return leftOperand.solve() - rightOperand.solve();
    }

    @Override
    public String toString() {
        return buildStringOperator("-");
    }
}
