package sample.application;

public class Calculator {
    public static String calculate(String operation, int firstOperand, int secondOperand) throws DivisionByZeroException {
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
            case "/":
                if (secondOperand == 0) {
                    throw new DivisionByZeroException();
                }
                result = Integer.toString(firstOperand / secondOperand);
                break;
        }
        return result;
    }
}
