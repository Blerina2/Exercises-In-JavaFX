package com.example.ushtrimeprovim2023.Java01;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Ushtrimi6 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
            Pane pane=new Pane();

        Circle circle=new Circle();
        circle.setRadius(50);
        circle.setFill(Color.TEAL);
        circle.setStrokeWidth(2);
        circle.setStroke(Color.DARKBLUE);
        circle.setCenterX(52);
        circle.setCenterY(52);


        Rectangle rectangle=new Rectangle(100,50);
        rectangle.setStyle("-fx-fill: firebrick;-fx-stroke: #333333; -fx-stroke-width: 3px");
        rectangle.setX(200);
        rectangle.setY(26.5);
        rectangle.setArcHeight(5);
        rectangle.setArcWidth(20);

        Line line=new Line(rectangle.getX(),rectangle.getY(),
                rectangle.getX()+rectangle.getArcWidth(),rectangle.getY()+rectangle.getArcHeight());
        line.setStroke(Color.ORANGERED);

        Polygon polygon= new Polygon();
        polygon.setFill(Color.DARKGREEN);
        polygon.setStroke(Color.CADETBLUE);
        polygon.getPoints().addAll(400.0, 101.00, 600.0, 101.0, 500.0, 1.0);

        Text text=new Text("Lenda KNK");
        Font font=Font.font("Times New Roman", FontWeight.SEMI_BOLD, FontPosture.ITALIC,16);
        text.setFont(font);
        text.setStroke(Color.CRIMSON);
        text.setX(300.5-25);
        text.setY(150);
        text.setTextAlignment(TextAlignment.CENTER);
        text.setTextOrigin(VPos.CENTER);


        pane.getChildren().addAll(circle, rectangle,polygon,text);

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




        Scene scene = new Scene(pane, 601, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static void main(String[] args){
        launch(args);
    }

}
