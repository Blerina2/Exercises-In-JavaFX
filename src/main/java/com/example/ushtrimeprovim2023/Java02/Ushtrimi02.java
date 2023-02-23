package com.example.ushtrimeprovim2023.Java02;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Ushtrimi02 extends Application {


    @Override
    public void start(Stage primaryPage) throws Exception{
        Pane pane=new Pane();

//        MyCustomFan myFan=new MyCustomFan();
//        myFan.setWidth(300);
//        myFan.setNumOfFans(20);
//        MyCustomRect rect=new MyCustomRect();
//        rect.setHeight(200);
        MyCustomAdvacedRect rect=new MyCustomAdvacedRect ();
        rect.setColors(Color.AQUA, Color.AQUA, Color.AZURE, Color.AZURE);
        rect.setWidth(100);
        rect.setHeight(200);

        pane.getChildren().add(rect);
        Scene scene=new Scene(pane,400,400);
        primaryPage.setScene(scene);
        primaryPage.setTitle("Detyra e par ne javen e 2 grupi i 2");
        primaryPage.show();


    }


    public static void main(String[] args){
        launch(args);
    }

}


class MyCustomAdvacedRect extends Pane{

    private Color color1=Color.RED;
    private Color color2=Color.GREEN;
    private Color color3=Color.BLUE;
    private Color color4=Color.DARKMAGENTA;

    private void draw(){
        Rectangle rect=new Rectangle(10,10,super.getWidth(),super.getHeight());
        rect.setFill(null);

        Polygon trek1, trek2, trek3, trek4;
        double x0, x1, x2, x3, x4;
        double y0, y1, y2, y3, y4;
        x0 = rect.getX();
        y0 = rect.getY();
        x1 = rect.getX() + super.getWidth();
        y1 = y0;
        x2 = x1;
        y2 = y1 + super.getHeight();
        x3 = x0;
        y3 = y2;
        x4 = x0 + super.getWidth() * 0.5;
        y4 = y0 + super.getHeight() *  0.5;

        trek1 = new Polygon(x0, y0, x4, y4, x1, y1);
        trek1.setFill(this.color1);

        trek2 = new Polygon(x1, y1, x4, y4, x2, y2);
        trek2.setFill(this.color2);

        trek3 = new Polygon(x2, y2, x4, y4, x3, y3);
        trek3.setFill(this.color3);

        trek4 = new Polygon(x3, y3, x4, y4, x0, y0);
        trek4.setFill(this.color4);

        super.getChildren().clear();
        super.getChildren().addAll(rect, trek1, trek2, trek3, trek4);
    }

    public void setWidth(double width) {
        super.setWidth(width);
        this.draw();
    }

    public void setHeight(double height) {
        super.setHeight(height);
        this.draw();
    }

    public void setColors(Color color1, Color color2,
                          Color color3, Color color4) {
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.color4 = color4;
        this.draw();
    }
}






class  MyCustomRect extends Pane{
    private void draw(){
        Rectangle rect=new Rectangle(10,10,super.getWidth(),super.getHeight());
        Line line1,line2;

        rect.setFill(null);
        rect.setStroke(Color.BLUE);
        rect.setStrokeWidth(2);

        double x10,y10,x11,y11;
        double x20,y20,x21,y21;

        x10=rect.getX();
        y10=rect.getY();
        x11=rect.getX()-super.getWidth();
        y11=rect.getY()-super.getHeight();

        x20=x10+super.getWidth();
        y20=y10;
        x21=x10;
        y21=y10-super.getHeight();

        line1=new Line(x10,y10,x11,y11);
        line2=new Line(x20,y20,x21,y21);

        super.getChildren().clear();
        super.getChildren().addAll(rect,line1,line2);

    }

    public void setWidth(double width){
        super.setWidth(width);
        this.draw();
    }

    public void setHeight(double height) {
        super.setHeight(height);
        this.draw();
    }

}


class MyCustomFan extends Pane{

    private int num=4;
    private void draw(){
        double x,y,r;
        double start,length;

        x=10+super.getWidth()*0.5;
        y=10+super.getHeight()*0.5;
        r=super.getWidth()*0.5;

        Circle circle=new Circle(x,y,r);
        circle.setFill(null);
        circle.setStroke(Color.GREEN);

        Group group=new Group();
        for(int i=0;i<this.num;i++){
            start=i*(360.0/this.num);
            length=180.0/this.num;
            Arc arc=new Arc(x,y,r-10,r-10,start,length);

            arc.setFill(new Color(Math.random(),Math.random(),Math.random(),0.5));
            arc.setStroke(new Color(Math.random(),Math.random(),Math.random(),0.7));
            arc.setStrokeWidth(3);
            arc.setType(ArcType.ROUND);
            group.getChildren().add(arc);
        }

        super.getChildren().clear();
        super.getChildren().addAll(circle,group);
    }

    public void  setWidth(double width){
        super.setWidth(width);
        super.setHeight(width);
        this.draw();
    }

    public void setNumOfFans(int num){
        this.num=num;
    }

}