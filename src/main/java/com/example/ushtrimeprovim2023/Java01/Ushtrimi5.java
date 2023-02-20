package com.example.ushtrimeprovim2023.Java01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Ushtrimi5 extends Application {
    @Override

    public void start(Stage primaryStage) throws Exception{
        Polygon polygon=new Polygon(10,25, 25, 25, 45, 45, 50, 50, 100, 100, 200,200, 10, 250);
        polygon.setFill(Color.BLUE);

        Pane pane=new Pane();
        pane.getChildren().add(polygon);

        Scene scene=new Scene(pane,350,350);
        primaryStage.setTitle("Ushtrimi 5");
        primaryStage.setScene(scene);
        primaryStage.show();

    }



    public static void main(String[] args){
        launch(args);
    }

}
