package ru.spbu.terehow.application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class that controls changing and update answer.
 */
public class CalculatorController implements Initializable {
    @FXML
    private TextField output;
    @FXML
    private Spinner<Integer> firstOperand;
    @FXML
    private Spinner<Integer> secondOperand;
    @FXML
    private ComboBox operations;

    /**
     * Set origin options, add listeners.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        firstOperand.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
                Integer.MIN_VALUE, Integer.MAX_VALUE));
        secondOperand.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(
                Integer.MIN_VALUE, Integer.MAX_VALUE));

        operations.getItems().addAll("+", "-", "*", "//");

        firstOperand.getValueFactory().setValue(0);
        secondOperand.getValueFactory().setValue(0);
        operations.getSelectionModel().select(0);

        ChangeListener<Integer> listener = new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                System.out.println(newValue);
            }
        };

        firstOperand.valueProperty().addListener((observable, oldValue, newValue) -> calculate());
        secondOperand.valueProperty().addListener((observable, oldValue, newValue) -> calculate());
        operations.valueProperty().addListener((observable, oldValue, newValue) -> calculate());
        calculate();
    }

    /**
     * This function gets current value of spinners and type of operation
     * and updates answer.
     */
    private void calculate() {
        String targetOperation = (String) operations.getSelectionModel().getSelectedItem();
        int targetFirstOperand = firstOperand.getValue();
        int targetSecondOperand = secondOperand.getValue();
        String result = Calculator.calculate(targetOperation, targetFirstOperand, targetSecondOperand);
        output.setText(result);
    }
}