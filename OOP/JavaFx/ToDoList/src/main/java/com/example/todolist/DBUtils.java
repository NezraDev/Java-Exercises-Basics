package com.example.todolist;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class DBUtils {
    public static void changeScene(ActionEvent event, String fxmlFile, String title, String username) {
        Parent root = null;

        if (username != null) {
            try {
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root = loader.load();
                ToDoListInterface toDoListInterface = loader.getController();
                toDoListInterface.setUserInformation(username);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                root = FXMLLoader.load(DBUtils.class.getResource(fxmlFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
    public static void signUpUser(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement passwordInsert = null;
        PreparedStatement passwordCheckUserExists = null;
        ResultSet resultSet = null;

        try {
            // Establish database connection
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/todolist", "root", "071223");
            System.out.println("Database connection established.");

            // Check if user already exists
            passwordCheckUserExists = connection.prepareStatement("SELECT * FROM infos WHERE username = ?");
            passwordCheckUserExists.setString(1, username);
            resultSet = passwordCheckUserExists.executeQuery();

            if (resultSet.next()) {
                // User already exists
                System.out.println("User already exists.");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Username is already taken. Please choose a different username.");
                alert.show();
            } else {
                // Insert new user
                String hashedPassword = hashPassword(password); // Hash the password
                passwordInsert = connection.prepareStatement("INSERT INTO infos (username, password) VALUES (?, ?)");
                passwordInsert.setString(1, username);
                passwordInsert.setString(2, hashedPassword);
                int rowsAffected = passwordInsert.executeUpdate();

                if (rowsAffected > 0) {
                    Dialog<String> dialog = new Dialog<>();
                    DialogPane dialogPane = new DialogPane();

                    // Set the title and header text
                    dialog.setTitle("Successfully Registered");
                    dialogPane.setHeaderText("Welcome " + username);
                    dialogPane.setContentText("Thank you for signing up");

                    // Create an OK button
                    ButtonType okButtonType = new ButtonType("OK", ButtonType.OK.getButtonData());

                    // Set the dialog pane and add the OK button
                    dialogPane.getButtonTypes().add(okButtonType);
                    dialog.setDialogPane(dialogPane);

                    // Show the dialog
                    dialog.showAndWait();

                    changeScene(event, "login.fxml", "Login", username);
                } else {
                    System.out.println("Signup failed. No rows affected.");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Signup failed. Please try again.");
                    alert.show();
                }
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("An error occurred during signup: " + e.getMessage());
            alert.show();
        } finally {
            closeResources(resultSet, passwordInsert, passwordCheckUserExists, connection);
        }
    }

    private static void closeResources(ResultSet resultSet, PreparedStatement... statements) {
        try {
            if (resultSet != null) resultSet.close();
            for (PreparedStatement statement : statements) {
                if (statement != null) statement.close();
            }
        } catch (SQLException e) {
            System.err.println("Error closing resources: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String hashPassword(String password) {
        // Implement password hashing here
        return password; // Placeholder
    }

    public static void logInUser(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/todolist", "root", "071223");
            // Retrieve user password
            preparedStatement = connection.prepareStatement("SELECT password FROM infos WHERE username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                System.out.println("User not Found!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Credentials Incorrect!");
                alert.show();
            } else {
                String retrievedPassword = resultSet.getString("password");
                if (retrievedPassword.equals(password)) {
                    changeScene(event, "to-do-list-interface.fxml", "Welcome", null);
                } else {
                    System.out.println("Password Incorrect");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Credentials Incorrect!");
                    alert.show();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(resultSet, preparedStatement, null, connection);
        }
    }

    private static void closeResources(ResultSet resultSet, PreparedStatement preparedStatement, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
