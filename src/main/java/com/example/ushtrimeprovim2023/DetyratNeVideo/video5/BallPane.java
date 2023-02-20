package com.example.ushtrimeprovim2023.DetyratNeVideo.video5;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class BallPane extends Pane {
    public final double RADIUS=20;
    public final double SPEED_RATE=0.5;
    private Circle circle;
    private double x;
    private double y;
    public  double dy=0.5;
    public  double dx=0.5;
    private Timeline animation;


    public BallPane(){
        this.circle=new Circle();
        this.circle.setCenterX(RADIUS);
        this.circle.setCenterY(RADIUS);
        this.circle.setRadius(RADIUS);
        this.circle.setFill(Color.FIREBRICK);
        this.getChildren().add(circle);
        this.x=this.circle.getCenterX();
        this.y=this.circle.getCenterY();

        this.animation=new Timeline(new KeyFrame(Duration.millis(50),e->this.moveBall()));
        this.animation.setCycleCount(Timeline.INDEFINITE);
    }


    public void moveBall(){
        final double paneWidth=getWidth();
        final double panwHeight=getHeight();
        if(this.x<RADIUS || this.x>paneWidth-RADIUS){

            this.dx *=-1;//change direction
        }

        if(this.y<RADIUS || this.y>panwHeight-RADIUS){
           this.dy *=-1;
        }

        this.x +=dx;
        this.y +=dy;
        this.circle.setCenterX(this.x);
        this.circle.setCenterY(this.y);


    }


    public boolean isPlaying(){
        return this.animation.getStatus()== Animation.Status.RUNNING;
    }

    public void play(){

        if(!this.isPlaying()){
        this.animation.play();
    }
    }

    public void stop(){
        if(this.isPlaying()){
            this.animation.stop();
        }
    }

    public void incSpeed(){
        double newSpeed=animation.getRate()+SPEED_RATE;
        animation.setRate(newSpeed);
    }

    public void  decSpeed(){
        double newSpeed=animation.getRate()-SPEED_RATE;
        if(newSpeed<0)newSpeed=0;
        animation.setRate(newSpeed);

    }


}
