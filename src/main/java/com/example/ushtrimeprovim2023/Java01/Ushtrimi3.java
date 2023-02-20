package com.example.ushtrimeprovim2023.Java01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Ushtrimi3 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Button bOk=new Button("Ok");
        Line line1,line2;
        Circle circle1,circle2;

        line1=new Line();
        line1.setStartX(0);
        line1.setStartY(0);
        line1.setEndX(500);
        line1.setEndY(500);

        line2=new Line();
        line2.setStartX(500);
        line2.setStartY(0);
        line2.setEndX(0);
        line2.setEndY(500);

        circle1 = new Circle();
        circle1.setCenterX(0);
        circle1.setCenterY(400);
        circle1.setRadius(50);
        circle1.setOpacity(.5);

        circle2=new Circle();
        circle2.setCenterX(20);
        circle2.setCenterY(20);
        circle2.setRadius(5);
        circle2.setOpacity(.2);

        StackPane pane=new StackPane();

        pane.getChildren().addAll(line1,line2,circle1,circle2);

        Scene scene=new Scene(pane,500,500);

        primaryStage.setTitle("Detyra e pare ne JavaFx");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args){
        launch(args);
    }


}
