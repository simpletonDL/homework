package com.company;

public class StackCalculator {

    private Stack stack = new StackByPointers();
    private int first;
    private int second;

    public void push(String value) {
        stack.push(value);
    }

    public String top() {
        return stack.top();
    }

    public void add() {
        popTwoItem();
        stack.push( Integer.toString(first + second) );
    }

    public void sub() {
        popTwoItem();
        stack.push( Integer.toString(first - second) );
    }

    public void mul() {
        popTwoItem();
        stack.push( Integer.toString(first * second) );
    }

    public void div() {
        popTwoItem();
        stack.push( Integer.toString(first / second) );
    }

    private void popTwoItem() {
        second = Integer.parseInt(stack.pop());
        first = Integer.parseInt(stack.pop());
    }
}
