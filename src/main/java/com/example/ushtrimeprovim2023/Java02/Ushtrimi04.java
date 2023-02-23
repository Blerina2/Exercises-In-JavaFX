package com.example.ushtrimeprovim2023.Java02;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Ushtrimi04 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //Rectangle rect = new Rectangle();
        MyCustomRect rect = new MyCustomRect();
        rect.setWidth(200);
        rect.setHeight(200);

        MyCustomAdvancedRect advancedRect = new MyCustomAdvancedRect();
        advancedRect.setWidth(200);
        advancedRect.setHeight(200);

        MyCustomAdvancedRect advancedRect1 = new MyCustomAdvancedRect();
        advancedRect1.setWidth(200);
        advancedRect1.setHeight(200);
        advancedRect1.setColors(null, Color.BLACK, null, Color.BLACK);

        MyCustomFan fan = new MyCustomFan();
        fan.setWidth(200);
        fan.setNumOfArcs(7);

        FlowPane pane = new FlowPane();
        pane.getChildren().addAll(advancedRect1, advancedRect, rect, fan);

        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Detyra e pare ne javen e dyte grupi 4!");
        stage.show();
    }

    class MyCustomRect extends Pane {
        private void draw() {
            // x0, y0, w, h
            Rectangle rect = new Rectangle(10, 10, super.getWidth(), super.getHeight());
            rect.setFill(null);
            rect.setStroke(Color.DARKMAGENTA);

            double x0, x1, x2, x3;
            double y0, y1, y2, y3;

            x0 = rect.getX();
            y0 = rect.getY();
            x1 = x0 + super.getWidth();
            y1 = y0 + super.getHeight();
            x2 = x1;
            y2 = y0;
            x3 = x0;
            y3 = y1;

            //x0, y0, x1, y1
            Line line1 = new Line(x0, y0, x1, y1);
            Line line2 = new Line(x2, y2, x3, y3);

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

    class MyCustomAdvancedRect extends Pane {
        private Color color1 = new Color(Math.random(), Math.random(), Math.random(), 0.5);
        private Color color2 = new Color(Math.random(), Math.random(), Math.random(), 0.5);
        private Color color3 = new Color(Math.random(), Math.random(), Math.random(), 0.5);
        private Color color4 = new Color(Math.random(), Math.random(), Math.random(), 0.5);

        private void draw() {
            Rectangle rect = new Rectangle(10, 10, super.getWidth(), super.getHeight());
            rect.setFill(null);
            rect.setStroke(Color.BLACK);

            double x0, x1, x2, x3, x4;
            double y0, y1, y2, y3, y4;
            x0 = rect.getX();
            y0 = rect.getY();
            x1 = x0 + super.getWidth();
            y1 = y0 + super.getHeight();
            x2 = x1;
            y2 = y0;
            x3 = x0;
            y3 = y1;
            x4 = x0 + super.getWidth() * 0.5;
            y4 = y0 + super.getHeight() * 0.5;

            Polygon pg1 = new Polygon(x0, y0, x4, y4, x2, y2);
            pg1.setFill(Color.BLACK);
            pg1.setFill(this.color1);

            Polygon pg2 = new Polygon(x2, y2, x4, y4, x1, y1);
            pg2.setFill(this.color2);

            Polygon pg3 = new Polygon(x1, y1, x4, y4, x3, y3);
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

    class MyCustomFan extends Pane {
        private int numOfArcs = 4;

        private void draw() {
            double x, y, r, r1;
            x = 10 + super.getWidth() * 0.5;
            y = 10 + super.getHeight() * 0.5;
            r = super.getWidth() * 0.5;
            r1 = r - 10;

            Circle circle = new Circle(x, y, r);
            circle.setFill(null);
            circle.setStroke(Color.DARKCYAN);

            Group group = new Group();
            double area = 360.0 / this.numOfArcs;

            for( int i = 0; i < this.numOfArcs; i++) {
                Arc arc = new Arc(x, y, r1, r1, i * area, area * 0.5);
                arc.setFill(null);
                arc.setStroke(Color.DARKGREEN);
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

        public void setNumOfArcs(int num) {
            this.numOfArcs = num;
        }
    }


}
