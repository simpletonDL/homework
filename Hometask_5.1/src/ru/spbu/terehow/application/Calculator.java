package ru.spbu.terehow.application;

public class Calculator {
    public static String calculate(String operation, int firstOperand, int secondOperand) {
        String result = "";
        switch (operation) {
            case "+":
                result = Integer.toString(firstOperand + secondOperand);
                break;
            case "-":
                result = Integer.toString(firstOperand - secondOperand);
                break;
            case "*":
                result = Integer.toString(firstOperand * secondOperand);
                break;
            case "//":
                result = secondOperand != 0 ? Integer.toString(firstOperand / secondOperand) : "NaN";
                break;
        }
        return result;
    }
}
