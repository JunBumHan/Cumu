module com.example.loginform {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    opens com.example.loginform to javafx.fxml;
    exports com.example.loginform;
}