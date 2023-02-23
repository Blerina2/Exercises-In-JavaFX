package com.example.ushtrimeprovim2023.DetyraNeLiber;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Detyra8 extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        StackPane pane=new StackPane();
        Button ok=new Button("OK");
        ok.setStyle("-fx-border-color: blue");
        pane.getChildren().add(ok);

        pane.setRotate(45);
        pane.setStyle("-fx-border-color: red;-fx-background-color: lightgray");

        Scene scene=new Scene(pane,200,250);
        primaryStage.setTitle("Detyra e 8 ne liber");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args){
        launch(args);
    }


}
