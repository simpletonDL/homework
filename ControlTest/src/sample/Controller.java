package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private int n = 10;

    @FXML
    GridPane grid;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Button btn = new Button();
                btn.setText(Integer.toString(i+j));
                btn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        add(btn);
                    }
                });
                btn.setText(Integer.toString(i+j));
                grid.add(btn, i, j);

            }
        }
    }

    private Button btn1;
    private Button btn2;
    private boolean btnIsChosen = false;

    private void add(Button btn) {
        if (!btnIsChosen) {
            btn1 = btn;
            btnIsChosen = true;
        } else {
            btn2 = btn;
            if (btn1 != btn2) {
                if (btn1.getText().equals(btn2.getText())) {
                    System.out.println("Equals");
                }
            }
            btnIsChosen = false;
        }
    }

    private void randomGeneration(ArrayList<String> arr) {
        ArrayList<String> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n*n / 2; i++) {
            numbers.add(Integer.toString(random.nextInt() % 100));
        }
        for (int i = 0; i < n*n / 2; i++) {
            numbers.add(numbers.get(i));
        }
        for (int i = 0; i < n*n; i++) {
            int id1 = random.nextInt() % n*n;
            int id2 = random.nextInt() % n*n;
            //swap
        }
    }
   // private
}
