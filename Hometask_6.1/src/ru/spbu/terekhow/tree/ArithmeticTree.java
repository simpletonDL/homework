package ru.spbu.terekhow.tree;

import ru.spbu.terekhow.operators.*;

import java.util.Scanner;

/**
 * This class implement parse tree of arithmetic expression.
 */
public class ArithmeticTree {
    private Scanner in;
    private Operator root = null;

    /**
     * Default constructor
     */
    public ArithmeticTree() {}

    /**
     * This is constructor that builds tree from expression.
     * @param expression
     * String expression, consist of addition, subtraction, multiplication and division sign, numbers and brackets.
     * Notice, that all tokens must be separated by space!
     * @throws NotCorrectArithmeticExpressionException
     * This expression thrown in the case, if expression isn`t correct. For instance if sequence of brackets is
     * incorrect, or number isn`t number.
     */
    public ArithmeticTree(String expression) throws NotCorrectArithmeticExpressionException {
        buildTree(expression);
    }

    /**
     * This method rebuild you tree from new expression, the same as
     * {@link ru.spbu.terekhow.tree.ArithmeticTree#ArithmeticTree(String)}.
     */
    public void buildTree(String expression) throws NotCorrectArithmeticExpressionException {
        in = new Scanner(expression);
        try {
            root = inputNewOperator();
        } catch (NotCorrectArithmeticExpressionException e) {
            root = null;
            throw new NotCorrectArithmeticExpressionException("Not correct arithmetic expression: " + e.getMessage());
        }
        if (in.hasNext()) {
            root = null;
            throw new NotCorrectArithmeticExpressionException("Not correct arithmetic expression: Extra part of sequence");
        }
    }

    /**
     * This method evaluates expression
     * @return
     * Result of expression.
     */
    public int solve() {
        try {
            return root.solve();
        } catch (NullPointerException e) {
            System.out.println("Arithmetic tree is empty");
            return 0;
        }
    }

    private Operator inputNewOperator() throws NotCorrectArithmeticExpressionException {
        if (in.hasNext() == false)
            throw new NotCorrectArithmeticExpressionException("Expected operator or operand");

        String target = in.next();
        Operator newOperator = null;

        if (target.equals("(")) {
            if (in.hasNext() == false)
                throw new NotCorrectArithmeticExpressionException("Not correct brackets sequence");

            target = in.next();
            switch (target) {
                case "+":
                    newOperator = new AddOperator();
                    break;
                case "*":
                    newOperator = new MulOperator();
                    break;
                case "-":
                    newOperator = new SubOperator();
                    break;
                case "/":
                    newOperator = new DivOperator();
                    break;
                default:
                    throw new NotCorrectArithmeticExpressionException("Not correct operator");
            }
            newOperator.setOperands(inputNewOperator(), inputNewOperator());

            if (in.hasNext() == false)
                throw new NotCorrectArithmeticExpressionException("Not correct brackets sequence");
            target = in.next();
            if (!target.equals(")"))
                throw new NotCorrectArithmeticExpressionException("Expected \")\"");

            return newOperator;
        } else {
            try {
                newOperator = new NumberOperator(Integer.parseInt(target));
            } catch (NumberFormatException e) {
                throw new NotCorrectArithmeticExpressionException("Expected number");
            }
            return newOperator;
        }
    }

    /**
     * Convert tree into string. For example, for tree with expression "( * ( + 1 2 ) ( + 2 3 ) )"
     * string will be "(1 + 2) * (2 + 3)"
     * @return
     */
    public String toString() {
        return root.toString();
    }
}