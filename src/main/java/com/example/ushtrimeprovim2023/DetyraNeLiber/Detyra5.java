package com.example.ushtrimeprovim2023.DetyraNeLiber;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Detyra5 extends Application {

    @Override
    public void start(Stage primaryStage){

        Circle circle=new Circle();
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(50);
        circle.setStroke(Color.BLUE);
        circle.setFill(Color.CADETBLUE);

        Pane pane=new Pane();
        pane.getChildren().add(circle);

        Scene scene=new Scene(pane,200,200);
        primaryStage.setTitle("Detyra e 5 ne liber");
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void main(String[] args){
        launch(args);
    }



}
