package com.company;

public class Lifo {

    private int maxSize;
    private int[] stackArray;
    private int top = -1;

    public Lifo(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new int[maxSize];
    }

    public void Push(int item) {
        if (IsFull()) {
            System.out.println("Lifo is full");
        } else {
            top++;
            stackArray[top] = item;
        }
    }

    public void Pop() {
        if (IsEmpty()) {
            System.out.println("Lifo is empty");
        } else {
            top--;
        }
    }

    public boolean IsEmpty() {
        return (top == -1);
    }

    public boolean IsFull() {
        return (top == maxSize-1);
    }

    public int Top() {
        return top;
    }

    public void Print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

    public void ShowMaxSize() {
        System.out.println(maxSize);
    }
}
