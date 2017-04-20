package ru.spbu.terekhow.operators;

/**
 * This abstract class represents an operator.
 */
public abstract class Operator {
    /**
     * Left operand. Notice, it is also operator. There is {@link ru.spbu.terekhow.operators.NumberOperator},
     * which exactly represented operand.
     */
    protected Operator leftOperand;
    /**
     * Right operand, the same as left operand.
     */
    protected Operator rightOperand;

    public Operator() {}

    /**
     * Set left and right operand.
     */
    public void setOperands(Operator leftOperand,Operator rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    /**
     * Calculate value of operator.
     */
    abstract public int solve();

    /**
     * Convert operator to string.
     */
    abstract public String toString();

    /**
     * Auxiliary function for operator conversion to string.
     */
    protected String buildStringOperator(String operator) {
        return "(" + leftOperand + " " + operator + " " + rightOperand + ")";
    }
}
