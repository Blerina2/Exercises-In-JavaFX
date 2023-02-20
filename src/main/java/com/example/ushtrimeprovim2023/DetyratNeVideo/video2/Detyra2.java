package com.example.ushtrimeprovim2023.DetyratNeVideo.video2;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

//INFO SE UNE FOTOT SI KOM SAKT I KOM SHUM TE MDHAJA AMO QESHTU BOHET VEQ FOTOT MA TE VOGLA
public class Detyra2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        BorderPane borderPane=new BorderPane();
        borderPane.setTop(getTopContent());
        borderPane.setLeft(getLeftContent());
        borderPane.setCenter(getCenterContent());
        borderPane.setRight(getRightContent());

        Scene scene=new Scene(borderPane,1250,800);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public Node getTopContent(){
        HBox hBox=new HBox();
        hBox.setStyle("-fx-background-color: #336699");
        hBox.setSpacing(15);
        hBox.setPadding(new Insets(15));

        Button currentButton=new Button("Current");
        Button projectButton=new Button("Projected");
        currentButton.setPrefSize(100,30);
        projectButton.setPrefSize(100,30);

        Node icon=getHelpIcon();
        hBox.getChildren().addAll(currentButton,projectButton,icon);
        HBox.setHgrow(icon, Priority.ALWAYS);



        return hBox;
    }

    public Node getHelpIcon(){
        StackPane stackPane=new StackPane();
        Rectangle rectangle=new Rectangle();
        rectangle.setHeight(40);
        rectangle.setWidth(40);

        rectangle.setFill(
                new LinearGradient(0,0,0,1,true, CycleMethod.NO_CYCLE,
                        new Stop[]{
                                new Stop(0, Color.valueOf("#4977A3")),
                                new Stop(0.5,Color.valueOf("#B0C6DA")),
                                new Stop(1,Color.valueOf("9CB6CF"))
                        }
                ));


        Text text=new Text("?");
        text.setFont(Font.font("Arial", FontWeight.BOLD,20));
        text.setFill(Color.WHITE);
        text.setStroke(Color.BLACK);


        stackPane.getChildren().addAll(rectangle,text);
        stackPane.setAlignment(Pos.CENTER_RIGHT);
        StackPane.setMargin(text,new Insets(0,13.5,0,0));
        return stackPane;
    }

    public Node getLeftContent(){
        VBox vBox=new VBox();
        vBox.setPadding(new Insets(15));
        vBox.setSpacing(15);

        Text heading=new Text("Data");
        heading.setFont(Font.font("Arial",FontWeight.BOLD,16));

        vBox.getChildren().add(heading);



        for(String item: new String[]{"Sales","Marketing","Distribution","Costs"}){
            Text text=new Text(item);
            vBox.getChildren().add(text);
            VBox.setMargin(text,new Insets(0,0,0,15));
        }

        return vBox;

    }

    public Node getCenterContent() throws MalformedURLException {
        GridPane gridPane=new GridPane();
        gridPane.setPadding(new Insets(15));
        gridPane.setVgap(15);
        gridPane.setHgap(15);


        ImageView houseimg=new ImageView(resolvePath("src/main/java/com/example/ushtrimeprovim2023/DetyratNeVideo/video2/graphs/House.jpg"));
        gridPane.add(houseimg,0,0,1,2);

        Text sales=new Text("Sales:Current Year");
        sales.setFont(Font.font("Arial",FontWeight.BOLD,22));
        gridPane.add(sales,1,0,2,1);

        Text goodsServices=new Text("Goods and Services");
        gridPane.add(goodsServices,1,1);


        ImageView chart=new ImageView(resolvePath("src/main/java/com/example/ushtrimeprovim2023/DetyratNeVideo/video2/graphs/piechartarticle-1.jpg"));
        gridPane.add(chart,1,2,2,2);


        Text goods=new Text("Gods \n 80%");
        gridPane.add(goods,0,3);

        Text services=new Text("Services \n 20%");
        gridPane.add(services,3,2);
        GridPane.setHalignment(services, HPos.RIGHT);
        GridPane.setValignment(services, VPos.BOTTOM);


        HBox hBox=new HBox();
        hBox.setPadding(new Insets(15));
        Button save=new Button("Save");
        Button cancel=new Button("Cancle");
        hBox.setAlignment(Pos.CENTER_RIGHT);
        hBox.getChildren().addAll(save,cancel);

        AnchorPane anchorPane=new AnchorPane();
        anchorPane.getChildren().addAll(gridPane,hBox);
        AnchorPane.setTopAnchor(gridPane,0.0);
        AnchorPane.setLeftAnchor(gridPane,0.0);
        AnchorPane.setBottomAnchor(hBox,0.0);
        AnchorPane.setRightAnchor(hBox,0.0);

        return anchorPane;

    }


    public Node getRightContent(){
        FlowPane flowPane=new FlowPane();
        flowPane.setPadding(new Insets(10,10,10,5));
        flowPane.setHgap(15);
        flowPane.setVgap(15);
        flowPane.setPrefWidth(190);
        flowPane.setStyle("-fx-background-color:#DAE6F3;");
        for (int i=0;i<=8;i++){
            ImageView img=new ImageView(resolvePath("src/main/java/com/example/ushtrimeprovim2023/DetyratNeVideo/video2/graphs/chart_"+i+".png"));
            flowPane.getChildren().add(img);

        }

        return flowPane;
    }

    public static String resolvePath(String path){
        return  new File(path).toURI().toString();
    }


    public static void main(String args[]){
        launch(args);
    }

}
