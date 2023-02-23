package com.example.ushtrimeprovim2023.Java02;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Ushtrimi03 extends Application {


    @Override
    public void start(Stage primaryStage)throws Exception{
//        MyCustomRect rect=new MyCustomRect();
//        rect.setWidth(220);
//        rect.setHeight(200);

//      MyCustomAdvancedRect rect = new MyCustomAdvancedRect();
//    	rect.setWidth(200);
//    	rect.setHeight(200);
//    	rect.setColors(null, Color.BLACK, null, Color.BLACK);
//      MyCustomRect rect2 = new MyCustomRect();
//		rect2.setWidth(220);
//		rect2.setHeight(200);

        MyCustomFan fan = new MyCustomFan();
        fan.setWidth(200);
        fan.setNum(5);


        FlowPane pane=new FlowPane();
        pane.getChildren().add(fan);

        Scene scene=new Scene(pane,250,250);
        primaryStage.setTitle("Detyra 2 ne grupin e 3");
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    class MyCustomAdvancedRect extends Pane{
        private Color color1 = new Color(Math.random(), Math.random(), Math.random(), 0.5);
        private Color color2 = new Color(Math.random(), Math.random(), Math.random(), 0.5);
        private Color color3 = new Color(Math.random(), Math.random(), Math.random(), 0.5);
        private Color color4 = new Color(Math.random(), Math.random(), Math.random(), 0.5);

        private void draw() {
            Rectangle rect = new Rectangle(10, 10, super.getWidth(), super.getHeight());
            rect.setFill(null);

            double x0, x1, x2, x3, x4;
            double y0, y1, y2, y3, y4;

            x0 = rect.getX();
            y0 = rect.getY();
            x1 = x0 + super.getWidth();
            y1 = y0;
            x2 = x1;
            y2 = y1 + super.getHeight();
            x3 = x0;
            y3 = y2;
            x4 = x0 + super.getWidth() * 0.5;
            y4 = y0 + super.getHeight() * 0.5;

            Polygon pg1 = new Polygon(x0, y0, x4, y4, x1, y1);
            pg1.setFill(this.color1);

            Polygon pg2 = new Polygon(x1, y1, x4, y4, x2, y2);
            pg2.setFill(this.color2);

            Polygon pg3 = new Polygon(x2, y2, x4, y4, x3, y3);
            pg3.setFill(this.color3);

            Polygon pg4 = new Polygon(x3, y3, x4, y4, x0, y0);
            pg4.setFill(this.color4);

            super.getChildren().clear();
            super.getChildren().addAll(rect, pg1, pg2, pg3, pg4);
        }

        public void setWidth(double width) {
            super.setWidth(width);
            this.draw();
        }

        public void setHeight(double height) {
            super.setHeight(height);
            this.draw();
        }

        public void setColors(Color c1, Color c2, Color c3, Color c4) {
            this.color1 = c1;
            this.color2 = c2;
            this.color3 = c3;
            this.color4 = c4;
            this.draw();
        }
    }


    class MyCustomRect extends Pane{

        public void draw(){
            Rectangle rect=new Rectangle(10,10,super.getWidth(),super.getHeight());
            rect.setFill(null);
            rect.setStroke(Color.DARKBLUE);

            double x0, y0, x1, y1, x2, y2, x3, y3;
            x0 = rect.getX();
            y0 = rect.getY();
            x1 = x0 + super.getWidth();
            y1 = y0;
            x2 = x1;
            y2 = y1 + super.getHeight();
            x3 = x0;
            y3 = y0 + super.getHeight();

            Line line1 = new Line(x0, y0, x2, y2);
            Line line2 = new Line(x1, y1, x3, y3);

            super.getChildren().clear();
            super.getChildren().addAll(rect, line1, line2);


        }

        public void setWidth(double width) {
            super.setWidth(width);
            this.draw();
        }

        public void setHeight(double height) {
            super.setHeight(height);
            this.draw();
        }

    }

    class MyCustomFan extends Pane {
        private int num = 4;

        private void draw() {
            double x0, y0, r, r1;
            double areas = (360.0 / this.num);

            x0 = 10 + super.getWidth() * 0.5;
            y0 = 10 + super.getHeight() * 0.5;
            r = super.getWidth() * 0.5;
            r1 = r - 5;

            Circle circle = new Circle(x0, y0, r);
            circle.setFill(null);
            circle.setStroke(Color.DARKMAGENTA);

            Group group = new Group();
            for(int i = 0; i < this.num ; i++) {
                Arc arc = new Arc(x0, y0, r1, r1, i * areas, areas * 0.5);
                arc.setFill(null);
                arc.setStroke(Color.GREEN);
                arc.setType(ArcType.ROUND);
                group.getChildren().add(arc);
            }

            super.getChildren().clear();
            super.getChildren().addAll(circle, group);
        }

        public void setWidth(double width) {
            super.setWidth(width);
            super.setHeight(width);
            this.draw();
        }

        public void setNum(int num) {
            this.num = num;
            this.draw();
        }

    }

    public static void main(String[] args){
        launch(args);
    }


}
