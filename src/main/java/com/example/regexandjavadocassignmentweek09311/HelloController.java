package com.example.regexandjavadocassignmentweek09311;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField fn;

    @FXML
    private TextField ln;

    @FXML
    private TextField email;

    @FXML
    private TextField dob;

    @FXML
    private TextField zipcode;

    @FXML
    private Button Register;

    @FXML
    private Label label;

    boolean flag;

    public void checksTheNameField(
    ){
        do {
            String textField = " [a-zA-Z]{2,25}";
            String input = fn.getText();
            flag = input.matches(textField);
        }while(!flag);
        label.setText("First name should be only 2-25 characters");
    }
}