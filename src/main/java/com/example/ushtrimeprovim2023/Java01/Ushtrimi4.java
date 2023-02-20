package com.example.ushtrimeprovim2023.Java01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Ushtrimi4 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Create a pane and set its properties
        FlowPane pane=new FlowPane();
        pane.setHgap(5);
        pane.setVgap(5);


        //Place nodes in the pane
        pane.getChildren().addAll(
            new Label("First Name:"),
            new TextField(),
            new Label("MI:")
        );

        TextField textField=new TextField();
        textField.setPrefColumnCount(1);
        pane.getChildren().addAll(
                textField,
                new Label("Last name:"),
                new TextField()
        );

        //Create a scene and place it in the stage

        Scene scene=new Scene(pane,300,200);
        primaryStage.setTitle("ShowFlowPane");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args){
        launch(args);
    }

}
