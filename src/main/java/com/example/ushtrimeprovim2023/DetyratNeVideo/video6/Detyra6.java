package com.example.ushtrimeprovim2023.DetyratNeVideo.video6;

import com.example.ushtrimeprovim2023.DetyratNeVideo.video6.model.data.Person;
import com.example.ushtrimeprovim2023.DetyratNeVideo.video6.stage.EditPersonStage;
import com.example.ushtrimeprovim2023.DetyratNeVideo.video6.stage.ListPersonStage;
import com.example.ushtrimeprovim2023.DetyratNeVideo.video6.util.StageConstants;
import com.example.ushtrimeprovim2023.DetyratNeVideo.video6.util.StageManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Detyra6 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ArrayList<Person>items=new ArrayList<>(
                List.of(new Person("Person 1",22),
                        new Person("Person 2",23),
                        new Person("Person 3",21),
                        new Person("Person 4",22),
                        new Person("Person 5",23),
                        new Person("Person 6",22)
                )
        );
            Stage listPersonStage=new ListPersonStage(items);

        StageManager sm=StageManager.getInstance();
      //  sm.add(StageConstants.LIST_PERSON_STAGE,  listPersonStage);
        sm.gotoStage(StageConstants.LIST_PERSON_STAGE);


    }



    public static void main(String[] args){
        launch(args);
    }

}
