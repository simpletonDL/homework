package com.company;

public class Stack {

    private int maxSize;
    private int[] stackArray;
    private int top = -1;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new int[maxSize];
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack is full");
        } else {
            top++;
            stackArray[top] = item;
        }
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            top--;
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize-1);
    }

    public int top() {
        return top;
    }

    public void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

    public void showMaxSize() {
        System.out.println(maxSize);
    }
}
