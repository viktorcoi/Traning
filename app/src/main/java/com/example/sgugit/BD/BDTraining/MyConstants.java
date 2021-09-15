package com.example.sgugit.BD.BDTraining;

public class MyConstants {
    public static final String EDIT_STATE = "edit_state";
    public static final String LIST_TRAINING_INTENT = "list_training_intent";
    public static final String TABLE_NAME = "my_table";
    public static final String _ID = "_id";
    public static final String NAME = "name_trai";
    public static final String EXE = "name_exe";
    public static final String DATE = "tv_date";
    public static final String TIME = "tv_time";
    public static final String TIMER = "tv_timer";

    public static final String DB_NAME = "db_name.db";
    public static final int DB_VERSION = 3;
    public static final String[] TABLE_STRUCTURE = {
            "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY," + NAME + " TEXT," + EXE + " TEXT," + DATE + " TEXT," + TIME + " TEXT," + TIMER + " TEXT)",
            "CREATE TABLE IF NOT EXISTS training_cell (_id INTEGER PRIMARY KEY, name TEXT, content TEXT)",
            "CREATE TABLE IF NOT EXISTS training_cell_value (_id INTEGER PRIMARY KEY, left TEXT, right TEXT)"
    };

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
}

