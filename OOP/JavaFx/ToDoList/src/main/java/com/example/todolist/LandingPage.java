package com.example.todolist;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class LandingPage implements Initializable {

    @FXML
    private ImageView image_logo;

    @FXML
    private Button loginbutton;

    @FXML
    private Button signup;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "login.fxml", "Login", null);
            }
        });
        signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Redirect to the signup page
                DBUtils.changeScene(event, "sign-up.fxml", "Signup", null);
            }
        });
    }

}
