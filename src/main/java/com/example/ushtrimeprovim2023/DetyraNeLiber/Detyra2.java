package com.example.ushtrimeprovim2023.DetyraNeLiber;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Detyra2 extends Application {



    @Override
    public void start(Stage primaryStage)throws Exception{

        Scene scene=new Scene(new Button("Ok"),200,250);
        primaryStage.setTitle("Detyra e 2 nga libri");
        primaryStage.setScene(scene);
        primaryStage.show();

        Stage stage=new Stage();
        stage.setTitle("Faqja 2");
        stage.setScene(new Scene(new Button("New stage"),100,100));
        stage.show();


    }



    public static void main(String[] args){
        launch(args);
    }

}
