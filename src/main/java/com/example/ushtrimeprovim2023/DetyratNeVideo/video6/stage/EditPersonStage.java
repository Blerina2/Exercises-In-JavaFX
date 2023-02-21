package com.example.ushtrimeprovim2023.DetyratNeVideo.video6.stage;

import com.example.ushtrimeprovim2023.DetyratNeVideo.video6.model.data.Person;
import com.example.ushtrimeprovim2023.DetyratNeVideo.video6.util.StageConstants;
import com.example.ushtrimeprovim2023.DetyratNeVideo.video6.util.StageManager;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EditPersonStage extends Stage {
    private Label nameLabel;
    private Label ageLabel;
    private TextField nameField;
    private TextField ageField;
    private Button saveButton;

    public EditPersonStage(Person person){
        Scene scene = new Scene(this.getLayout());
        this.setScene(scene);


    }

    private Pane getLayout(){
        this.nameLabel=new Label("Name");
        this.nameField=new TextField();

        this.ageLabel=new Label("Age");
        this.ageField=new TextField();

        this.saveButton=new Button("Save");

        GridPane pane=new GridPane();
        pane.setVgap(15);
        pane.setHgap(15);
        pane.setPadding(new Insets(15));
        pane.setAlignment(Pos.CENTER);

        pane.add(nameLabel,0,0);
        pane.add(nameField,1,0,2,1);

        pane.add(ageLabel,0,1);
        pane.add(ageField,1,1,2,1);

        pane.add(saveButton,1,2,2,1);
        GridPane.setHalignment(saveButton, HPos.RIGHT);

        return pane;

    }

    private void bindFunctionality(){

        this.saveButton.setOnAction(e->{
            try {
            closesSatge(true);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });

    }

    private void closesSatge(boolean update) throws Exception{

        StageManager sm= StageManager.getInstance();
        sm.gotoStage(StageConstants.LIST_PERSON_STAGE);
    }

    public void updateViewModel(Person person){

    }

    public Person getPerson(){
        return null;
    }


}
