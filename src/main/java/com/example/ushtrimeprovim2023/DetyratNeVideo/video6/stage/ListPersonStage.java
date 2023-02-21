package com.example.ushtrimeprovim2023.DetyratNeVideo.video6.stage;

import com.example.ushtrimeprovim2023.DetyratNeVideo.video6.model.data.Person;
import com.example.ushtrimeprovim2023.DetyratNeVideo.video6.util.StageConstants;
import com.example.ushtrimeprovim2023.DetyratNeVideo.video6.util.StageManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ListPersonStage extends Stage {
    private ArrayList<Person>items;
    private ListView<String>listView;
    private Button viewButton;

    public ListPersonStage(ArrayList<Person>items) {
        this.items=items;

        Scene scene=new Scene(this.getLayout(),800,600);
        this.setScene(scene);
        this.bindFunctionality();
    }

    private Pane getLayout(){
        this.viewButton=new Button("View Person");

        this.listView=new ListView<>();
        ObservableList<String>listItems= FXCollections.observableArrayList();
        for(Person item:this.items){
            listItems.add(item.name);
        }
        listView.setItems(listItems);

        VBox vBox=new VBox(15);
        vBox.setPadding(new Insets(15));

        vBox.getChildren().addAll(listView,viewButton);

        return vBox;
    }

    private void bindFunctionality(){
        this.viewButton.setOnAction(e ->{
            try {
                Person p = getSelectedItem();
                if (p == null) return;

                openEditPersonStage(p);
            }catch (Exception ex){
                ex.printStackTrace();
            }
            });

    }

    private void  openEditPersonStage(Person p) throws Exception {
        StageManager sm=StageManager.getInstance();

        if(sm.exists(StageConstants.EDIT_PERSON_STAGE)){
            EditPersonStage stage=(EditPersonStage) sm.get(StageConstants.EDIT_PERSON_STAGE);
            stage.updateViewModel(p);

        }else {
            EditPersonStage stage=new EditPersonStage(p);
            sm.add(StageConstants.EDIT_PERSON_STAGE,stage);
        }

        sm.gotoStage(StageConstants.EDIT_PERSON_STAGE);
    }

    public Person getSelectedItem(){
        int index=this.listView.getSelectionModel().getSelectedIndex();
        if(index<0) return null;
    return this.items.get(index);
    }

    public void updateSelectedItem(Person model){

    }


}
