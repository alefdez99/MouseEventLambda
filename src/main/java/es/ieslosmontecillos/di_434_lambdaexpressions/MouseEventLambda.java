package es.ieslosmontecillos.di_434_lambdaexpressions;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MouseEventLambda extends Application
{
    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage primaryStage)
    {
        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER);

        primaryStage.setTitle("Mover texto, Mouse Event Lambda");

        Scene scene = new Scene(root, 300, 275);
        primaryStage.setScene(scene);

        Label lbl = new Label("Programming is fun");

        lbl.setOnMouseDragged(e -> {
                System.out.println("Arrastrando");

                double x = e.getSceneX();
                double y = e.getSceneY();

                double deltaX = x - xOffset;
                double deltaY = y - yOffset;

                lbl.setTranslateX(lbl.getTranslateX() + deltaX);
                lbl.setTranslateY(lbl.getTranslateY() + deltaY);

                xOffset = x;
                yOffset = y;
        });


        lbl.setOnMousePressed(e -> {
                System.out.println("Presionando");
                xOffset = e.getSceneX();
                yOffset = e.getSceneY();
        });

        root.getChildren().add(lbl);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}