package com.example.login;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class screenControl {
    @FXML
    public Label username_display;
    @FXML
    public Label password_display;
    public void getText(String username , String password){
        username_display.setText(username);
        password_display.setText(password);
    }

    public screenControl() throws IOException {
    }
}
