package com.example.sgugit.BD.BDTraining;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import androidx.core.util.Pair;

import com.example.sgugit.AdapterRV.ListTraining;
import com.example.sgugit.AdapterRV.ModelTraining;

import java.util.ArrayList;
import java.util.List;

public class MyDBManager {
    private Context context;
    private MyDBHelper myDBHelper;
    private SQLiteDatabase db;
    private Cursor cursor;

    public MyDBManager(Context context) {
        this.context = context;
        myDBHelper = new MyDBHelper(context);
    }
    public void openDb(){
        if (db != null)
            return;

        db = myDBHelper.getWritableDatabase();
    }

    public void InsertTrainingInstance(String str_TrainingName, String str_Date, String str_Time, String str_Timer, List<ModelTraining> training)
    {
        openDb();
        ContentValues cv = new ContentValues();
        cv.put(MyConstants.NAME, str_TrainingName);
        cv.put(MyConstants.DATE, str_Date);
        cv.put(MyConstants.TIME, str_Time);
        cv.put(MyConstants.TIMER, str_Timer);
        String insert_val = "";

        for (ModelTraining item:
             training) {

            String ret = InsertTraining(item);

            if (ret == null)
                continue;

            insert_val += ret + " ";
        }

        cv.put(MyConstants.EXE, insert_val);
        db.insert(MyConstants.TABLE_NAME, null, cv);
    }

    public String InsertTraining(ModelTraining item)
    {
        ContentValues cv = new ContentValues();
        String[] cell_ret = InsertTrainingCells(item.GetContent());

        if (cell_ret.length < 1)
            return null;

        cv.put("name", item.GetExerciseName());
        cv.put("content", TextUtils.join(" ", cell_ret));

        return Long.toString(db.insert("training_cell", null, cv));
    }

    public String[] InsertTrainingCells(List<Pair<String, String>> cell)
    {
        List<String> ret = new ArrayList<>();
        ContentValues cv = new ContentValues();

        if (cell.size() < 1)
            return new String[]{};


        for (Pair<String, String> item:
                cell) {
            cv.clear();
            cv.put("left", item.first);
            cv.put("right", item.second);
            ret.add(Long.toString(db.insert("training_cell_value", null, cv)));
        }

        return ret.toArray(new String[0]);
    }

    public void delete(int id){
        String selection = MyConstants._ID + "=" + id;
        db.delete(MyConstants.TABLE_NAME, selection, null);
    }

    public String GetExerciseName(String ID)
    {
        if (ID.equals("-1"))
            return "BAD_ID_ERROR";

        openDb();

        Cursor cursor = db.query("training_cell", null, "_id="+ID, null, null, null, null);

        if (cursor.getCount() < 1 || cursor.getColumnCount() < 1)
            return "NO_RECORDS_FOUND";

        cursor.moveToPosition(0);
        return cursor.getString(1); // "name" column;
    }

    public Pair<String, String> GetExerciseContent(String ID)
    {
        if (ID.equals("-1"))
            return new Pair<String, String>("BAD_ID_ERROR", "BAD_ID_ERROR");

        openDb();

        Cursor cursor = db.query("training_cell_value", null, "_id="+ID, null, null, null, null);

        if (cursor.getCount() < 1 || cursor.getColumnCount() < 1)
            return new Pair<String, String>("NO_RECORD_FOUND", "NO_RECORD_FOUND");

        cursor.moveToPosition(0);
        return new Pair<String, String>(cursor.getString(1), cursor.getString(2)); // "left", "right" column;
    }

    public List<ListTraining> getFromDb(){
        openDb();
        List<ListTraining> tempList = new ArrayList<>();
        cursor = db.query(MyConstants.TABLE_NAME, null, null, null, null, null, null);

        while (cursor.moveToNext()){
            ListTraining item = new ListTraining();

            item.ID = cursor.getInt(0);
            item.Name = cursor.getString(1);
            String str_ExerciseIDs = cursor.getString(2);
            item.Date = cursor.getString(3);
            item.Time = cursor.getString(4);
            item.Timer = cursor.getString(5);

            if (item.AppendExercises(str_ExerciseIDs) < 1)
                continue;

            for (String exerciseID:
                 item.GetExercises()) {
                if (exerciseID.equals("-1"))
                    continue;

                Cursor test = db.query("training_cell", null, "_id=" + exerciseID, null, null, null, null);
                if (test.getCount() < 1 || test.getColumnCount() < 1)
                    break;

                test.moveToPosition(0);
                item.AppendExerciseContent(exerciseID, test.getString(2));
            }
            tempList.add(item);
        }
        cursor.close();
        return tempList;
    }
    public void closeDb(){
        myDBHelper.close();
        db = null;
    }
}
