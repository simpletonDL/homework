package com.company;

public class StackByArray implements Stack {

    private int top;
    private int size;
    private String array[];


    public StackByArray(int size)
    {
        this.size = size;
        array = new String[size];
        top = -1;
    }

    @Override
    public void push(String value) {
        if (isFull()) {
            System.out.println("Out of the range");
        }
        else {
            top++;
            array[top] = value;
        }
    }

    @Override
    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return "";
        }
        else {
            return array[top--];
        }
    }

    @Override
    public void show() {
        for (int i = 0; i <= top; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    @Override
    public String top() {
        if (top != -1) {
            return array[top];
        } else {
            System.out.println("Stack is empty");
            return "";
        }
    }

    @Override
    public int getSize() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    @Override
    public boolean isFull() {
        return (top == size-1);
    }
}
