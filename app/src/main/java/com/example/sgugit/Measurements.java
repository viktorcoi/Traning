package com.example.sgugit;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.sgugit.AdapterRV.ListMeasurements;
import com.example.sgugit.BD.BDMeasurements.MyConstants2;
import com.example.sgugit.BD.BDMeasurements.MyDBManager2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Measurements extends AppCompatActivity {

    private TextView ed_rost, ed_ves, ed_jir, ed_shea, ed_plechi, ed_grud, ed_lb, ed_pb, ed_lp, ed_pp, ed_talia, ed_taz, ed_lbed, ed_pbed, ed_lg, ed_pg, tv_date;
    private MyDBManager2 myDBManager2;
    private boolean isEditState = true;
    private int Year, Month, Day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.measurements);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Замеры");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        init();
        getMyIntents();
    }

    private void enter_rost() {
        if (!isEditState) {

        } else {
            final AlertDialog dialog = new AlertDialog.Builder(Measurements.this)
                    .setMessage("Введите рост")
                    .setPositiveButton("Принять", null) //Set to null. We override the onclick
                    .setNeutralButton("Отмена", null)
                    .create();

            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {

                    Button button = (dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                    button.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            EditText edit_t = dialog.findViewById(R.id.ed_text_win);
                            if (edit_t.getText().toString().equals("")) {
                                Toast toast = Toast.makeText(view.getContext(), "Введите данные", Toast.LENGTH_SHORT);
                                toast.show();
                            } else {
                                String string = edit_t.getText().toString();
                                ed_rost.setText(string + " cм.");
                                dialog.dismiss();
                            }
                        }
                    });
                }
            });
            ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.window_for_measurements, null);
            dialog.setView(cl);
            dialog.show();
            TextView tvMessage = dialog.findViewById(android.R.id.message);
            tvMessage.setGravity(Gravity.CENTER);
        }
    }

    private void enter_ves() {
        if (!isEditState) {

        } else {
            final AlertDialog dialog = new AlertDialog.Builder(Measurements.this)
                    .setMessage("Введите вес")
                    .setPositiveButton("Принять", null)
                    .setNeutralButton("Отмена", null)
                    .create();

            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {

                    Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                    button.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            EditText edit_t = dialog.findViewById(R.id.ed_text_win);
                            if (edit_t.getText().toString().equals("")) {
                                Toast toast = Toast.makeText(view.getContext(), "Введите данные", Toast.LENGTH_SHORT);
                                toast.show();
                            } else {
                                String string = edit_t.getText().toString();
                                ed_ves.setText(string + " кг.");
                                dialog.dismiss();
                            }
                        }
                    });
                }
            });
            ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.window_for_measurements, null);
            dialog.setView(cl);
            dialog.show();
            TextView tvMessage = (TextView) dialog.findViewById(android.R.id.message);
            tvMessage.setGravity(Gravity.CENTER);
        }
    }

    private void enter_jir() {
        if (!isEditState) {

        } else {
            final AlertDialog dialog = new AlertDialog.Builder(Measurements.this)
                    .setMessage("Введите % подкожного жира")
                    .setPositiveButton("Принять", null)
                    .setNeutralButton("Отмена", null)
                    .create();

            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {

                    Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                    button.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            EditText edit_t = dialog.findViewById(R.id.ed_text_win);
                            if (edit_t.getText().toString().equals("")) {
                                Toast toast = Toast.makeText(view.getContext(), "Введите данные", Toast.LENGTH_SHORT);
                                toast.show();
                            } else {
                                String string = edit_t.getText().toString();
                                ed_jir.setText(string + "   %");
                                dialog.dismiss();
                            }
                        }
                    });
                }
            });
            ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.window_for_measurements, null);
            dialog.setView(cl);
            dialog.show();
            TextView tvMessage = (TextView) dialog.findViewById(android.R.id.message);
            tvMessage.setGravity(Gravity.CENTER);
        }
    }

    private void enter_shea() {
        if (!isEditState) {

        } else {
            final AlertDialog dialog = new AlertDialog.Builder(Measurements.this)
                    .setMessage("Введите обхват шеи")
                    .setPositiveButton("Принять", null)
                    .setNeutralButton("Отмена", null)
                    .create();

            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {

                    Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                    button.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            EditText edit_t = dialog.findViewById(R.id.ed_text_win);
                            if (edit_t.getText().toString().equals("")) {
                                Toast toast = Toast.makeText(view.getContext(), "Введите данные", Toast.LENGTH_SHORT);
                                toast.show();
                            } else {
                                String string = edit_t.getText().toString();
                                ed_shea.setText(string + " cм.");
                                dialog.dismiss();
                            }
                        }
                    });
                }
            });
            ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.window_for_measurements, null);
            dialog.setView(cl);
            dialog.show();
            TextView tvMessage = (TextView) dialog.findViewById(android.R.id.message);
            tvMessage.setGravity(Gravity.CENTER);
        }
    }

    private void enter_plechi() {
        if (!isEditState) {

        } else {
            final AlertDialog dialog = new AlertDialog.Builder(Measurements.this)
                    .setMessage("Введите обхват плеч")
                    .setPositiveButton("Принять", null) //Set to null. We override the onclick
                    .setNeutralButton("Отмена", null)
                    .create();

            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {

                    Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                    button.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            EditText edit_t = dialog.findViewById(R.id.ed_text_win);
                            if (edit_t.getText().toString().equals("")) {
                                Toast toast = Toast.makeText(view.getContext(), "Введите данные", Toast.LENGTH_SHORT);
                                toast.show();
                            } else {
                                String string = edit_t.getText().toString();
                                ed_plechi.setText(string + " cм.");
                                dialog.dismiss();
                            }
                        }
                    });
                }
            });
            ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.window_for_measurements, null);
            dialog.setView(cl);
            dialog.show();
            TextView tvMessage = (TextView) dialog.findViewById(android.R.id.message);
            tvMessage.setGravity(Gravity.CENTER);
        }
    }

    private void enter_grud() {
        if (!isEditState) {

        } else {
            final AlertDialog dialog = new AlertDialog.Builder(Measurements.this)
                    .setMessage("Введите обхват груди")
                    .setPositiveButton("Принять", null) //Set to null. We override the onclick
                    .setNeutralButton("Отмена", null)
                    .create();

            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {

                    Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                    button.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            EditText edit_t = dialog.findViewById(R.id.ed_text_win);
                            if (edit_t.getText().toString().equals("")) {
                                Toast toast = Toast.makeText(view.getContext(), "Введите данные", Toast.LENGTH_SHORT);
                                toast.show();
                            } else {
                                String string = edit_t.getText().toString();
                                ed_grud.setText(string + " cм.");
                                dialog.dismiss();
                            }
                        }
                    });
                }
            });
            ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.window_for_measurements, null);
            dialog.setView(cl);
            dialog.show();
            TextView tvMessage = (TextView) dialog.findViewById(android.R.id.message);
            tvMessage.setGravity(Gravity.CENTER);
        }
    }

    private void enter_lb() {
        if (!isEditState) {

        } else {
            final AlertDialog dialog = new AlertDialog.Builder(Measurements.this)
                    .setMessage("Введите обхват левого бицепса")
                    .setPositiveButton("Принять", null) //Set to null. We override the onclick
                    .setNeutralButton("Отмена", null)
                    .create();

            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {

                    Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                    button.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            EditText edit_t = dialog.findViewById(R.id.ed_text_win);
                            if (edit_t.getText().toString().equals("")) {
                                Toast toast = Toast.makeText(view.getContext(), "Введите данные", Toast.LENGTH_SHORT);
                                toast.show();
                            } else {
                                String string = edit_t.getText().toString();
                                ed_lb.setText(string + " cм.");
                                dialog.dismiss();
                            }
                        }
                    });
                }
            });
            ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.window_for_measurements, null);
            dialog.setView(cl);
            dialog.show();
            TextView tvMessage = (TextView) dialog.findViewById(android.R.id.message);
            tvMessage.setGravity(Gravity.CENTER);
        }
    }

    private void enter_pb() {
        if (!isEditState) {

        } else {
            final AlertDialog dialog = new AlertDialog.Builder(Measurements.this)
                    .setMessage("Введите обхват правого бицепса")
                    .setPositiveButton("Принять", null) //Set to null. We override the onclick
                    .setNeutralButton("Отмена", null)
                    .create();

            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {

                    Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                    button.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            EditText edit_t = dialog.findViewById(R.id.ed_text_win);
                            if (edit_t.getText().toString().equals("")) {
                                Toast toast = Toast.makeText(view.getContext(), "Введите данные", Toast.LENGTH_SHORT);
                                toast.show();
                            } else {
                                String string = edit_t.getText().toString();
                                ed_pb.setText(string + " cм.");
                                dialog.dismiss();
                            }
                        }
                    });
                }
            });
            ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.window_for_measurements, null);
            dialog.setView(cl);
            dialog.show();
            TextView tvMessage = (TextView) dialog.findViewById(android.R.id.message);
            tvMessage.setGravity(Gravity.CENTER);
        }
    }

    private void enter_lp() {
        if (!isEditState) {

        } else {
            final AlertDialog dialog = new AlertDialog.Builder(Measurements.this)
                    .setMessage("Введите обхват левого предплечья")
                    .setPositiveButton("Принять", null) //Set to null. We override the onclick
                    .setNeutralButton("Отмена", null)
                    .create();

            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {

                    Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                    button.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            EditText edit_t = dialog.findViewById(R.id.ed_text_win);
                            if (edit_t.getText().toString().equals("")) {
                                Toast toast = Toast.makeText(view.getContext(), "Введите данные", Toast.LENGTH_SHORT);
                                toast.show();
                            } else {
                                String string = edit_t.getText().toString();
                                ed_lp.setText(string + " cм.");
                                dialog.dismiss();
                            }
                        }
                    });
                }
            });
            ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.window_for_measurements, null);
            dialog.setView(cl);
            dialog.show();
            TextView tvMessage = (TextView) dialog.findViewById(android.R.id.message);
            tvMessage.setGravity(Gravity.CENTER);
        }
    }

    private void enter_pp() {
        if (!isEditState) {

        } else {
            final AlertDialog dialog = new AlertDialog.Builder(Measurements.this)
                    .setMessage("Введите обхват правого предплечья")
                    .setPositiveButton("Принять", null) //Set to null. We override the onclick
                    .setNeutralButton("Отмена", null)
                    .create();

            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {

                    Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                    button.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            EditText edit_t = dialog.findViewById(R.id.ed_text_win);
                            if (edit_t.getText().toString().equals("")) {
                                Toast toast = Toast.makeText(view.getContext(), "Введите данные", Toast.LENGTH_SHORT);
                                toast.show();
                            } else {
                                String string = edit_t.getText().toString();
                                ed_pp.setText(string + " cм.");
                                dialog.dismiss();
                            }
                        }
                    });
                }
            });
            ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.window_for_measurements, null);
            dialog.setView(cl);
            dialog.show();
            TextView tvMessage = (TextView) dialog.findViewById(android.R.id.message);
            tvMessage.setGravity(Gravity.CENTER);
        }
    }

    private void enter_talia() {
        if (!isEditState) {

        } else {
            final AlertDialog dialog = new AlertDialog.Builder(Measurements.this)
                    .setMessage("Введите обхват талии")
                    .setPositiveButton("Принять", null) //Set to null. We override the onclick
                    .setNeutralButton("Отмена", null)
                    .create();

            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {

                    Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                    button.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            EditText edit_t = dialog.findViewById(R.id.ed_text_win);
                            if (edit_t.getText().toString().equals("")) {
                                Toast toast = Toast.makeText(view.getContext(), "Введите данные", Toast.LENGTH_SHORT);
                                toast.show();
                            } else {
                                String string = edit_t.getText().toString();
                                ed_talia.setText(string + " cм.");
                                dialog.dismiss();
                            }
                        }
                    });
                }
            });
            ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.window_for_measurements, null);
            dialog.setView(cl);
            dialog.show();
            TextView tvMessage = (TextView) dialog.findViewById(android.R.id.message);
            tvMessage.setGravity(Gravity.CENTER);
        }
    }

    private void enter_taz() {
        if (!isEditState) {

        } else {
            final AlertDialog dialog = new AlertDialog.Builder(Measurements.this)
                    .setMessage("Введите обхват таза")
                    .setPositiveButton("Принять", null) //Set to null. We override the onclick
                    .setNeutralButton("Отмена", null)
                    .create();

            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {

                    Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                    button.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            EditText edit_t = dialog.findViewById(R.id.ed_text_win);
                            if (edit_t.getText().toString().equals("")) {
                                Toast toast = Toast.makeText(view.getContext(), "Введите данные", Toast.LENGTH_SHORT);
                                toast.show();
                            } else {
                                String string = edit_t.getText().toString();
                                ed_taz.setText(string + " cм.");
                                dialog.dismiss();
                            }
                        }
                    });
                }
            });
            ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.window_for_measurements, null);
            dialog.setView(cl);
            dialog.show();
            TextView tvMessage = (TextView) dialog.findViewById(android.R.id.message);
            tvMessage.setGravity(Gravity.CENTER);
        }
    }

    private void enter_lbed() {
        if (!isEditState) {

        } else {
            final AlertDialog dialog = new AlertDialog.Builder(Measurements.this)
                    .setMessage("Введите обхват левого бедра")
                    .setPositiveButton("Принять", null) //Set to null. We override the onclick
                    .setNeutralButton("Отмена", null)
                    .create();

            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {

                    Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                    button.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            EditText edit_t = dialog.findViewById(R.id.ed_text_win);
                            if (edit_t.getText().toString().equals("")) {
                                Toast toast = Toast.makeText(view.getContext(), "Введите данные", Toast.LENGTH_SHORT);
                                toast.show();
                            } else {
                                String string = edit_t.getText().toString();
                                ed_lbed.setText(string + " cм.");
                                dialog.dismiss();
                            }
                        }
                    });
                }
            });
            ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.window_for_measurements, null);
            dialog.setView(cl);
            dialog.show();
            TextView tvMessage = (TextView) dialog.findViewById(android.R.id.message);
            tvMessage.setGravity(Gravity.CENTER);
        }
    }

    private void enter_pbed() {
        if (!isEditState) {

        } else {
            final AlertDialog dialog = new AlertDialog.Builder(Measurements.this)
                    .setMessage("Введите обхват правого бедра")
                    .setPositiveButton("Принять", null) //Set to null. We override the onclick
                    .setNeutralButton("Отмена", null)
                    .create();

            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {

                    Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                    button.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            EditText edit_t = dialog.findViewById(R.id.ed_text_win);
                            if (edit_t.getText().toString().equals("")) {
                                Toast toast = Toast.makeText(view.getContext(), "Введите данные", Toast.LENGTH_SHORT);
                                toast.show();
                            } else {
                                String string = edit_t.getText().toString();
                                ed_pbed.setText(string + " cм.");
                                dialog.dismiss();
                            }
                        }
                    });
                }
            });
            ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.window_for_measurements, null);
            dialog.setView(cl);
            dialog.show();
            TextView tvMessage = (TextView) dialog.findViewById(android.R.id.message);
            tvMessage.setGravity(Gravity.CENTER);
        }
    }

    private void enter_lg() {
        if (!isEditState) {

        } else {
            final AlertDialog dialog = new AlertDialog.Builder(Measurements.this)
                    .setMessage("Введите обхват левой голени")
                    .setPositiveButton("Принять", null) //Set to null. We override the onclick
                    .setNeutralButton("Отмена", null)
                    .create();

            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {

                    Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                    button.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            EditText edit_t = dialog.findViewById(R.id.ed_text_win);
                            if (edit_t.getText().toString().equals("")) {
                                Toast toast = Toast.makeText(view.getContext(), "Введите данные", Toast.LENGTH_SHORT);
                                toast.show();
                            } else {
                                String string = edit_t.getText().toString();
                                ed_lg.setText(string + " cм.");
                                dialog.dismiss();
                            }
                        }
                    });
                }
            });
            ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.window_for_measurements, null);
            dialog.setView(cl);
            dialog.show();
            TextView tvMessage = (TextView) dialog.findViewById(android.R.id.message);
            tvMessage.setGravity(Gravity.CENTER);
        }
    }

    private void enter_pg() {
        if (!isEditState) {

        } else {
            final AlertDialog dialog = new AlertDialog.Builder(Measurements.this)
                    .setMessage("Введите обхват правой голени")
                    .setPositiveButton("Принять", null) //Set to null. We override the onclick
                    .setNeutralButton("Отмена", null)
                    .create();

            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {

                    Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE);
                    button.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            EditText edit_t = dialog.findViewById(R.id.ed_text_win);
                            if (edit_t.getText().toString().equals("")) {
                                Toast toast = Toast.makeText(view.getContext(), "Введите данные", Toast.LENGTH_SHORT);
                                toast.show();
                            } else {
                                String string = edit_t.getText().toString();
                                ed_pg.setText(string + " cм.");
                                dialog.dismiss();
                            }
                        }
                    });
                }
            });
            ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.window_for_measurements, null);
            dialog.setView(cl);
            dialog.show();
            TextView tvMessage = (TextView) dialog.findViewById(android.R.id.message);
            tvMessage.setGravity(Gravity.CENTER);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    public void onClickRost(View view) {
        enter_rost();
    }

    public void onClickVes(View view) {
        enter_ves();
    }

    public void onClickJir(View view) {
        enter_jir();
    }

    public void onClickShea(View view) {
        enter_shea();
    }

    public void onClickPlechi(View view) {
        enter_plechi();
    }

    public void onClickGrud(View view) {
        enter_grud();
    }

    public void onClickLB(View view) {
        enter_lb();
    }

    public void onClickPB(View view) {
        enter_pb();
    }

    public void onClickLP(View view) {
        enter_lp();
    }

    public void onClickPP(View view) {
        enter_pp();
    }

    public void onClickTalia(View view) {
        enter_talia();
    }

    public void onClickTaz(View view) {
        enter_taz();
    }

    public void onClickLBed(View view) {
        enter_lbed();
    }

    public void onClickPBed(View view) {
        enter_pbed();
    }

    public void onClickLG(View view) {
        enter_lg();
    }

    public void onClickPG(View view) {
        enter_pg();
    }

    public void onClickSave(View view) {
        EnterDate();
    }

    private void EnterDate() {
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(Measurements.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {
                mMonth = mMonth + 1;
                Year = mYear;
                Month = mMonth;
                Day = mDay;
                String date_ = Day + "." + Month + "." + Year;
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                try {
                    Date date = sdf.parse(date_);
                    tv_date.setText(sdf.format(date));
                }catch (ParseException e) {
                    e.printStackTrace();
                }
                if (ed_rost.length() < 1 && ed_ves.length() < 1 && ed_jir.length() < 1 && ed_shea.length() < 1 && ed_plechi.length() < 1 && ed_grud.length() < 1 && ed_lb.length() < 1 && ed_pb.length() < 1 && ed_lp.length() < 1 && ed_pp.length() < 1 && ed_talia.length() < 1
                        && ed_taz.length() < 1 && ed_lbed.length() < 1 && ed_pbed.length() < 1 && ed_lg.length() < 1 && ed_pg.length() < 1){
                    Toast.makeText(Measurements.this, "Вы не ввели данные", Toast.LENGTH_LONG).show();
                } else {
                    save2();
                }
            }
        }, year, month, day);
        datePickerDialog.setMessage("Выберите дату замеров");
        datePickerDialog.setButton(DatePickerDialog.BUTTON_POSITIVE, "Сохранить  ", datePickerDialog);
        datePickerDialog.setButton(DatePickerDialog.BUTTON_NEGATIVE, "   Отмена        ", datePickerDialog);
        datePickerDialog.show();
        TextView tvMessage = datePickerDialog.findViewById(android.R.id.message);
        tvMessage.setGravity(Gravity.CENTER);
    }

    private void init() {
        ed_rost = findViewById(R.id.tv_rost_ed);
        ed_ves = findViewById(R.id.tv_ves_ed);
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
        tv_date = findViewById(R.id.tv_date);
        myDBManager2 = new MyDBManager2(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        myDBManager2.openDb();
    }

    private void save2() {
        String date = tv_date.getText().toString();
        String rost = ed_rost.getText().toString();
        String ves = ed_ves.getText().toString();
        String jir = ed_jir.getText().toString();
        String shea = ed_shea.getText().toString();
        String plechi = ed_plechi.getText().toString();
        String grud = ed_grud.getText().toString();
        String lb = ed_lb.getText().toString();
        String pb = ed_pb.getText().toString();
        String lp = ed_lp.getText().toString();
        String pp = ed_pp.getText().toString();
        String talia = ed_talia.getText().toString();
        String taz = ed_taz.getText().toString();
        String lbed = ed_lbed.getText().toString();
        String pbed = ed_pbed.getText().toString();
        String lg = ed_lg.getText().toString();
        String pg = ed_pg.getText().toString();
        myDBManager2.insertToDb(date, rost, ves, jir, shea, plechi, grud, lb, pb, lp, pp, talia, taz, lbed, pbed, lg, pg);
        Toast.makeText(this, "Ваши данные сохранены", Toast.LENGTH_LONG).show();
        myDBManager2.closeDb();
        finish();
    }

    @Override
    public void onBackPressed() {
        if (!isEditState)
            Measurements.this.finish();
        else {
            openQuitDialog();
        }
    }

    private void openQuitDialog() {
        if (ed_rost.length() < 1 && ed_ves.length() < 1 && ed_jir.length() < 1 && ed_shea.length() < 1 && ed_plechi.length() < 1 && ed_grud.length() < 1 && ed_lb.length() < 1 && ed_pb.length() < 1 && ed_lp.length() < 1 && ed_pp.length() < 1 && ed_talia.length() < 1
                && ed_taz.length() < 1 && ed_lbed.length() < 1 && ed_pbed.length() < 1 && ed_lg.length() < 1 && ed_pg.length() < 1){
            Measurements.this.finish();
        } else {
            android.app.AlertDialog dialog = new android.app.AlertDialog.Builder(this)
                    .setMessage("Выйти и утерять\nвсе несохраненные данные?")
                    .setPositiveButton("Да", null)
                    .setNeutralButton("Нет", null)
                    .create();

            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {

                    Button button = (dialog).getButton(android.app.AlertDialog.BUTTON_POSITIVE);
                    button.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View view) {
                            finish();
                        }
                    });
                }
            });

            dialog.show();
            TextView tvMessage = dialog.findViewById(android.R.id.message);
            tvMessage.setGravity(Gravity.CENTER);
        }
    }

    private void getMyIntents() {
        Intent i = getIntent();
        if (i != null) {
            ListMeasurements item = (ListMeasurements) i.getSerializableExtra(MyConstants2.LIST_MEAS_INTENT);
            isEditState = i.getBooleanExtra(MyConstants2.EDIT_STATE, true);
            if (!isEditState) {
                Button b = findViewById(R.id.save_meas);
                b.setVisibility(View.GONE);
                tv_date.setText(item.getTittle());
                ed_rost.setText(item.getRost());
                ed_ves.setText(item.getVes());
                ed_jir.setText(item.getJir());
                ed_shea.setText(item.getShea());
                ed_plechi.setText(item.getPlechi());
                ed_grud.setText(item.getGrud());
                ed_lb.setText(item.getLb());
                ed_pb.setText(item.getPb());
                ed_lp.setText(item.getLp());
                ed_pp.setText(item.getPp());
                ed_talia.setText(item.getTalia());
                ed_taz.setText(item.getTaz());
                ed_lbed.setText(item.getLbed());
                ed_pbed.setText(item.getPbed());
                ed_lg.setText(item.getLg());
                ed_pg.setText(item.getPg());
            }
        }
    }
}