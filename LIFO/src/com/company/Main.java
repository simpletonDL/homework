package com.company;

public class Main {

    public static void main(String[] args)
    {
        Stack stack = new Stack(3);
        stack.showMaxSize(); // 3

        stack.push(2);
        stack.push(1);
        System.out.println(stack.top()); // 1
        stack.push(4);
        stack.push(3); // Stack is full
        System.out.println(stack.isFull()); // true
        stack.print(); // 2 1 4
        stack.pop();
        stack.pop();
        stack.push(0);
        stack.print(); // 2 0
        stack.pop();
        stack.pop();
        System.out.println(stack.isEmpty()); // true
        stack.pop(); // Stack is empty
    }
}
