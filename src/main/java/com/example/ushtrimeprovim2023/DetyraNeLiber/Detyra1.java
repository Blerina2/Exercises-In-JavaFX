package com.example.ushtrimeprovim2023.DetyraNeLiber;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Detyra1 extends Application {
    @Override
    public void start(Stage primaryStage){
        Button okbutton=new Button("OK");
        Scene scene=new Scene(okbutton,200,250);
        primaryStage.setTitle("Programi i pare ne liber");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args){
        launch(args);
    }



}
