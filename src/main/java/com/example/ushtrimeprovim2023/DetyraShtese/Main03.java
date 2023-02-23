package com.example.ushtrimeprovim2023.DetyraShtese;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main03 extends Application {


    @Override
    public void start(Stage primaryStage)throws Exception{

        CustomRect myrect=new CustomRect(100,5);
        Pane pane=new Pane();
        pane.getChildren().add(myrect);

        Scene scene=new Scene(pane,500,500);

        primaryStage.setScene(scene);
        primaryStage.show();


    }

    class CustomRect extends Pane{

        private int numOfRects;
        private int rateOfRects;

        private void paint(){
            Group group=new Group();
            for(int i=0;i<this.numOfRects;i++){
                Rectangle r=new Rectangle(150,152,200,50);
                r.setRotate(i*360/this.rateOfRects);
                r.setStroke(Color.color(Math.random(),Math.random(),Math.random()));
                r.setFill(null);
                group.getChildren().add(r);
            }

            super.getChildren().clear();
            super.getChildren().add(group);

        }

        public CustomRect(int numOfRects,int rateOfRects){
            super();
            this.numOfRects=numOfRects;
            this.rateOfRects=rateOfRects;
            paint();

        }


    }


    public static void main(String[] args){
        launch(args);
    }




}
