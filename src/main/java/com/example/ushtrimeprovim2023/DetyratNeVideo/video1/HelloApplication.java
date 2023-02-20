package com.example.ushtrimeprovim2023.DetyratNeVideo.video1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Pane pane=new Pane();

        Circle circle=new Circle(52,52,50);
        circle.setStrokeWidth(2);
        circle.setStroke(Color.DARKBLUE);
        circle.setFill(Color.TEAL);

        Rectangle rectangle=new Rectangle();
        rectangle.setX(200);
        rectangle.setY(26.5);
        rectangle.setWidth(100);
        rectangle.setHeight(50);
        rectangle.setArcWidth(15);
        rectangle.setArcHeight(15);
        //  rectangle.setStrokeWidth(3);
        rectangle.setStyle("-fx-stroke-width: 3px;-fx-stroke: #333333;-fx-fill: firebrick");

        Line line=new Line(rectangle.getX(),rectangle.getY(),
                rectangle.getX()+rectangle.getWidth(),rectangle.getY()+rectangle.getHeight());
        line.setStroke(Color.ORANGE);

        Polygon triangle=new Polygon(400.0,101.00,
                600.0,101.0,
                500.0,1.0);
        triangle.setFill(Color.DARKGREEN);
        triangle.setStroke(Color.CADETBLUE);

        Text text=new Text(120,120,"Lenda KNK");
        text.setFont(Font.font("Times New Roman", FontWeight.SEMI_BOLD, FontPosture.ITALIC,16));
        text.setStroke(Color.CRIMSON);
        text.setX(250);
        text.setY(150);


        pane.getChildren().addAll(circle,rectangle,line,triangle,text);

        for(int i=0;i<3;i++){
            int angle=i*120;
            int length=45;
            Arc arc=new Arc();
            arc.setCenterX(circle.getCenterX());
            arc.setCenterY(circle.getCenterY());
            arc.setRadiusX(circle.getRadius()/2);
            arc.setRadiusY(circle.getRadius()/2);
            arc.setStartAngle(angle);
            arc.setLength(length);
            arc.setType(ArcType.ROUND);
            arc.setStyle("-fx-fill:#d3d036 ");

            pane.getChildren().add(arc);
        }


        Scene scene=new Scene(pane,601,200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("TEST");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}