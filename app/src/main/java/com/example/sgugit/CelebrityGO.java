package com.example.sgugit;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sgugit.AdapterRV.RCAdapterCel;

public class CelebrityGO extends AppCompatActivity {

    RecyclerView rc_cg;
    String s1[];
    int images[] = {R.drawable.arni, R.drawable.stalrc, R.drawable.vlad, R.drawable.gel, R.drawable.fil, R.drawable.ckala};
    private RCAdapterCel rcAdapterCel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.celebrity_go);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Тренировки знаменитостей");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        rc_cg = findViewById(R.id.rc_cg);
        s1 = getResources().getStringArray(R.array.cel_array);
        Intent i = getIntent();
        int key;
        key = i.getIntExtra("key", 0);
        rcAdapterCel = new RCAdapterCel(this, s1, images, key);
        rc_cg.setLayoutManager(new LinearLayoutManager(this));
        rc_cg.setAdapter(rcAdapterCel);
        Intent u = getIntent();
        int key_;
        key_ = u.getIntExtra("key_", 0);
        if (key_== 777){
            finish();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

}