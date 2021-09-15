package com.example.sgugit.BD.BDMeasurements;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper2 extends SQLiteOpenHelper {
    public MyDBHelper2(@Nullable Context context) {
        super(context, MyConstants2.DB_NAME, null, MyConstants2.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MyConstants2.TABLE_STRUCTURE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(MyConstants2.DROP_TABLE);
        onCreate(db);
    }

}
