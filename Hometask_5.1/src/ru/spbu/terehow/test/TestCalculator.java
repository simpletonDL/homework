package ru.spbu.terehow.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.junit.*;

import static org.junit.Assert.*;
import ru.spbu.terehow.application.*;

/**
 * It is testing class.
 */
public class TestCalculator extends Application {
    private Spinner<Integer> firstOperand;
    private Spinner<Integer> secondOperand;
    private ComboBox operations;
    private TextField result;

    /**
     * Test launch application, change options of nodes
     * and check answer. It will be fail, if assertion error
     * happens in testCalculate.
     */
    @Test
    public void launchAndTestApplication() {
        launch(TestCalculator.class);
    }

    /**
     * It loads calculator.fxml, gets nodes and calls
     * fucntion testCalculate to check.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("calculator.fxml"));
        primaryStage.setTitle("CalculatorTest");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        firstOperand = (Spinner<Integer>) root.lookup("#firstOperand");
        secondOperand = (Spinner<Integer>) root.lookup("#secondOperand");
        operations = (ComboBox) root.lookup("#operations");
        result = (TextField) root.lookup("#output");

        testCalculate();
        primaryStage.close();
    }

    /**
     * This class change option of spinners and combobox
     * and check answer. Everything else it checks, that
     * changing event has happened.
     */
    public void testCalculate() {
        firstOperand.getValueFactory().setValue(101);
        secondOperand.getValueFactory().setValue(114);
        assertEquals("215",result.getText());


        firstOperand.getValueFactory().setValue(12);
        secondOperand.getValueFactory().setValue(-5);
        operations.getSelectionModel().select(1);
        assertEquals("17",result.getText());

        firstOperand.getValueFactory().setValue(4);
        secondOperand.getValueFactory().setValue(5);
        operations.getSelectionModel().select(2);
        assertEquals("20",result.getText());

        firstOperand.getValueFactory().setValue(12);
        secondOperand.getValueFactory().setValue(3);
        operations.getSelectionModel().select(3);
        assertEquals("4",result.getText());

        firstOperand.getValueFactory().setValue(12);
        secondOperand.getValueFactory().setValue(0);
        assertEquals("NaN",result.getText());
    }
}
