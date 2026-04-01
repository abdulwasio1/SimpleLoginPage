module com.example.login {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.management;

    opens com.example.login to javafx.fxml;
    exports com.example.login;
}