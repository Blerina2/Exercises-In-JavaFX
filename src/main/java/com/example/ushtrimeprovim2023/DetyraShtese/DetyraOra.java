package com.example.ushtrimeprovim2023.DetyraShtese;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.Clock;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DetyraOra extends Application {


    @Override
    public void start(Stage primaryStage) throws  Exception{
        BorderPane pane = new BorderPane();

        clock clock = new clock();
        Label lblTime = new Label(clock.getDescriptionTime());
        pane.setCenter(clock);
        pane.setBottom(lblTime);
        BorderPane.setAlignment(lblTime, Pos.CENTER);

        //pane.getChildren().addAll(clock);


        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setScene(scene);
        primaryStage.show();



    }


    class clock extends Pane{
        private  int hour;
        private  int min;
        private  int sec;

        public clock(){
            this.setCurrentTime();
        }

        public clock(int hour,int min,int sec){
            this.hour=hour;
            this.min=min;
            this.sec=sec;
        }

        public void  setCurrentTime(){
            Calendar calendar=new GregorianCalendar();

            this.hour=calendar.get(Calendar.HOUR_OF_DAY);
            this.min=calendar.get(Calendar.MINUTE);
            this.sec=calendar.get(Calendar.SECOND);

            paintClock();
        }

        public String getDescriptionTime(){
            return this.hour+":"+this.min+":"+this.sec;
        }

        private void paintClock(){
            double clockRadius=Math.min(getWidth(),getHeight())*0.8*0.5;
            double centerX=getWidth()/2;
            double centerY=getHeight()/2;

            Circle circle = new Circle(centerX, centerY, clockRadius);
            circle.setFill(Color.WHITE);
            circle.setStroke(Color.BLACK);

            Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
            Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
            Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
            Text t4 = new Text(centerX - 3, centerY + clockRadius -3, "6");

            //Draw second hand
            double sLength = clockRadius * 0.8;
            double secondX = centerX + sLength * Math.sin(this.sec* (2 * Math.PI / 60));
            double secondY = centerY - sLength * Math.cos(this.sec * (2 * Math.PI / 60));
            Line sLine = new Line(centerX, centerY, secondX, secondY);
            sLine.setStroke(Color.RED);

            //Draw minutes hand
            double mLength = clockRadius * 0.65;
            double minuteX = centerX + mLength * Math.sin(this.min * (2 * Math.PI / 60));
            double minuteY = centerY - mLength * Math.cos(this.min* (2 * Math.PI / 60));
            Line mLine = new Line(centerX, centerY, minuteX, minuteY);
            mLine.setStroke(Color.BLUE);

            //Draw minutes hand
            double hLength = clockRadius * 0.5;
            double hourX = centerX + hLength * Math.sin(this.min * (2 * Math.PI / 60));
            double hourY = centerY - hLength * Math.cos(this.min * (2 * Math.PI / 60));
            Line hLine = new Line(centerX, centerY, hourX, hourY);
            hLine.setStroke(Color.GREEN);


            getChildren().clear();
            getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);
        }

        public void setWidth(double width) {
            super.setWidth(width);
            paintClock();
        }

        public void setHeight(double height) {
            super.setHeight(height);
            paintClock();
        }


        }




    public static void main(String[] args){

        launch(args);
    }


}
