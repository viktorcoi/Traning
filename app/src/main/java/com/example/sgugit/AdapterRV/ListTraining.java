package com.example.sgugit.AdapterRV;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;

public class ListTraining implements Serializable {
    public String Name;
    public String Date;
    public String Time;
    public String Timer;
    private String[] ExerciseIDs;
    private HashMap<String, String[]> ExerciseContent = new HashMap<>();
    public int ID = -1;

    public int AppendExercises(String id_list) {
        ExerciseIDs = id_list.split("\\s+");
        return ExerciseIDs.length;
    }

    public void AppendExerciseContent(String ID, String id_list) {
        if (GetExerciseID(ID) == -1)
            return;

        ExerciseContent.put(ID, id_list.split("\\s+"));
    }

    public String[] GetExerciseContent(String ID) {
        int id = GetExerciseID(ID);
        if (id == -1)
            return new String[0];

        return ExerciseContent.get(ID);
    }

    public String GetExerciseByID(int ID) {
        return ExerciseIDs == null ? null : ID >= ExerciseIDs.length ? null : ExerciseIDs[ID];
    }

    public String[] GetExercises() {
        return ExerciseIDs;
    }

    public int GetExerciseID(String ID) {
        return Arrays.asList(ExerciseIDs).indexOf(ID);
    }
}
