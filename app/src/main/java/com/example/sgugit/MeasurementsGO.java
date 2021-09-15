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
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sgugit.AdapterRV.RCAdapterMeas;
import com.example.sgugit.BD.BDMeasurements.MyDBManager2;

public class MeasurementsGO extends AppCompatActivity {

    private RecyclerView rcView2;
    private MyDBManager2 myDBManager2;
    private RCAdapterMeas rcAdapter2;
    private TextView ed_rost, tv_date, ed_ves, ed_jir, ed_shea, ed_plechi, ed_grud, ed_lb, ed_pb, ed_lp, ed_pp, ed_talia, ed_taz, ed_lbed, ed_pbed, ed_lg, ed_pg;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.measurements_go);

        init();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    public void onClickAdd(View view) {
        Intent intent = new Intent(MeasurementsGO.this, Measurements.class);
        startActivity(intent);
    }


    private void init() {
        myDBManager2 = new MyDBManager2(this);

        ed_rost = findViewById(R.id.tv_rost_ed);
        tv_date = findViewById(R.id.tv_date);
        ed_jir = findViewById(R.id.tv_jir_ed);
        ed_shea = findViewById(R.id.tv_shea_ed);
        ed_plechi = findViewById(R.id.tv_plechi_ed);
        ed_grud = findViewById(R.id.tv_grud_ed);
        ed_lb = findViewById(R.id.tv_lb_ed);
        ed_pb = findViewById(R.id.tv_pb_ed);
        ed_lp = findViewById(R.id.tv_lp_ed);
        ed_pp = findViewById(R.id.tv_pp_ed);
        ed_talia = findViewById(R.id.tv_talia_ed);
        ed_taz = findViewById(R.id.tv_taz_ed);
        ed_lbed = findViewById(R.id.tv_lbed_ed);
        ed_pbed = findViewById(R.id.tv_pbed_ed);
        ed_lg = findViewById(R.id.tv_lg_ed);
        ed_pg = findViewById(R.id.tv_pg_ed);
        ed_ves = findViewById(R.id.tv_ves_ed);
        rcView2 = findViewById(R.id.meas_view);
        rcAdapter2 = new RCAdapterMeas(this);
        rcView2.setLayoutManager(new LinearLayoutManager(this));
        getItemTouchHelper().attachToRecyclerView(rcView2);
        rcView2.setAdapter(rcAdapter2);
    }



    @Override
    protected void onResume() {
        super.onResume();

       myDBManager2.openDb();
        rcAdapter2.updateAdapter2(myDBManager2.getFromDb());

    }

    @Override
   protected void onDestroy() {
      super.onDestroy();
           myDBManager2.closeDb();
    }

    private ItemTouchHelper getItemTouchHelper() {
        return new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                final AlertDialog dialog = new AlertDialog.Builder(MeasurementsGO.this)
                        .setMessage("Удалить запись?")
                        .setPositiveButton("Да", null) //Set to null. We override the onclick
                        .setNeutralButton("Отмена", null)
                        .create();

                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialogInterface) {
                        Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                rcAdapter2.removeItem2(viewHolder.getAdapterPosition(), myDBManager2);
                                dialog.dismiss();
                            }
                        });
                        Button button2 = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_NEUTRAL);
                        button2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                rcAdapter2.updateAdapter2(myDBManager2.getFromDb());
                                dialog.dismiss();
                            }
                        });
                    }
                });
                dialog.show();
                TextView tvMessage = (TextView)dialog.findViewById(android.R.id.message);
                tvMessage.setGravity(Gravity.CENTER);
            }
        });
    }

}