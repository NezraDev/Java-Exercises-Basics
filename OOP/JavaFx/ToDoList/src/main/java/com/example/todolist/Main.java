package com.example.todolist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override

    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("landing-page.fxml"));
        stage.setTitle("ToDoList");
        stage.setScene(new Scene(root, 600, 420));
        stage.show();
    }

    public static void main(String[] args) {
    launch(args);
    }
}