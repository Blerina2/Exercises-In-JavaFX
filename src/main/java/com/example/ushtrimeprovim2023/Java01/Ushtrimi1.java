package com.example.ushtrimeprovim2023.Java01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Ushtrimi1 extends Application {

@Override
    public void start(Stage primaryStage)throws Exception{

    Label lbl = new Label("Miresevini ne KNK!");

    Button btn = new Button("Click Me!");
    Scene scene = new Scene(lbl, 250, 250);


    primaryStage.setScene(scene);
    primaryStage.show();


}


    public static void main(String[] args){
    launch(args);
}


}
