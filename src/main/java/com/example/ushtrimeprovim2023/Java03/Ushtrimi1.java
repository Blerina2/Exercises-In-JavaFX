package com.example.ushtrimeprovim2023.Java03;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class Ushtrimi1 extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        CreateUserForm userForm = new CreateUserForm();

        Scene scene = new Scene(userForm, 850, 760);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Detyra e pare ne javen e trete!");
        primaryStage.show();

    }


    public static void main (String[] args){
        launch(args);
    }

    class CreateUserForm extends GridPane{
        private  UserRepository userRepository = new UserRepository();

        private TextField txtEmri;
        private TextField txtmbiemri;
        private ToggleGroup gender;
        private CheckBox pranoniKushtet;

        private void load() throws FileNotFoundException{
            FileInputStream input=new FileInputStream("com/example/ushtrimeprovim2023/Java03/unipr.png");
            Image image=new Image(input);
            ImageView imageView=new ImageView(image);
            imageView.setFitHeight(150);
            imageView.setFitWidth(200);

            Label labelemri=new Label("Emri:");
            this.txtEmri=new TextField();
            this.txtEmri.setPromptText("Shkruani emrin...");

            Label labelmbiemri=new Label("Mbiemri:");
            this.txtmbiemri=new TextField();
            this.txtmbiemri.setPromptText("Shkruani mbiemrin...");

            this.gender=new ToggleGroup();
            RadioButton female=new RadioButton("Female");
            female.setToggleGroup(this.gender);
            RadioButton male=new RadioButton("Male");
            male.setToggleGroup(this.gender);
            RadioButton undefined=new RadioButton("Undefined");
            undefined.setToggleGroup(this.gender);
            HBox genderPane=new HBox();
            genderPane.getChildren().addAll(male,female,undefined);
            genderPane.setSpacing(2.5);


            pranoniKushtet =new CheckBox("A pranoni kushtet e vendosura?");
            Button submit=new Button("Submit");
            submit.setOnAction(e->{
                this.submitAction();
            });


            Button cancle=new Button("Cancel");
            cancle.setOnAction(e->{
                this.cancelAction();
            });

            HBox buttonPane=new HBox();
            buttonPane.getChildren().addAll(submit,cancle);
            buttonPane.setSpacing(10);

            super.getChildren().clear();
            super.add(imageView, 1, 0);
            super.add(labelemri, 0, 1);
            super.add(txtEmri, 1, 1);
            super.add(labelmbiemri, 0, 2);
            super.add(txtmbiemri, 1, 2);
            super.add(genderPane, 1, 3);
            super.add(pranoniKushtet, 1, 4);
            super.add(buttonPane, 1, 6);
            super.setAlignment(Pos.CENTER);
            super.setVgap(10);
            super.setHgap(10);

        }

        public CreateUserForm() throws FileNotFoundException {
            super();
            this.load();
        }

        private void submitAction() {
            String emri = this.txtEmri.getText();
            String mbiemri = this.txtmbiemri.getText();
            RadioButton genderSelected =(RadioButton)this.gender.getSelectedToggle();
            String gender = genderSelected.getText();
            boolean kushtet = this.pranoniKushtet.isSelected();

            User user = new User(emri, mbiemri, gender, kushtet);
            user = this.userRepository.create(user);
            if(user == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR,
                        "Perdoruesi nuk eshte krijuar me sukses!",
                        ButtonType.OK);
                alert.showAndWait();
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION,
                        "Perdoruesi eshte krijuar me sukses!",
                        ButtonType.OK);
                alert.showAndWait();
            }

            this.cancelAction();

        }

        private void cancelAction() {
            this.txtEmri.setText("");
            this.txtmbiemri.setText("");
            this.gender.selectToggle(null);
            this.pranoniKushtet.setSelected(false);
        }

    }

    class User {
        private String emri;
        private String mbiemri;
        private String gender;
        private boolean kushtet;

        public User fromValues(String emri, String mbiemri, String gender, boolean kushtet) {
            // static validime ...
            return new User(emri, mbiemri, gender, kushtet);
        }

        private User(String emri, String mbiemri, String gender, boolean kushtet) {
            this.emri = emri;
            this.mbiemri = mbiemri;
            this.gender = gender;
            this.kushtet = kushtet;
        }

        public String getEmri() {
            return this.emri;
        }

        public String getMbiemri() {
            return this.mbiemri;
        }

        public String getGender() {
            return this.gender;
        }

        public boolean getKushtet() {
            return this.kushtet;
        }
    }

    class UserRepository {

        public User create(User user) {
            // lidhja me DB
            // ruajtja e user ne table user
            return user;
        }

        public User update(User user) {
            // lidhja me DB
            // perditesimi i te dhenave
            return user;
        }

        public List<User> findAll(){
            // lidhjen me db
            // select * from user;
            return null;
        }

    }

}
