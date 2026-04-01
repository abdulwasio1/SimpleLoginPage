package com.example.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloController {

    static ArrayList<String> usernames = new ArrayList<>();
    static ArrayList<String> passwords = new ArrayList<>();

    public Stage stage;

    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private Pane pane;
    @FXML private Label error;

    @FXML
    public void initialize() {
        pane.setStyle("-fx-background-color: #d21212;");
    }

    public void login(ActionEvent event) throws IOException {
        String id   = username.getText().trim();
        String pass = password.getText().trim();

        if (id.isEmpty() || pass.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Please enter username and password.");
            return;
        }

        if (check(id, pass)) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/login/display.fxml"));
            Parent root = loader.load();
            screenControl control = loader.getController();
            control.getText(id, pass);

            showAlert(Alert.AlertType.INFORMATION, "Login Successful!");

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } else {
            showAlert(Alert.AlertType.ERROR, "Wrong Username or password! Try again.");
        }
    }

    public void signup(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/login/signup.fxml"));
        Parent root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public boolean check(String username, String password) {
        int index = usernames.indexOf(username);
        if (index == -1) return false;
        return passwords.get(index).equals(password);
    }

    public static boolean add(String id, String pass) {
        if (id.isEmpty() || pass.isEmpty()) return false;
        if (usernames.contains(id)) return false; // duplicate username
        usernames.add(id);
        passwords.add(pass);
        return true;
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setContentText(message);
        alert.showAndWait();
    }
}