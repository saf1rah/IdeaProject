module com.example.latihan1modul6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.latihan1modul6 to javafx.fxml;
    exports com.example.latihan1modul6;
}