package com.example.sgugit;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sgugit.AdapterRV.RCAdapterCelOp;

public class CelebrityOp extends AppCompatActivity {

    Toolbar toolbar;
    private int id;
    String name[], left[], right[], op[];
    RecyclerView rc_choose;
    TypedArray img;
    private RCAdapterCelOp rcAdapterCelOp;

    public void setId(int id) {
      this.id = id;
    }

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.celebrity_op);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Тренировка");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        rc_choose = findViewById(R.id.rv_op);

        Intent i = getIntent();
        int position;
        int e_ID;
        position = i.getIntExtra("position", 0);
        e_ID = i.getIntExtra("id", 0);

        if (e_ID == 0 && position == 0) {
            name = getResources().getStringArray(R.array.training_A);
            img = getResources().obtainTypedArray(R.array.img_Arni_T1);
            left = getResources().getStringArray(R.array.training_A_left);
            right =getResources().getStringArray(R.array.training_A_right);
            op =getResources().getStringArray(R.array.training_A_op);
        }
        if (e_ID == 0 && position == 1) {
            name = getResources().getStringArray(R.array.training_A1);
            img = getResources().obtainTypedArray(R.array.img_Arni_T2);
            left = getResources().getStringArray(R.array.training_A_left1);
            right =getResources().getStringArray(R.array.training_A_right1);
            op =getResources().getStringArray(R.array.training_A_op1);
        }
        if (e_ID == 0 && position == 2) {
            name = getResources().getStringArray(R.array.training_A2);
            img = getResources().obtainTypedArray(R.array.img_Arni_T3);
            left = getResources().getStringArray(R.array.training_A_left2);
            right =getResources().getStringArray(R.array.training_A_right2);
            op =getResources().getStringArray(R.array.training_A_op2);
        }
        if (e_ID == 1 && position == 0) {
            name = getResources().getStringArray(R.array.training_S);
            img = getResources().obtainTypedArray(R.array.img_Sil_T1);
            left = getResources().getStringArray(R.array.training_S_left);
            right =getResources().getStringArray(R.array.training_S_right);
            op =getResources().getStringArray(R.array.training_S_op);
        }
        if (e_ID == 1 && position == 1) {
            name = getResources().getStringArray(R.array.training_S1);
            img = getResources().obtainTypedArray(R.array.img_Sil_T2);
            left = getResources().getStringArray(R.array.training_S_left1);
            right =getResources().getStringArray(R.array.training_S_right1);
            op =getResources().getStringArray(R.array.training_S_op1);
        }
        if (e_ID == 1 && position == 2) {
            name = getResources().getStringArray(R.array.training_S2);
            img = getResources().obtainTypedArray(R.array.img_Sil_T3);
            left = getResources().getStringArray(R.array.training_S_left2);
            right =getResources().getStringArray(R.array.training_S_right2);
            op =getResources().getStringArray(R.array.training_S_op2);
        }
        if (e_ID == 1 && position == 3) {
            name = getResources().getStringArray(R.array.training_S3);
            img = getResources().obtainTypedArray(R.array.img_Sil_T4);
            left = getResources().getStringArray(R.array.training_S_left3);
            right =getResources().getStringArray(R.array.training_S_right3);
            op =getResources().getStringArray(R.array.training_S_op3);
        }
        if (e_ID == 1 && position == 4) {
            name = getResources().getStringArray(R.array.training_S4);
            img = getResources().obtainTypedArray(R.array.img_Sil_T5);
            left = getResources().getStringArray(R.array.training_S_left4);
            right =getResources().getStringArray(R.array.training_S_right4);
            op =getResources().getStringArray(R.array.training_S_op4);
        }
        if (e_ID == 1 && position == 5) {
            name = getResources().getStringArray(R.array.training_S5);
            img = getResources().obtainTypedArray(R.array.img_Sil_T6);
            left = getResources().getStringArray(R.array.training_S_left5);
            right =getResources().getStringArray(R.array.training_S_right5);
            op =getResources().getStringArray(R.array.training_S_op5);
        }
        if (e_ID == 2 && position == 0) {
            name = getResources().getStringArray(R.array.training_V);
            img = getResources().obtainTypedArray(R.array.img_Vlad_0);
            left = getResources().getStringArray(R.array.training_V_left);
            right =getResources().getStringArray(R.array.training_V_right);
            op =getResources().getStringArray(R.array.training_V_op);
        }
        if (e_ID == 2 && position == 1) {
            name = getResources().getStringArray(R.array.training_V1);
            img = getResources().obtainTypedArray(R.array.img_Vlad_1);
            left = getResources().getStringArray(R.array.training_V_left1);
            right =getResources().getStringArray(R.array.training_V_right1);
            op =getResources().getStringArray(R.array.training_V_op1);
        }
        if (e_ID == 2 && position == 2) {
            name = getResources().getStringArray(R.array.training_V2);
            img = getResources().obtainTypedArray(R.array.img_Vlad_2);
            left = getResources().getStringArray(R.array.training_V_left2);
            right =getResources().getStringArray(R.array.training_V_right2);
            op =getResources().getStringArray(R.array.training_V_op2);
        }
        if (e_ID == 2 && position == 3) {
            name = getResources().getStringArray(R.array.training_V3);
            img = getResources().obtainTypedArray(R.array.img_Vlad_3);
            left = getResources().getStringArray(R.array.training_V_left3);
            right =getResources().getStringArray(R.array.training_V_right3);
            op =getResources().getStringArray(R.array.training_V_op3);
        }
        if (e_ID == 2 && position == 4) {
            name = getResources().getStringArray(R.array.training_V4);
            img = getResources().obtainTypedArray(R.array.img_Vlad_4);
            left = getResources().getStringArray(R.array.training_V_left4);
            right =getResources().getStringArray(R.array.training_V_right4);
            op =getResources().getStringArray(R.array.training_V_op4);
        }
        if (e_ID == 2 && position == 5) {
            name = getResources().getStringArray(R.array.training_V5);
            img = getResources().obtainTypedArray(R.array.img_Vlad_5);
            left = getResources().getStringArray(R.array.training_V_left5);
            right =getResources().getStringArray(R.array.training_V_right5);
            op =getResources().getStringArray(R.array.training_V_op5);
        }
        if (e_ID == 3 && position == 0) {
            name = getResources().getStringArray(R.array.training_G);
            img = getResources().obtainTypedArray(R.array.img_Gel_0);
            left = getResources().getStringArray(R.array.training_G_left);
            right =getResources().getStringArray(R.array.training_G_right);
            op =getResources().getStringArray(R.array.training_G_op);
        }
        if (e_ID == 3 && position == 1) {
            name = getResources().getStringArray(R.array.training_G1);
            img = getResources().obtainTypedArray(R.array.img_Gel_1);
            left = getResources().getStringArray(R.array.training_G_left1);
            right =getResources().getStringArray(R.array.training_G_right1);
            op =getResources().getStringArray(R.array.training_G_op1);
        }
        if (e_ID == 3 && position == 2) {
            name = getResources().getStringArray(R.array.training_G2);
            img = getResources().obtainTypedArray(R.array.img_Gel_2);
            left = getResources().getStringArray(R.array.training_G_left2);
            right =getResources().getStringArray(R.array.training_G_right2);
            op =getResources().getStringArray(R.array.training_G_op2);
        }
        if (e_ID == 3 && position == 3) {
            name = getResources().getStringArray(R.array.training_G3);
            img = getResources().obtainTypedArray(R.array.img_Gel_3);
            left = getResources().getStringArray(R.array.training_G_left3);
            right =getResources().getStringArray(R.array.training_G_right3);
            op =getResources().getStringArray(R.array.training_G_op3);
        }
        if (e_ID == 3 && position == 4) {
            name = getResources().getStringArray(R.array.training_G4);
            img = getResources().obtainTypedArray(R.array.img_Gel_4);
            left = getResources().getStringArray(R.array.training_G_left4);
            right =getResources().getStringArray(R.array.training_G_right4);
            op =getResources().getStringArray(R.array.training_G_op4);
        }
        if (e_ID == 3 && position == 5) {
            name = getResources().getStringArray(R.array.training_G5);
            img = getResources().obtainTypedArray(R.array.img_Gel_5);
            left = getResources().getStringArray(R.array.training_G_left5);
            right =getResources().getStringArray(R.array.training_G_right5);
            op =getResources().getStringArray(R.array.training_G_op5);
        }
        if (e_ID == 4 && position == 0) {
            name = getResources().getStringArray(R.array.training_F);
            img = getResources().obtainTypedArray(R.array.img_Fil_0);
            left = getResources().getStringArray(R.array.training_F_left);
            right =getResources().getStringArray(R.array.training_F_right);
            op =getResources().getStringArray(R.array.training_F_op);
        }
        if (e_ID == 4 && position == 1) {
            name = getResources().getStringArray(R.array.training_F1);
            img = getResources().obtainTypedArray(R.array.img_Fil_1);
            left = getResources().getStringArray(R.array.training_F_left1);
            right =getResources().getStringArray(R.array.training_F_right1);
            op =getResources().getStringArray(R.array.training_F_op1);
        }
        if (e_ID == 4 && position == 2) {
            name = getResources().getStringArray(R.array.training_F2);
            img = getResources().obtainTypedArray(R.array.img_Fil_2);
            left = getResources().getStringArray(R.array.training_F_left2);
            right =getResources().getStringArray(R.array.training_F_right2);
            op =getResources().getStringArray(R.array.training_F_op2);
        }
        if (e_ID == 4 && position == 3) {
            name = getResources().getStringArray(R.array.training_F3);
            img = getResources().obtainTypedArray(R.array.img_Fil_3);
            left = getResources().getStringArray(R.array.training_F_left3);
            right =getResources().getStringArray(R.array.training_F_right3);
            op =getResources().getStringArray(R.array.training_F_op3);
        }
        if (e_ID == 4 && position == 4) {
            name = getResources().getStringArray(R.array.training_F4);
            img = getResources().obtainTypedArray(R.array.img_Fil_4);
            left = getResources().getStringArray(R.array.training_F_left4);
            right =getResources().getStringArray(R.array.training_F_right4);
            op =getResources().getStringArray(R.array.training_F_op4);
        }
        if (e_ID == 5 && position == 0) {
            name = getResources().getStringArray(R.array.training_C);
            img = getResources().obtainTypedArray(R.array.img_Ckala_0);
            left = getResources().getStringArray(R.array.training_C_left);
            right =getResources().getStringArray(R.array.training_C_right);
            op =getResources().getStringArray(R.array.training_C_op);
        }
        if (e_ID == 5 && position == 1) {
            name = getResources().getStringArray(R.array.training_C1);
            img = getResources().obtainTypedArray(R.array.img_Ckala_1);
            left = getResources().getStringArray(R.array.training_C_left1);
            right =getResources().getStringArray(R.array.training_C_right1);
            op =getResources().getStringArray(R.array.training_C_op1);
        }
        if (e_ID == 5 && position == 2) {
            name = getResources().getStringArray(R.array.training_C2);
            img = getResources().obtainTypedArray(R.array.img_Ckala_2);
            left = getResources().getStringArray(R.array.training_C_left2);
            right =getResources().getStringArray(R.array.training_C_right2);
            op =getResources().getStringArray(R.array.training_C_op2);
        }
        if (e_ID == 5 && position == 3) {
            name = getResources().getStringArray(R.array.training_C3);
            img = getResources().obtainTypedArray(R.array.img_Ckala_3);
            left = getResources().getStringArray(R.array.training_C_left3);
            right =getResources().getStringArray(R.array.training_C_right3);
            op =getResources().getStringArray(R.array.training_C_op3);
        }
        if (e_ID == 5 && position == 4) {
            name = getResources().getStringArray(R.array.training_C4);
            img = getResources().obtainTypedArray(R.array.img_Ckala_4);
            left = getResources().getStringArray(R.array.training_C_left4);
            right =getResources().getStringArray(R.array.training_C_right4);
            op =getResources().getStringArray(R.array.training_C_op4);
        }




        int key;
        key = i.getIntExtra("key", 0);



        rcAdapterCelOp = new RCAdapterCelOp(this, name, left, right, op, img, key);
        rc_choose.setLayoutManager(new LinearLayoutManager(this));
        rc_choose.setAdapter(rcAdapterCelOp);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
