package com.example.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
// ✅ CHANGED: added Alert import
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class signupControl {

    @FXML TextField username_signup;
    @FXML TextField name_signup;
    @FXML TextField email_signup;
    @FXML PasswordField password_signup;
    @FXML RadioButton male, female;
    @FXML Pane pane;

    @FXML
    public void initialize() {
        pane.setStyle("-fx-background-color: #d21212;");
    }

    public void signup_click(ActionEvent event) throws IOException {
        String username = username_signup.getText().trim();
        String password = password_signup.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Username and password cannot be empty!");
            return;
        }

        boolean registered = HelloController.add(username, password);

        if (registered) {
            showAlert(Alert.AlertType.INFORMATION, "Account created! Please login.");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/login/login.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/com/example/login/style.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } else {
            showAlert(Alert.AlertType.ERROR, "Username already exists! Choose a different one.");
        }
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setContentText(message);
        alert.showAndWait();
    }
}