package com.example.ushtrimeprovim2023.DetyratNeVideo.video6.util;

import com.example.ushtrimeprovim2023.DetyratNeVideo.video6.stage.EditPersonStage;
import javafx.stage.Stage;

import java.util.HashMap;

public class StageManager {
    private static StageManager instance;
    private HashMap<String, Stage> stages;
    private Stage activeStage;

    private StageManager(){
        this.stages=new HashMap<>();
    }

    public static StageManager getInstance(){
        if(instance==null){
            instance=new StageManager();
        }
        return instance;
    }

    public boolean exists(String key){
        return stages.containsKey(key);
    }

    public void add(String key, EditPersonStage value) throws Exception{
        if(exists(key))throw new Exception("ERR_KEY_EXISTES");
        stages.put(key,value);
    }

    public void remove(String key) throws Exception{
      Stage stage=get(key);
      stage.close();
        stages.remove(key);
    }

    public void clear(){
        stages.forEach((key,stage)->{
                stage.hide();
    });
        stages.clear();
    }

 public Stage get(String key) throws Exception{
        if(!exists(key))throw new Exception("ERR_KEY_NOT_FOUND");
        return stages.get(key);
    }


    public Stage getActiveStage(){
        return activeStage;
    }

    public void gotoStage(String key) throws Exception{
        Stage prevStage=getActiveStage();
        activeStage=get(key);
        if(prevStage !=null)prevStage.hide();
        activeStage.show();

    }


}
