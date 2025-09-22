module com.example.mmodul6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mmodul6 to javafx.fxml;
    exports com.example.mmodul6;
}