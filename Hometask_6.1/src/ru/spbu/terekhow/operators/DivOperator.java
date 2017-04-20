package ru.spbu.terekhow.operators;

/**
 * Operator of division.
 */
public class DivOperator extends Operator {
    @Override
    public int solve() {
        return leftOperand.solve() / rightOperand.solve();
    }

    @Override
    public String toString() {
        return buildStringOperator("/");
    }
}
