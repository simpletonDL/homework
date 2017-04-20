package ru.spbu.terekhow.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArithmeticTreeTest {
    private ArithmeticTree tree = new ArithmeticTree();

    @Test
    public void testSolve() throws NotCorrectArithmeticExpressionException {
        tree.buildTree("( * ( + ( - 3 1 ) 2 ) ( / 4 2 ) )");
        assertEquals(tree.solve(), 8);

        tree.buildTree("( * ( * ( + 2 3 ) ( + 4 6 ) ) ( - ( + 3 5 ) 4 ) )");
        assertEquals(tree.solve(), 200);
    }

    @Test
    public void testToString() throws  NotCorrectArithmeticExpressionException {
        tree.buildTree("( * 1 ( * 2 ( * 3 ( * 4 ( * 5 ( * 6 7 ) ) ) ) ) )");
        assertEquals(tree.toString(), "(1 * (2 * (3 * (4 * (5 * (6 * 7))))))");

        tree.buildTree("( * ( + 2 3 ) ( + 1 4 ) )");
        assertEquals(tree.toString(), "((2 + 3) * (1 + 4))");
    }
}