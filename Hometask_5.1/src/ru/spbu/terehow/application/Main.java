package ru.spbu.terehow.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is class, which launch application calculator.
 * There are 4 standard operation. Yuo can change value of
 * operands by dint of spinner and operation through combobox.
 * Answer is updated after you have changed some options.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("calculator.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 430, 60));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
