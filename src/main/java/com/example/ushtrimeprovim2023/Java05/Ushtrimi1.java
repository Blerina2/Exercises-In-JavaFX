package com.example.ushtrimeprovim2023.Java05;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.nio.Buffer;

public class Ushtrimi1 extends Application {

    @Override
    public void start(Stage primaryStage)throws Exception{

        Pane pane = new Pane();
        Button btn = new Button("Click");
        btn.setOnAction(e -> {
            CreateStudentModal stModal = new CreateStudentModal();
        });
        pane.getChildren().add(btn);
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();


    }



    class CreateStudentModal extends GridPane{
        private Stage primaryStage;
        private Scene prevScene;
        private TextField emri;
        private TextField mbiemri;

        private void load(){
            Label emrilab=new Label("Emri:");
            this.emri=new TextField();
            this.emri.setPromptText("Type Firstname...");

            Label mbiemrilab=new Label("Mbiemri:");
            this.mbiemri=new TextField();
            this.mbiemri.setPromptText("Type Lastname...");

            Button submit=new Button("Submit");
            Button cancel=new Button("Cancel");


            submit.setOnAction(e -> {
                this.submitAction();
            });
            cancel.setOnAction(e -> {
                this.cancelAction();
            });

            HBox buttonPane = new HBox();
            buttonPane.setSpacing(10);
            buttonPane.setAlignment(Pos.CENTER);
            buttonPane.getChildren().addAll(submit, cancel);

            super.add(emrilab, 0, 1);
            super.add(emri, 1, 1);
            super.add(mbiemrilab, 0, 2);
            super.add(mbiemri, 1, 2);
            super.add(buttonPane, 0, 3, 2, 1);
            super.setAlignment(Pos.CENTER);
            super.setVgap(5);
            super.setHgap(5);


            Scene scene = new Scene(this, 500, 500);

            this.primaryStage.setScene(scene);
            this.primaryStage.setTitle("Create Student");
            this.primaryStage.show();


        }


        private void submitAction() {

        }

        private void cancelAction() {
            this.primaryStage.close();
        }

        public CreateStudentModal() {
            this.primaryStage = new Stage();
            this.load();
        }
    }


    class Student {
        private int id;
        private String emri;
        private String mbiemri;

        public Student getInstance(int id, String emri, String mbiemri) {
            return new Student(id, emri, mbiemri);
        }

        private Student(int id, String emri, String mbiemri) {
            this.id = id;
            this.emri = emri;
            this.mbiemri = mbiemri;
        }
    }

    class StudentRepository {
        //TODO:
    }


    public static void main(String[] args){
        launch(args);
    }




}
