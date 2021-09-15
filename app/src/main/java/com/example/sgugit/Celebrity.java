package com.example.sgugit;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sgugit.AdapterRV.RCAdapterCelChoose;

public class Celebrity extends AppCompatActivity {

    Toolbar toolbar;
    private ImageView Image;
    private TextView Text;
    RecyclerView rc_choose;
    private RCAdapterCelChoose rcAdapter;
    String s1[];
    int id = 55;
    public static int[][] TV = {
            {R.string.ArniOp, R.drawable.arni2, R.string.title_ASH},
            {R.string.StalOp, R.drawable.stal, R.string.title_SS},
            {R.string.VladOP, R.drawable.vlad2, R.string.title_VT},
            {R.string.GelOp, R.drawable.gel2, R.string.title_HS},
            {R.string.FilOp, R.drawable.fil2, R.string.title_FH},
            {R.string.CkalaOp, R.drawable.ckala2, R.string.title_DD},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.celebrity);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Тренировки знаменитостей");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Image = findViewById(R.id.imageCT);
        Text = findViewById(R.id.text_content);
        reciveIntent();


        Text = findViewById(R.id.text_trai);
        rc_choose = findViewById(R.id.rv_for_celebrity);
        Intent i = getIntent();
        int key;
        key = i.getIntExtra("key", 0);
        int position;
        position = i.getIntExtra("position", 0);
        if (position == 0) {
            s1 = getResources().getStringArray(R.array.cel_choose1);
        }
        if (position == 1) {
            s1 = getResources().getStringArray(R.array.cel_choose2);
        }
        if (position == 2) {
            s1 = getResources().getStringArray(R.array.cel_choose3);
        }
        if (position == 3) {
            s1 = getResources().getStringArray(R.array.cel_choose4);
        }
        if (position == 4) {
            s1 = getResources().getStringArray(R.array.cel_choose5);
        }
        if (position == 5) {
            s1 = getResources().getStringArray(R.array.cel_choose6);
        }
        id = position;

        rcAdapter = new RCAdapterCelChoose(this, s1, position, key);
        rc_choose.setLayoutManager(new LinearLayoutManager(this));
        rc_choose.setAdapter(rcAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    private void reciveIntent() {
        Intent i = getIntent();
        int position = 0;
        if (i != null) {
            position = i.getIntExtra("position", 0);
        }
        Text.setText(TV[position][0]);
        Image.setImageResource(TV[position][1]);
        toolbar.setTitle(TV[position][2]);
    }
}