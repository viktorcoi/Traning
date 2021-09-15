package com.example.sgugit.BD.BDMeasurements;

public class MyConstants2 {
    public static final String EDIT_STATE = "edit_state";
    public static final String LIST_MEAS_INTENT = "list_meas_intent";
    public static final String TABLE_NAME = "my_table2";
    public static final String _ID = "_id";
    public static final String TITTLE = "tittle";
    public static final String ROST = "rost";
    public static final String VES = "ves";
    public static final String JIR = "jir";
    public static final String SHEA = "shea";
    public static final String PLECHI = "plechi";
    public static final String GRUD = "grud";
    public static final String LB = "lb";
    public static final String PB = "pb";
    public static final String LP = "lp";
    public static final String PP = "pp";
    public static final String TALIA = "talia";
    public static final String TAZ = "taz";
    public static final String LBED = "lbed";
    public static final String PBED = "pbed";
    public static final String LG = "lg";
    public static final String PG = "pg";


    public static final String DB_NAME = "db_name2.db";
    public static final int DB_VERSION = 3;
    public static final String TABLE_STRUCTURE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + _ID + " INTEGER PRIMARY KEY," + TITTLE + " TEXT," + ROST + " TEXT," + VES + " TEXT," + JIR + " Text," + SHEA + " TEXT," + PLECHI + " TEXT," + GRUD + " Text," + LB + " TEXT," + PB + " Text," + LP + " TEXT," + PP + " TEXT," + TALIA + " TEXT," + TAZ + " TEXT," + LBED + " TEXT," + PBED + " TEXT," + LG + " TEXT," + PG + " Text)";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
}
