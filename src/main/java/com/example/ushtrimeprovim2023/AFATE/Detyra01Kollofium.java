package com.example.ushtrimeprovim2023.AFATE;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Detyra01Kollofium extends Application {


    @Override
    public void start(Stage primaryStage)throws Exception{

    }


    class Detyra1 extends VBox{
        private int state=0;
        private Button next;
        private Button prev;
        private Button finish;

        public Detyra1(){
            this.state=0;
            this.next=new Button(">");
            this.next.setOnAction(e->this.nextClick());

            this.prev = new Button("<");
            this.prev.setOnAction(e -> this.prevClick());
            this.finish = new Button("Finish");
            this.finish.setOnAction(e -> this.finishClick());


        }

        private void load() {
            Pane loadForm;
            HBox pane;
            switch(this.state) {
                case 0:
                    loadForm = this.loadFirstView();
                    super.getChildren().clear();
                    super.getChildren().addAll(loadForm, this.next);
                    break;
                case 1:
                    loadForm = this.loadSecondView();
                    pane = new HBox();
                    pane.getChildren().addAll(this.prev, this.next);
                    super.getChildren().clear();
                    super.getChildren().addAll(loadForm, pane);
                    break;
                case 2:
                    loadForm = this.loadThirdView();
                    pane = new HBox();
                    pane.getChildren().addAll(this.prev, this.finish);
                    super.getChildren().clear();
                    super.getChildren().addAll(loadForm, pane);
                    break;
                default:
                    System.out.print("GABIM!");
            }
        }

        private Pane loadFirstView() {
            Label lblEmri = new Label("Emri: ");
            TextField txtEmri = new TextField();
            Pane pane = new Pane();
            pane.getChildren().addAll(lblEmri, txtEmri);
            return pane;
        }
        private Pane loadSecondView() {
            Label lblFakulteti = new Label("Fakulteti: ");
            TextField txtFakulteti = new TextField();
            Pane pane = new Pane();
            pane.getChildren().addAll(lblFakulteti, txtFakulteti);
            return pane;
        }
        private Pane loadThirdView() {
            Label lblFakulteti = new Label("Test");
            Pane pane = new Pane();
            pane.getChildren().addAll(lblFakulteti);
            return pane;
        }

        private void nextClick() {
            this.state += 1;
            this.load();
        }

        private void prevClick() {
            this.state -= 1;
            this.load();
        }

        private void finishClick() {
            //Finish click
        }
    }



    public static void main(String[] args){
        launch(args);
    }

}
