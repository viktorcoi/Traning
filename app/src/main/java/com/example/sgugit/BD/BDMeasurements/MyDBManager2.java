package com.example.sgugit.BD.BDMeasurements;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sgugit.AdapterRV.ListMeasurements;
import com.example.sgugit.BD.BDTraining.MyConstants;

import java.util.ArrayList;
import java.util.List;

public class MyDBManager2 {
    private Context context;
    private MyDBHelper2 myDBHelper2;
    private SQLiteDatabase db;
    private Cursor cursor;

    public MyDBManager2(Context context) {
        this.context = context;
        myDBHelper2 = new MyDBHelper2(context);
    }

    public void openDb() {
        db = myDBHelper2.getWritableDatabase();
    }

    public void insertToDb(String tittle, String rost, String ves, String jir, String shea, String plechi, String grud, String lb, String pb, String lp, String pp, String talia, String taz, String lbed, String pbed, String lg, String pg) {

        ContentValues cv = new ContentValues();
        cv.put(MyConstants2.TITTLE, tittle);
        cv.put(MyConstants2.ROST, rost);
        cv.put(MyConstants2.VES, ves);
        cv.put(MyConstants2.JIR, jir);
        cv.put(MyConstants2.SHEA, shea);
        cv.put(MyConstants2.PLECHI, plechi);
        cv.put(MyConstants2.GRUD, grud);
        cv.put(MyConstants2.LB, lb);
        cv.put(MyConstants2.PB, pb);
        cv.put(MyConstants2.LP, lp);
        cv.put(MyConstants2.PP, pp);
        cv.put(MyConstants2.TALIA, talia);
        cv.put(MyConstants2.TAZ, taz);
        cv.put(MyConstants2.LBED, lbed);
        cv.put(MyConstants2.PBED, pbed);
        cv.put(MyConstants2.LG, lg);
        cv.put(MyConstants2.PG, pg);
        db.insert(MyConstants2.TABLE_NAME, null, cv);
    }

    public void delete(int id){
        String selection = MyConstants2._ID + "=" + id;
        db.delete(MyConstants2.TABLE_NAME, selection, null);
    }

    public List<ListMeasurements> getFromDb() {
        List<ListMeasurements> tempList = new ArrayList<>();
        cursor = db.query(MyConstants2.TABLE_NAME, null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            ListMeasurements item = new ListMeasurements();
            String tittle = cursor.getString(cursor.getColumnIndex(MyConstants2.TITTLE));
            String rost = cursor.getString(cursor.getColumnIndex(MyConstants2.ROST));
            String ves = cursor.getString(cursor.getColumnIndex(MyConstants2.VES));
            String jir = cursor.getString(cursor.getColumnIndex(MyConstants2.JIR));
            String shea = cursor.getString(cursor.getColumnIndex(MyConstants2.SHEA));
            String plechi = cursor.getString(cursor.getColumnIndex(MyConstants2.PLECHI));
            String grud = cursor.getString(cursor.getColumnIndex(MyConstants2.GRUD));
            String lb = cursor.getString(cursor.getColumnIndex(MyConstants2.LB));
            String pb = cursor.getString(cursor.getColumnIndex(MyConstants2.PB));
            String lp = cursor.getString(cursor.getColumnIndex(MyConstants2.LP));
            String pp = cursor.getString(cursor.getColumnIndex(MyConstants2.PP));
            String talia = cursor.getString(cursor.getColumnIndex(MyConstants2.TALIA));
            String taz = cursor.getString(cursor.getColumnIndex(MyConstants2.TAZ));
            String lbed = cursor.getString(cursor.getColumnIndex(MyConstants2.LBED));
            String pbed = cursor.getString(cursor.getColumnIndex(MyConstants2.PBED));
            String lg = cursor.getString(cursor.getColumnIndex(MyConstants2.LG));
            String pg = cursor.getString(cursor.getColumnIndex(MyConstants2.PG));

            int id = cursor.getInt(cursor.getColumnIndex(MyConstants2._ID));

            item.setTittle(tittle);
            item.setRost(rost);
            item.setVes(ves);
            item.setJir(jir);
            item.setShea(shea);
            item.setPlechi(plechi);
            item.setGrud(grud);
            item.setLb(lb);
            item.setPb(pb);
            item.setLp(lp);
            item.setPp(pp);
            item.setTalia(talia);
            item.setTaz(taz);
            item.setLbed(lbed);
            item.setPbed(pbed);
            item.setLg(lg);
            item.setPg(pg);
            item.setId(id);
            tempList.add(item);
        }
        cursor.close();
        return tempList;
    }

    public void closeDb() {
        myDBHelper2.close();
    }
}
