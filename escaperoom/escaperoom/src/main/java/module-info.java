module git commit -m  {
    requires javafx.controls;
    requires javafx.fxml;

    opens git commit -m  to javafx.fxml;
    exports git commit -m ;
}
