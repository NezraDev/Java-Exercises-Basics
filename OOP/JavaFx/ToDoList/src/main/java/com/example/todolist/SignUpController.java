package com.example.todolist;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {


    @FXML
    private TextField tf_username;

    @FXML
    private TextField tf_password;

    @FXML
    private Button signup_button;

    @FXML
    private ProgressIndicator progress_button;

    @FXML
    private Button login_link;

    @Override
    public void initialize(URL location, ResourceBundle resources){

        signup_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String username = tf_username.getText().trim();
                String password = tf_password.getText().trim();
                if(username.isEmpty() || password.isEmpty()){
                    System.out.println("Please fill the all the information needed");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill the all the information needed");
                    alert.show();
                }
                else{
                    DBUtils.signUpUser(event, username, password);

                }
            }
        });
        login_link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "login.fxml" , "Login", null);
            }
        });
}

}