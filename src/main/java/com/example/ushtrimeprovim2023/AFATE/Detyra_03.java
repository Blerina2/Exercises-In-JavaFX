package com.example.ushtrimeprovim2023.AFATE;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Detyra_03 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane bp = new BorderPane();
        MyCustom fan = new MyCustom();
        bp.setCenter(fan);
        Scene scene = new Scene(bp, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    class MyCustom extends Pane {
        private int num = 5;

        private void draw() {
            double x, y, radius;
            x = 10 + super.getWidth() / 2;
            y = 10 + super.getHeight() / 2;
            radius = super.getWidth() / 2;

            Circle circle = new Circle(x, y, radius);
            circle.setFill(null);
            circle.setStroke(Color.BLACK);

            for (int i = 0; i < this.num; i++) {
                super.getChildren().clear();
                double startPosition = 360 / this.num;
                double length = startPosition / 2;
                Arc arc = new Arc(x, y, radius - 10,
                        radius - 10, i * startPosition, length);
                arc.setFill(null);
                arc.setStroke(Color.GREEN);
                arc.setStrokeWidth(3);
                arc.setType(ArcType.ROUND);
                super.getChildren().add(arc);
            }

        }

        public void setWidth(double width) {
            super.setWidth(width);
            super.setHeight(width);
            this.draw();
        }

    }
}