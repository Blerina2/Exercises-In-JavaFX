package com.example.ushtrimeprovim2023.DetyraNeLiber;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Detyra4 extends Application {

    @Override
    public void start(Stage primaryStage){

        StackPane pane=new StackPane();
        pane.getChildren().add(new Button("OK"));
        Scene scene=new Scene(pane,200,50);
        primaryStage.setTitle("Detyra4");
        primaryStage.setScene(scene);
        primaryStage.show();




    }


    public static void main(String[] args){
        launch(args);
    }

}
