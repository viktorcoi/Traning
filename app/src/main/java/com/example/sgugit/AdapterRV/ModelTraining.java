package com.example.sgugit.AdapterRV;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.util.Pair;

import com.example.sgugit.R;

import java.util.ArrayList;
import java.util.List;

public class ModelTraining {
    private RelativeLayout MainLayout;
    private LayoutInflater Inflater;

    private String ExerciseName = "";
    private List<Pair<String, String>> ExerciseValues = new ArrayList<>();


    public ModelTraining(Context context)
    {
        Inflater = LayoutInflater.from(context);
        MainLayout = (RelativeLayout) Inflater.inflate(R.layout.training_cell, null, false);
    }

    public RelativeLayout GetLayout()
    {
        return MainLayout;
    }

    public void SetExerciseName(String str_Name)
    {
        ExerciseName = str_Name;
        SetTextFromLayout(MainLayout, 0, str_Name);
    }

    public String GetExerciseName()
    {
        return ExerciseName;
    }

    public List<Pair<String, String>> GetContent()
    {
        return ExerciseValues;
    }

    public Boolean HasContent()
    {
        return ExerciseValues.size() > 0;
    }

    private void SetTextFromLayout(Object r_Layout, int i_ChildIndex, String str_Text)
    {
        ViewGroup lay = (ViewGroup) r_Layout;

        ((TextView)lay.getChildAt(i_ChildIndex)).setText(str_Text);
    }

    public void AppendExerciseCell(String left, String right)
    {
        LinearLayout CellArray = (LinearLayout) MainLayout.getChildAt(2);

        RelativeLayout layout_cell = (RelativeLayout) Inflater.inflate(R.layout.training_cell_add, null, false);

        ExerciseValues.add(new Pair<String, String>(left, right));
        SetTextFromLayout(layout_cell.findViewById(R.id.cellLayout), 0, left);
        SetTextFromLayout(layout_cell.findViewById(R.id.cellLayout), 1, right);

        CellArray.addView(layout_cell, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
    }
}
