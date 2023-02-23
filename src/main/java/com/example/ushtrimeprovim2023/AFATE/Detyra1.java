//Te krijohet programi i cili e realizon punen e paraqitur ne Figura 1, sipas kërkesa në
//        vazhdim: [20 pikë]
//        - Objekti (figura) duhet të levizë sipas prezantimit në figurë
//        - Në ndryshimin e pozitës së levizjes, duhet të ndryshohet edhe figura në njerën nga
//        figurat e paraqitura: Rreth, Drejtëkëndësh, Elipsë apo Katror (i kthyer për 90*).
//        Ndryshimi i figurës duhet të bëhet në mënyrë të rastësishme (random).
package com.example.ushtrimeprovim2023.AFATE;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Detyra1 extends Application {

@Override
public void start(Stage stage)throws Exception{

    Detyra detyra=new Detyra();


    Pane pane=new Pane();
    pane.getChildren().add(detyra);

    Scene scene=new Scene(pane,800,800);
    stage.setScene(scene);
    stage.show();

}

public static void main(String[] args){
    launch(args);
}



class Detyra extends Pane{
    private final int MIN = 50;
    private final int MAX = 300;
    private double x = MIN;
    private double y = MIN;
    private Color color = Color.BLACK;
    private Timeline changeBallPositionAnimation;
    private EventHandler<ActionEvent> positionHandler = (e) -> { this.animate(); };
    double radius = 30;
    private int randomNumber = 0;

    public Detyra() {
        this.prepareAnimation();
        this.draw(false);
    }
    private void draw(boolean ndryshoFiguren) {
        if(ndryshoFiguren) {
            this.randomNumber = (int) (Math.random() * 100) % 4; // pasi qe kemi mundesi me i pas 4 elemente
            this.color = new Color(Math.random(), Math.random(), Math.random(), Math.random());
        }
        // Shape - super klasa
        //Circle, Rectangle, Ellipse, Rectangle, ... -> nenklasa te klases Shape
        Shape figure = new Circle(); // by default
        switch(randomNumber) {
            case 0:
                figure = new Circle(this.x, this.y, radius); break;
            case 1:
                figure = new Rectangle(this.x, this.y, radius, radius); break;
            case 2:
                figure = new Ellipse(this.x, this.y, radius, radius%2);
                figure.setStrokeWidth(30); break;
            case 3:
                figure = new Rectangle(this.x, this.y, radius, radius);
                figure.setRotate(45); break;
        }
        figure.setFill(this.color);
        figure.setStroke(this.color);
        super.getChildren().add(figure);
        super.getChildren().clear();
    }

    private void prepareAnimation() {
        this.changeBallPositionAnimation=new Timeline(new KeyFrame(Duration.millis(10),this.positionHandler));
        this.changeBallPositionAnimation.setCycleCount(Timeline.INDEFINITE);
        this.changeBallPositionAnimation.play();
    }
    private void animate() {
        // Kushtet e levizjes se figures
        if(this.y < MAX && this.x == MIN) this.y += 1;
        else if (this.y == MAX &&  this.x < MAX ) this.x += 1;
        else if (this.y > MIN &&  this.x == MAX ) this.y -= 1;
        else this.x -=1;

        //Figura ndryshohet vetem ne rastet kur kemi ndryshim te drejtimit
        boolean ndryshoFiguren = (this.x == MIN && this.y == MAX) ||
                (this.x == MAX && this.y == MIN) ||
                (this.x == MIN && this.y == MIN) ||
                (this.x == MAX && this.y == MAX);

        this.draw(ndryshoFiguren);
    }
}



}



