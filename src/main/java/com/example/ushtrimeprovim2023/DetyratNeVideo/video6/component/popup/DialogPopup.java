package com.example.ushtrimeprovim2023.DetyratNeVideo.video6.component.popup;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DialogPopup {
    public static void show(String title,String question){
        VBox vBox=new VBox(15);
        vBox.setPadding(new Insets(15));
        vBox.setAlignment(Pos.CENTER);

        Label questionLabel=new Label(question);

        HBox buttonsBox=new HBox(15);
        buttonsBox.setAlignment(Pos.BASELINE_CENTER);
        Button yesButton=new Button("Yes");
        Button noButton=new Button("No");
        buttonsBox.getChildren().addAll(yesButton,noButton);

        vBox.getChildren().addAll(questionLabel,buttonsBox);
        vBox.setMaxWidth(500);
    }


}
