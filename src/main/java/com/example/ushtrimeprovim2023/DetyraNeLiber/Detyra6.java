package com.example.ushtrimeprovim2023.DetyraNeLiber;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Detyra6 extends Application {

    @Override
    public void start(Stage primaryStage)throws Exception{
        Pane pane=new Pane();

        Circle circle=new Circle();
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.DARKBLUE);
        pane.getChildren().add(circle);

        Scene scene=new Scene(pane,200,200);
        primaryStage.setTitle("Deyra e 6 ne liber");
        primaryStage.setScene(scene);
        primaryStage.show();



    }


    public static void main(String[] args){
        launch(args);
    }

}
