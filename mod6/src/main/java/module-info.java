module com.example.mod6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    exports com.main.data;
    exports com.main.books;
    exports com.main.exception.custom;

    opens com.main to javafx.graphics, javafx.fxml;
}
