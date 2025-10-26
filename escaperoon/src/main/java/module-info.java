module com.example {
    // Target Java 21; JavaFX module names remain the same for newer JavaFX releases
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires freetts;
    opens com.example to javafx.fxml;
    exports com.example;
}
