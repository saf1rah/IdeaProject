package com.main.mod6;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainMenuScene {

    public static Scene getScene(Stage stage) {
        VBox mainMenu = new VBox();
        mainMenu.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
        Label label = new Label("Library System");
        Button adminButton = new Button("Login as Admin");
        Button studentButton = new Button("Login as Student");
        Button exitButton = new Button("Exit");

        adminButton.setOnAction(event -> {
            Stage adminStage = (Stage) adminButton.getScene().getWindow(); // Mendapatkan Stage saat ini
            adminStage.setScene(AdminLoginScene.getScene(adminStage)); // Memanggil AdminLoginScene dengan Stage yang diberikan
        });

        studentButton.setOnAction(e -> stage.setScene(StudentLoginScene.getScene(stage)));
        exitButton.setOnAction(e -> System.exit(0));

        mainMenu.getChildren().addAll(label, adminButton, studentButton, exitButton);

        return new Scene(mainMenu, 300, 200);
    }
}
