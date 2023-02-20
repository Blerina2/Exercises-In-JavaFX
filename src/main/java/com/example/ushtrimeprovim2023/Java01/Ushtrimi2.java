package com.example.ushtrimeprovim2023.Java01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Ushtrimi2  extends Application {

    @Override
    public void  start(Stage primaryStage) throws Exception{
        Button b1=new Button("Clickk me!");
        Button b2=new Button("Dont click me!");

        Scene scene1=new Scene(b1,250,250);
        Scene scene2=new Scene(b2,250,250);

        primaryStage.setTitle("Dritarja e par punuese");
        primaryStage.setScene(scene1);
        primaryStage.show();

        Stage stage2=new Stage();
        stage2.setTitle("Dritarja e dyte punuese");
        stage2.setScene(scene2);
        stage2.show();

    }



    public static void main(String[] args){
        launch(args);
    }


}
