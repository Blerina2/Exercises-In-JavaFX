package com.example.ushtrimeprovim2023.DetyratNeVideo.video5;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Detyra5 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BallPane ballPane = new BallPane();

        Scene scene = new Scene(ballPane, 150, 150);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ball movement");
        primaryStage.show();

       ballPane.requestFocus();
        ballPane.setOnMouseClicked(e->{
            if(ballPane.isPlaying()) ballPane.stop();
            else ballPane.play();
        });

        ballPane.setOnKeyPressed(e->{
            if(e.getCode()== KeyCode.UP){
                ballPane.incSpeed();
            }else if(e.getCode()==KeyCode.DOWN){
                ballPane.decSpeed();
            }

        });


        setTimeout(()->{
            Platform.runLater(()-> ballPane.play());
        },3000);
    }

    public void setTimeout(Runnable cb,long timeout){
        new Thread(()->{
            try {

                Thread.sleep(timeout);
                cb.run();

            }catch (Exception ex){
                ex.printStackTrace();
            }
        }).start();
    }



    public static void main(String[] args) {
        Application.launch(args);
    }

}