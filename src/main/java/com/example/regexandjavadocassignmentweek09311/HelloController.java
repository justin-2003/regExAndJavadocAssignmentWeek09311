package com.example.regexandjavadocassignmentweek09311;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    // all the variables

    @FXML
    private TextField fn,ln,email,dob,zipcode;

    @FXML
    private Button register;

    @FXML
    private Label label;

    private Stage stage;
    private Scene scene;
    private Parent root;

    boolean flag = false;

    boolean isFormValid = false;


    public void initialize() {
        // checks if all the fields are filled correctly and helps with the register button
        fn.focusedProperty().addListener((observable, oldValue, newValue) -> checkAvialabilty());
        email.focusedProperty().addListener((observable, oldValue, newValue) -> checkAvialabilty());
        ln.focusedProperty().addListener((observable, oldValue, newValue) -> checkAvialabilty());
        dob.focusedProperty().addListener((observable, oldValue, newValue) -> checkAvialabilty());
        zipcode.focusedProperty().addListener((observable, oldValue, newValue) -> checkAvialabilty());
        zipcode.setOnKeyPressed(event -> {
            if (event.getCode() != KeyCode.TAB && flag) {
                zipcode.setStyle("-fx-border-color: black ; -fx-border-width: 1px ;");
                label.setText("");
                flag = false;

            }
        });

        //This make sure that the First name field is btw 2-25 characters and won't let u go to the next field
        fn.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {

                System.out.println("Welcome text is focused");
            } else {
                if (fn.getText().matches("[a-zA-Z]{2,25}")) {
                    fn.setEditable(false);
                    fn.setBorder(null);
                    fn.setStyle("-fx-border-color: green ; -fx-border-width: 4px ;");
                } else {

                    fn.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    fn.setVisible(true);
                    fn.requestFocus();
                    label.setText( "First name needs to be between 2-25 characters");
                    flag = true;
                }

            }
        });

        //This make sure that the email field is on the right format of @farmingdale.edu and won't let u go to the next field
        email.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Welcome text is focused");
            } else {
                if (email.getText().matches("^[A-Za-z0-9]+@farmingdale\\.edu$")) {
                    email.setEditable(false);
                    email.setBorder(null);
                    email.setStyle("-fx-border-color: green ; -fx-border-width: 4px ;");
                } else {

                    email.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    email.setVisible(true);
                    email.requestFocus();
                    label.setText("email should be in the farmingdale.edu format");
                    flag = true;
                }

            }
        });

        //This make sure that the last name field is btw 2-25 characters and won't let u go to the next field
        ln.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Welcome text is focused");
            } else {
                if (ln.getText().matches("[a-zA-Z]{2,25}")) {
                    ln.setEditable(false);
                    ln.setBorder(null);
                    ln.setStyle("-fx-border-color: green ; -fx-border-width: 4px ;");
                } else {

                    ln.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    ln.setVisible(true);
                    ln.requestFocus();
                    label.setText("Last name needs to be between 2-25 characters");
                    flag = true;
                }

            }
        });

        //This make sure that the date of birth field is in the format of 00/00/0000 and won't let u go to the next field
        dob.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Welcome text is focused");
            } else {
                if (dob.getText().matches("\\d{2}/\\d{2}/\\d{4}")) {
                    dob.setEditable(false);
                    dob.setBorder(null);
                    dob.setStyle("-fx-border-color: green ; -fx-border-width: 4px ;");
                } else {

                    dob.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    dob.setVisible(true);
                    dob.requestFocus();
                    label.setText("date of birth should be in this format 00/00/0000");
                    flag = true;
                }

            }
        });

        //Make sure that the zipcode field is 5 digits and won't let u go to the next field
        zipcode.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Welcome text is focused");
            } else {
                if (zipcode.getText().matches("\\d{5}")) {
                    zipcode.setEditable(false);
                    zipcode.setBorder(null);
                    zipcode.setStyle("-fx-border-color: green ; -fx-border-width: 4px ;");
                } else {

                    zipcode.setStyle("-fx-border-color: red ; -fx-border-width: 4px ;");
                    zipcode.setVisible(true);
                    zipcode.requestFocus();
                    label.setText("date of birth should be in this format 00/00/0000");
                    flag = true;
                }

            }
        });
    }

    //this method is to check if all the fields matches to their on fields
    private void checkAvialabilty(){
        isFormValid = fn.getText().matches("[a-zA-Z]{2,25}")
                  &&  ln.getText().matches("[a-zA-Z]{2,25}")
                  &&  email.getText().matches("^[A-Za-z0-9]+@farmingdale\\.edu$")
                  &&  dob.getText().matches("\\d{2}/\\d{2}/\\d{4}")
                  &&  zipcode.getText().matches("\\d{5}");

        register.setDisable(!isFormValid);
    }

    //method that takes u to the next scene
    public void AccountButtonClick(ActionEvent e) throws IOException {
        //if the isFormValid is ture then it will take u to the main scene
        if (isFormValid) {
            Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}

