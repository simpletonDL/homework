package com.company;

public class MathCalculations {

    private String[] orderOperator = {"+", "-", "*", "/"};

    public int calculute(String expression) {
        String[] parsingArray = expression.split(" "); // Если нужно, могу сделать более нормальный парсинг
        Stack stack = new StackByPointers();
        List postfix = new SingleLinkedList();
        for (int i = 0; i < parsingArray.length; i++) {
            String token = parsingArray[i];

            if ( token.equals("(") ) {
                stack.push("(");
            } else if ( token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") ) {
                while (!stack.isEmpty() && !stack.top().equals("(") && compareOperator(token, stack.top())) {
                    postfix.pushBack(stack.top());
                    stack.pop();
                }
                stack.push(token);
            } else if (token.equals(")")) {
                while ( !stack.top().equals("(") ) {
                    postfix.pushBack(stack.top());
                    stack.pop();
                }
                stack.pop();
            } else {
                postfix.pushBack(token);
            }
        }
        while (!stack.isEmpty()) {
            postfix.pushBack(stack.top());
            stack.pop();
        }
        StackCalculator stackCalculator = new StackCalculator();
        for (int i = 0; i < postfix.getSize(); i++) {
            String token = postfix.retrieve(i);

            if ( indexInArray(orderOperator, token) == -1 ) {
                stackCalculator.push(token);
            } else {
                switch (token) {
                    case "+": stackCalculator.add();
                        break;
                    case "-": stackCalculator.sub();
                        break;
                    case "*": stackCalculator.mul();
                        break;
                    case "/": stackCalculator.div();
                        break;
                    default: System.out.println("It is feature, but no bug");
                }
            }
        }
        return Integer.parseInt(stackCalculator.top());
    }

    private boolean compareOperator(String operator1, String operator2) {
        return (indexInArray(orderOperator, operator1) <= indexInArray(orderOperator, operator2));
    }

    private int indexInArray(String[] array, String toFind) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(toFind)) {
                return i;
            }
        }
        return -1;
    }
}
