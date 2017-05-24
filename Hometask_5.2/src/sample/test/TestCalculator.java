package sample.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import org.junit.*;
import sample.application.Main;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * It is testing class for calculator.
 */
public class TestCalculator extends Application {
    private Stage targetStage;

    private ArrayList<Button> digitList;
    private ArrayList<Button> operationList;

    private TextField textField;
    private TextArea textEventLog;
    private Button btnClear;
    private Button btnSolve;

    /**
     * This test launch and simulate behavior of a bit "bad" user.
     */
    @Test
    public void launchAndTestApplication() {
        launch(TestCalculator.class);
    }

    /**
     * Initialize application, get necessary nodes, called testOperation.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        targetStage = primaryStage;
        Parent root = FXMLLoader.load(Main.class.getResource("sample.fxml"));
        primaryStage.setTitle("123");
        primaryStage.setScene(new Scene(root));

        digitList = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            digitList.add((Button) primaryStage.getScene().lookup("#d" + Integer.toString(i)));
        }
        operationList = new ArrayList<>();
        operationList.add(findItem("#btnAdd"));
        operationList.add(findItem("#btnSub"));
        operationList.add(findItem("#btnMul"));
        operationList.add(findItem("#btnDiv"));

        btnClear = findItem("#btnClear");
        btnSolve = findItem("#btnSolve");

        textField = findItem("#textField");
        textEventLog = findItem("#textEventLog");

        primaryStage.show();
        testOperations();
        primaryStage.close();
    }

    /**
     * Help-function to get node in the fxml.
     * @param selector
     * fx:id of node
     * @return
     * return node with fx:id selector.
     */
    private <Type> Type findItem(String selector) {
        return (Type) targetStage.getScene().lookup(selector);
    }

    /**
     * Simulate behavior of user and compare actual and expected answer.
     */
    private void testOperations() {
        enterNumber("123");
        pushOperationBtn("+");
        enterNumber("254");
        btnSolve.fire();
        assertEquals("377", getResult());

        pushOperationBtn("/");
        pushOperationBtn("-");
        enterNumber("77");
        pushOperationBtn("*");
        assertEquals("300*", getResult());

        pushOperationBtn("-");
        assertEquals("300-", getResult());

        pushOperationBtn("/");
        enterNumber("10");
        btnSolve.fire();
        assertEquals("30", getResult());

        pushOperationBtn("*");
        btnSolve.fire();
        enterNumber("12");
        btnSolve.fire();
        assertEquals("360", getResult());

        btnClear.fire();
        assertEquals("0", getResult());

        enterNumber("000001");
        assertEquals("1", getResult());

        btnClear.fire();
        pushOperationBtn("+");
        assertEquals("0+", getResult());

        enterNumber("1111111111111111111111111111111111111");
        btnSolve.fire();
        assertEquals("You have entered too huge number", textEventLog.getText());
        assertEquals("0", getResult());

        pushOperationBtn("/");
        enterNumber("0");
        btnSolve.fire();
        assertEquals("I don`t know who you are, \n but white man would`nt divide by zero", textEventLog.getText());
    }

    /**
     * Return current text in result textField.
     */
    private String getResult() {
        return textField.getText();
    }

    /**
     * Push button of operation
     */
    private void pushOperationBtn(String operation) {
        switch (operation) {
            case "+":
                operationList.get(0).fire();
                break;
            case "-":
                operationList.get(1).fire();
                break;
            case "*":
                operationList.get(2).fire();
                break;
            case "/":
                operationList.get(3).fire();
                break;
        }
    }

    /**
     * Enter number.
     */
    private void enterNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            digitList.get(s.charAt(i) - '0').fire();
        }
    }
}