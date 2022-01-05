module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.java;

    opens org.example to javafx.fxml;
    exports org.example;

    opens org.example.authentication to javafx.fxml;
    exports org.example.controller;

    opens org.example.controller to javafx.fxml;

    opens org.example.model to javafx.fxml;
    exports org.example.model;

    opens org.example.security to javafx.fxml;
    exports org.example.security;

    opens org.example.exception.registration to javafx.fxml;
    exports org.example.exception.registration;

    opens org.example.exception.login to javafx.fxml;
    exports org.example.exception.login;

    opens org.example.exception to javafx.fxml;
    exports org.example.exception;
}
