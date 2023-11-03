package com.example.regexandjavadocassignmentweek09311;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class HelloController {

    @FXML
    private TextField fn,ln,email,dob,zipcode;

    @FXML
    private Button Register;

    @FXML
    private Label label;

    boolean flag = false;
    public void initialize() {
        fn.setOnKeyPressed(event -> {

            if (event.getCode() != KeyCode.TAB && flag) {
                fn.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                label.setText("");

                flag = false;
            }
        });
        fn.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Welcome text is focused");
            } else {
                if (fn.getText().matches("^(.+)@(.+)$*")) {
                    fn.setEditable(false);
                    fn.setBorder(null);
                } else {

                    fn.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    fn.setVisible(true);
                    fn.requestFocus();
                    label.setText(fn.getText() + " is not valid email");
                    flag = true;
                }

            }
        });
    }
}

