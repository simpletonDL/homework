package ru.spbu.terekhow.operators;

/**
 * Operator of addition.
 */
public class AddOperator extends Operator {
    @Override
    public int solve() {
        return leftOperand.solve() + rightOperand.solve();
    }

    @Override
    public String toString() {
        return buildStringOperator("+");
    }
}
