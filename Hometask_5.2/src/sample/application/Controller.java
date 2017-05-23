package sample.application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * This class control application in runtime.
 */
public class Controller implements Initializable{
    @FXML
    ArrayList<Button> digitList;
    @FXML
    ArrayList<Button> operationList;

    @FXML
    TextField textField;
    @FXML
    TextArea textEventLog;

    String targetOperation = "";
    String leftOperand = "0";
    String rightOperand = "0";

    /**
     * It is enum of state.
     * readingFirstOperand - state, when user has already been entering first operand;
     * operationHasRead - state, when user has already entered operation;
     * readingSecondOperand - state, when user has already been entering second operad.
     */
    private enum State {
        readingFirstOperand, readingSecondOperand, operationHasRead
    }

    private State targetState = State.readingFirstOperand;

    /**
     * It add listeners to operation and digit buttons, update result field.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateTextField();

        for (Button btn : digitList) {
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    sendMessage(-1);
                    readDigit(btn.getText());
                    updateTextField();
                }
            });
        }

        for (Button btn : operationList) {
            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    sendMessage(-1);
                    readOperation(btn.getText());
                    updateTextField();
                }
            });
        }
        Button btn = digitList.get(0);
    }

    /**
     * It is called when user push operation button.
     */
    private void readOperation(String operation) {
        switch (targetState) {
            case readingFirstOperand:
                targetState = State.operationHasRead;
                targetOperation = operation;
                break;
            case operationHasRead:
                targetOperation = operation;
                break;
            case readingSecondOperand:
                try {
                    calculate();
                    targetOperation = operation;
                    targetState = State.operationHasRead;
                } catch (NumberFormatException e) {
                    clear();
                    sendMessage(0);
                } catch (DivisionByZeroException e) {
                    clear();
                    sendMessage(1);
                }
        }
    }

    /**
     * It is called when user push digit button.
     */
    private void readDigit(String digit) {
        switch (targetState) {
            case readingFirstOperand:
                if (leftOperand.equals("0")) {
                    leftOperand = digit;
                } else {
                    leftOperand += digit;
                }
                break;
            case operationHasRead:
                targetState = State.readingSecondOperand;
            case readingSecondOperand:
                if (rightOperand.equals("0")) {
                    rightOperand = digit;
                } else {
                    rightOperand += digit;
                }
                break;
        }
    }

    /**
     * This function solve introduced expression.
     * @throws NumberFormatException
     *  Called when user enter too huge number.
     * @throws DivisionByZeroException
     *  I think it`s clear.
     */
    private void calculate() throws NumberFormatException, DivisionByZeroException {
        int leftIntOperand = Integer.parseInt(leftOperand);
        int rightIntOperand = Integer.parseInt(rightOperand);
        int result = 0;

        switch (targetOperation) {
            case "+":
                result = leftIntOperand + rightIntOperand;
                break;
            case "-":
                result = leftIntOperand - rightIntOperand;
                break;
            case "*":
                result = leftIntOperand * rightIntOperand;
                break;
            case "/":
                if (rightIntOperand == 0) {
                    throw new DivisionByZeroException();
                }
                result = leftIntOperand / rightIntOperand;
                break;
        }

        leftOperand = Integer.toString(result);
        rightOperand = "0";
    }

    /**
     * This function update text of current input on text field.
     */
    private void updateTextField() {
        String s = "";
        switch (targetState) {
            case readingFirstOperand:
                s = leftOperand;
                break;
            case operationHasRead:
                s = leftOperand + targetOperation;
                break;
            case readingSecondOperand:
                s = leftOperand + targetOperation + rightOperand;
                break;
        }
        textField.setText(s);
    }

    /**
     * Called when user push clear-button.
     */
    public void bntClearAction(ActionEvent actionEvent) {
        sendMessage(-1);
        clear();
    }

    /**
     * Return calculator to the original state.
     */
    private void clear() {
        targetState = State.readingFirstOperand;
        leftOperand = "0";
        rightOperand = "0";
        targetOperation = "";
        updateTextField();
    }

    /**
     * Called when user push equality button.
     */
    public void solve(ActionEvent actionEvent) {
        sendMessage(-1);
        switch (targetState) {
            case readingFirstOperand:
                sendMessage(2);
                break;
            case operationHasRead:
                sendMessage(3);
                break;
            case readingSecondOperand:
                try {
                    calculate();
                    targetOperation = "";
                    targetState = State.readingFirstOperand;
                } catch (NumberFormatException e) {
                    clear();
                    sendMessage(0);
                }
                catch (DivisionByZeroException e) {
                    clear();
                    sendMessage(1);
                }
                break;
        }
        updateTextField();
    }

    /**
     * Print message in the event log.
     * @param state
     *  Index of message.
     */
    private void sendMessage(int state) {
        String text = "";
        switch (state) {
            case -1:
                text = "";
                break;
            case 0:
                text = "You have entered too huge number";
                break;
            case 1:
                text = "I don`t know who you are, \n but white man would`nt divide by zero";
                break;
            case 2:
                text = "It isn`n a expression, \n you have entered only one number";
                break;
            case 3:
                text = "Missing second operand";
        }
        textEventLog.setText(text);
    }
}
