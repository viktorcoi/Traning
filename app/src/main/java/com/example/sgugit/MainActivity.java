package com.example.sgugit;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sgugit.AdapterRV.RCAdapter;
import com.example.sgugit.BD.BDTraining.MyDBManager;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private Toolbar toolbar;
    private RecyclerView rcView;
    private MyDBManager myDBManager;
    private RCAdapter rcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        toolbar = findViewById(R.id.toolbar_trai);
        toolbar.setTitle(R.string.m_mt);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void init() {
        myDBManager = new MyDBManager(this);
        rcView = findViewById(R.id.trai_view);
        rcAdapter = new RCAdapter(this);
        rcView.setLayoutManager(new LinearLayoutManager(this));
        getItemTouchHelper().attachToRecyclerView(rcView);
        rcView.setAdapter(rcAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        myDBManager.openDb();
        rcAdapter.updateAdapter(myDBManager.getFromDb());

    }

    public void onClickAdd(View view) {
        Intent i = new Intent(MainActivity.this, MyTraining.class);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDBManager.closeDb();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.nav_measurements) {
            Intent intent = new Intent(MainActivity.this, MeasurementsGO.class);
            startActivity(intent);
        } else if (id == R.id.nav_exercises) {
            Intent intent = new Intent(MainActivity.this, ListExercises.class);
            startActivity(intent);
        } else if (id == R.id.nav_celebrity) {
            Intent intent = new Intent(MainActivity.this, CelebrityGO.class);
            startActivity(intent);
        }else  if (id == R.id.nav_about) {
        Intent intent = new Intent(MainActivity.this, AboutApp.class);
        startActivity(intent);
    }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    private ItemTouchHelper getItemTouchHelper() {
        return new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                final AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setMessage("Удалить тренировку?")
                        .setPositiveButton("Да", null)
                        .setNeutralButton("Отмена", null)
                        .create();

                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialogInterface) {
                        Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                rcAdapter.removeItem(viewHolder.getAdapterPosition(), myDBManager);
                                dialog.dismiss();
                            }
                        });
                        Button button2 = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_NEUTRAL);
                        button2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                rcAdapter.updateAdapter(myDBManager.getFromDb());
                                dialog.dismiss();
                            }
                        });
                    }
                });
                dialog.show();
                dialog.setCancelable(false);
                TextView tvMessage = (TextView)dialog.findViewById(android.R.id.message);
                tvMessage.setGravity(Gravity.CENTER);
            }
        });
    }
}

