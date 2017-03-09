package com.company;

import com.sun.deploy.panel.ITreeNode;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

/**
 * Created by Арсений Терехов on 09.03.2017.
 */
public class StackCalculator extends StackByPointers {

    private int first;
    private int second;

    public void add() {
        popTwoItem();
        this.push( Integer.toString(first + second) );
    }

    public void sub() {
        popTwoItem();
        this.push( Integer.toString(first - second) );
    }

    public void mul() {
        popTwoItem();
        this.push( Integer.toString(first * second) );
    }

    public void div() {
        popTwoItem();
        this.push( Integer.toString(first / second) );
    }

    private void popTwoItem() {
        second = Integer.parseInt(this.pop());
        first = Integer.parseInt(this.pop());
    }
}
