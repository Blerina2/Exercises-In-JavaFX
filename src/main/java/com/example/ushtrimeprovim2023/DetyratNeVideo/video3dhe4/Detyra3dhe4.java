package com.example.ushtrimeprovim2023.DetyratNeVideo.video3dhe4;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Date;

public class Detyra3dhe4 extends Application {

    private TextField emailField;
    private PasswordField passwordField;

    //Menyr e vjeter nuk perdoret mo
//    class clearButtonListener implements EventHandler<ActionEvent> {
//        @Override
//        public void handle(ActionEvent actionEvent){
//            Button x=(Button) actionEvent.getSource();
//            clearFields();
//        }
//    }

    @Override
    public void start(Stage primaryStage)throws Exception{
        TabPane pane=new TabPane();
        pane.setMinSize(800,600);

        Tab logintab=new Tab("Login",getloginTab());
        Tab singuptab=new Tab("SingUp",getSignupTab());
        logintab.setClosable(false);
        singuptab.setClosable(false);

        pane.getTabs().addAll(logintab,singuptab);
        pane.getSelectionModel().select(singuptab);

        Scene scene=new Scene(pane,800,700);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public Node getloginTab(){

        GridPane pane=new GridPane();
        pane.setPadding(new Insets(15));
        pane.setVgap(15);
        pane.setHgap(15);

        Label email=new Label("Email");
        emailField=new TextField();

        Label password=new Label("Password:");
        passwordField=new PasswordField();

        Button loingButton=new Button("Login");
        Button clear=new Button("Clear");
        loingButton.setPrefSize(100,20);
        loingButton.setStyle("-fx-background-color:darkslateblue;-fx-text-fill: white");
        clear.setPrefSize(100,20);
        clear.setStyle("-fx-background-color:darkslateblue;-fx-text-fill: white");


        pane.add(email,0,0);
        pane.add(emailField,1,0,2,1);
        pane.add(password,0,1);
        pane.add(passwordField,1,1,2,1);
        pane.add(loingButton,0,2);
        pane.add(clear,1,2);
        pane.setAlignment(Pos.CENTER);

        GridPane.setHgrow(emailField, Priority.ALWAYS);
        GridPane.setHgrow(passwordField,Priority.ALWAYS);

//        clear.setOnAction(new clearButtonListener());

        //Menyra e 2 qysh mundesh me thir
//        clear.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                clearFields();
//            }
//        });

        //Menyra ma e preferushme :
    clear.setOnAction(e->clearFields());
    loingButton.setOnAction(e -> {
        boolean result=login();
        Alert alert=new Alert((result ? Alert.AlertType.INFORMATION: Alert.AlertType.ERROR));

        alert.setTitle("Login");
        alert.setHeaderText("Login Result");
        alert.setContentText(String.format("Login %s",result? "is successful":"failed"));
        alert.showAndWait();
    });

        return pane;

    }

    public Node getSignupTab(){

        GridPane gridPane=new GridPane();
        gridPane.setPadding(new Insets(15));
        gridPane.setVgap(15);
        gridPane.setHgap(15);
        gridPane.setAlignment(Pos.CENTER);

        Label nameLabel=new Label("Name");
        TextField nameField=new TextField();
        gridPane.add(nameLabel,0,0);
        gridPane.add(nameField,1,0,2,1);
        Label emailLable=new Label("Email");
        TextField emailField=new TextField();
        gridPane.add(emailLable,0,1);
        gridPane.add(emailField,1,1,2,1);

        Label passwordLabel = new Label("Password");
        PasswordField passwordField1=new PasswordField();
        gridPane.add(passwordLabel,0,2);
        gridPane.add(passwordField1,1,2,2,1);


        Label passwordConfrimLabel = new Label("Confirm Password");
        PasswordField passwordConfirmField=new PasswordField();
        gridPane.add(passwordConfrimLabel,0,3);
        gridPane.add(passwordConfirmField,1,3,2,1);

        Label birthdayLable=new Label("Birthday");
        DatePicker birthdayPicker=new DatePicker();
        gridPane.add(birthdayLable,0,4);
        gridPane.add(birthdayPicker,1,4,2,1);

        Label genderLable=new Label("Gender");
        RadioButton femaleButton=new RadioButton("Famale");
        RadioButton maleButton=new RadioButton("Male");
        gridPane.add(genderLable,0,5);
        gridPane.add(new HBox(15,femaleButton,maleButton),1,5,2,1);
        ToggleGroup genderGroup=new ToggleGroup();
        femaleButton.setToggleGroup(genderGroup);
        maleButton.setToggleGroup(genderGroup);

        Label workingLable=new Label("Working");
        ToggleButton workingYesButton=new ToggleButton("Yes");
        ToggleButton workingNoButton=new ToggleButton("No");
        gridPane.add(workingLable,0,6);
        gridPane.add(new HBox(15,workingYesButton,workingNoButton),1,6,2,1);
        ToggleGroup workingGroup=new ToggleGroup();
        workingYesButton.setToggleGroup(workingGroup);
        workingNoButton.setToggleGroup(workingGroup);

        Label knownLangLable=new Label("Known Lnaguages");
        CheckBox javacheckbox=new CheckBox("Java");
        CheckBox cppcheckbox=new CheckBox("C++");
        CheckBox csharpcheckbox=new CheckBox("C#");
        gridPane.add(knownLangLable,0,7);
        gridPane.add(new HBox(15,javacheckbox,cppcheckbox,csharpcheckbox),1,7,2,1);

        Label educationLable=new Label("Education");
        ListView<String>educationListView=new ListView<>();
        educationListView.getItems().addAll(
                FXCollections.observableArrayList("High School","Bachlor","Master","PHD")
        );
        educationListView.setPrefHeight(100);
        educationListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        gridPane.add(educationLable,0,8);
        gridPane.add(educationListView,1,8,2,1);

        Label loctionLabel=new Label("Location");
        ComboBox<String>locationCombobox=new ComboBox<>(
                FXCollections.observableArrayList("London","Paris","Peja")
        );
        gridPane.add(loctionLabel,0,9);
        gridPane.add(locationCombobox,1,9,2,1);

        Button registerButton=new Button("Register");
        registerButton.setPrefSize(100,20);
        registerButton.setStyle("-fx-background-color: purple;-fx-text-fill: white");
        gridPane.add(registerButton,1,10,2,1);
        GridPane.setHalignment(registerButton, HPos.RIGHT);


        registerButton.setOnAction(e->{
            boolean result=false;
            try {
                String name=nameField.getText();
                String email=emailField.getText();
                String password=passwordField1.getText();
                String passwordconfirm=passwordConfirmField.getText();
                Date birthdate=new Date(birthdayPicker.getValue().toEpochDay());
                Character gender=null;
                if(femaleButton.isSelected()) gender='F';
                if(maleButton.isSelected()) gender='M';

                Character working=null;
                if(workingYesButton.isSelected()) working='Y';
                if(workingNoButton.isSelected()) working='N';

                ArrayList<String>languages=new ArrayList<>();
                if (javacheckbox.isSelected()) languages.add("Java");
                if (cppcheckbox.isSelected()) languages.add("C++");
                if (csharpcheckbox.isSelected()) languages.add("C#");

                String education=educationListView.getSelectionModel().getSelectedItem();
                String location=locationCombobox.getSelectionModel().getSelectedItem();

                result=register(name,email,password,passwordconfirm,birthdate,gender,working,languages,education,location);


            }catch (Exception ex){
                System.err.println(ex.getMessage());
            }

            Alert alert=new Alert(result? Alert.AlertType.INFORMATION: Alert.AlertType.ERROR);
            alert.setContentText(result ? "Succesfull registration":"Registration failed");
            alert.showAndWait();
        });


        return gridPane;
    }

    public boolean register(String name, String email, String password, String passwordconfirm,
                            Date birthday, Character gender, Character working, ArrayList<String>knownlangueges,
                            String education,String location){

        if(name==null ||name.isBlank() || name.isEmpty() ) return false;
        if(email==null || email.isBlank() || email.isEmpty() ) return false;
        if(password==null || password.isBlank() || password.isEmpty() ) return false;
        if(passwordconfirm==null || passwordconfirm.isBlank() || passwordconfirm.isEmpty() ) return false;
        if(birthday==null) return false;
        if(gender==null || (gender.charValue() !='F' && gender.charValue()!='M')) return false;
        if(working==null || (working !='Y' && working!='N')) return false;
        if(knownlangueges==null || (knownlangueges.size()==0)) return false;
        if(education==null ||education.isBlank() || education.isEmpty()) return false;
        if(location==null ||location.isBlank() || location.isEmpty()) return false;

        return true;
    }



    public void clearFields(){
        emailField.clear();
        passwordField.clear();

    }


    protected boolean login(){
        return emailField.getText().equals("email@test.com") && passwordField.getText().equals("123456");
    }


    public static void main(String[] args){
        launch(args);
    }

}
