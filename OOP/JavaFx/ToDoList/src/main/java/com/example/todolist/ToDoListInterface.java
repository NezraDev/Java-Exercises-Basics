package com.example.todolist;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ToDoListInterface implements Initializable {

    @FXML
    private Button button_logout;
    @FXML
    private Button deleted_task;
    @FXML
    private Button done_tasks;
    @FXML
    private Button track_task;
    @FXML
    private Button create_task;
    @FXML
    private Label welcome_label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.changeScene(event, "landing-page.fxml", "To Do List", null);
            }
        });

    }

    public void setUserInformation(String username){
        welcome_label.setText("Welcome" + username);
    }

}
