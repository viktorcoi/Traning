package com.example.sgugit;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.Pair;

import com.example.sgugit.AdapterRV.ListTraining;
import com.example.sgugit.AdapterRV.ModelTraining;
import com.example.sgugit.BD.BDTraining.MyConstants;
import com.example.sgugit.BD.BDTraining.MyDBManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MyTraining extends AppCompatActivity {

    private Toolbar toolbar;
    private MyDBManager myDBManager;
    private EditText edName;
    private LinearLayout parentLayout;
    private boolean isEditState = true;
    private List<ModelTraining> TrainingViewModelList = new ArrayList<>();
    private TextView tv_date, tv_time;
    private int Hour, Minute, Year, Month, Day;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_training);
        parentLayout = (LinearLayout) findViewById(R.id.liner_text);
        edName = findViewById(R.id.edName);
        tv_date = findViewById(R.id.tv_date_from_mt);
        tv_time = findViewById(R.id.tv_time_from_mt);
        scrollView = findViewById(R.id.scrollView3);
        myDBManager = new MyDBManager(this);
        getMyIntents();
        EnterDate();
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Тренировка");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        ClickButtonExe();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    private void AddNewExercise(String str_Name) {
        ModelTraining train = new ModelTraining(this);
        train.SetExerciseName(str_Name);
        TrainingViewModelList.add(train);
        parentLayout.addView(train.GetLayout());
    }

    private Boolean AddExerciseContent(String left, String right) {
        ModelTraining train = GetLatestTraining();
        if (train == null)
            return false;

        train.AppendExerciseCell(left, right);
        return true;
    }

    private ModelTraining GetLatestTraining() {
        return TrainingViewModelList.size() > 0 ? TrainingViewModelList.get(TrainingViewModelList.size() - 1) : null;
    }

    private Boolean HasCellInLatestTraining() {
        ModelTraining train = GetLatestTraining();
        return train == null ? false : train.HasContent();
    }

    private void ShowTrainingDialog() {
        if (GetLatestTraining() != null && HasCellInLatestTraining() == false) {
            Toast.makeText(this, "Нет подходов в последнем упражнении", Toast.LENGTH_LONG).show();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("Принять", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                {
                    AlertDialog alertDialog = (AlertDialog) dialog;
                    EditText edit_t = alertDialog.findViewById(R.id.ed_text_win);
                    if (edit_t.length() < 1 || edit_t.getText().toString().equals(" ") || edit_t.getText().toString().equals(".") || edit_t.getText().toString().equals(",")) {
                        Toast.makeText(MyTraining.this, "Поле не может быть пустым", Toast.LENGTH_LONG).show();
                    } else {
                        AddNewExercise(edit_t.getText().toString());
                        scrollView.fullScroll(View.FOCUS_DOWN);
                    }
                }
            }
        });
        builder.setNeutralButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.window_for_name, null);
        builder.setView(cl);
        builder.setCancelable(false);
        builder.show();
    }

    public String GetTextFromDialogField(DialogInterface dialog, int field_id) {
        AlertDialog alertDialog = (AlertDialog) dialog;
        EditText edit_t = alertDialog.findViewById(field_id);
        return edit_t.getText().toString();
    }

    private void ShowTrainingCellDialog() {
        if (GetLatestTraining() == null) {
            Toast.makeText(this, "Добавьте упражнение", Toast.LENGTH_LONG).show();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setPositiveButton("Принять", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String string = GetTextFromDialogField(dialog, R.id.ed_text_win3);
                String string1 = GetTextFromDialogField(dialog, R.id.ed_text_win2);
                if (string.length() < 1 || string1.length() < 1 || string.equals(" ") || string.equals(".") || string.equals(",") || string1.equals(" ") || string1.equals(".") || string1.equals(",")) {
                    Toast.makeText(MyTraining.this, "Поля должны быть заполнены", Toast.LENGTH_LONG).show();
                } else {
                    AddExerciseContent(string, string1);
                    scrollView.fullScroll(View.FOCUS_DOWN);
                }
            }
        });
        builder.setNeutralButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        ConstraintLayout cl = (ConstraintLayout) getLayoutInflater().inflate(R.layout.window_for_kg, null);
        builder.setView(cl);
        builder.setCancelable(false);
        builder.show();
    }

    public void onClickAddExe(View view) {
        if (edName.length() > 1) {
            edName.setFocusable(false);
        }
        ShowTrainingDialog();
    }

    public void onClickAddApp(View view) {
        if (edName.length() > 1) {
            edName.setFocusable(false);
        }
        ShowTrainingCellDialog();
    }

    public void onClickSave(View view) {
        if (edName.length() < 1 && GetLatestTraining() == null) {
            MyTraining.this.finish();

        } else {
            android.app.AlertDialog dialog = new android.app.AlertDialog.Builder(this)
                    .setMessage("Завершить и сохранить тренировку?")
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
                            save();
                            dialog.dismiss();

                        }
                    });
                }
            });

            dialog.show();
            dialog.setCanceledOnTouchOutside(false);
            TextView tvMessage = (TextView) dialog.findViewById(android.R.id.message);
            tvMessage.setGravity(Gravity.CENTER);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        myDBManager.openDb();
    }


    private void getMyIntents() {
        Intent i = getIntent();
        if (i != null) {
            ListTraining item = (ListTraining) i.getSerializableExtra(MyConstants.LIST_TRAINING_INTENT);
            isEditState = i.getBooleanExtra(MyConstants.EDIT_STATE, true);


            if (!isEditState) {

                edName.setText(item.Name);
                ConstraintLayout cl = findViewById(R.id.cl_mt);
                cl.setVisibility(View.GONE);
                ScrollView sv = findViewById(R.id.scrollView3);
                ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) sv.getLayoutParams();
                lp.bottomMargin = 0;
                sv.setLayoutParams(lp);
                edName.setFocusable(false);

                for (String ID :
                        item.GetExercises()) {
                    AddNewExercise(myDBManager.GetExerciseName(ID));

                    for (String Content :
                            item.GetExerciseContent(ID)) {
                        Pair<String, String> t = myDBManager.GetExerciseContent(Content);
                        AddExerciseContent(t.first, t.second);
                    }
                }

            }
        }
    }

    private void save() {
        String ed_name = edName.getText().toString();
        String tv_Date = tv_date.getText().toString();
        String tv_Time = tv_time.getText().toString();
        String tv_Timer = "Длительность: " + timer;

        if (ed_name.length() < 1) {
            Toast.makeText(this, "Введите название тренировки", Toast.LENGTH_LONG).show();
            return;
        }

        if (GetLatestTraining() == null) {

            Toast.makeText(this, "Добавьте упражнения", Toast.LENGTH_LONG).show();
            return;
        }

        if (HasCellInLatestTraining() == false) {
            Toast.makeText(this, "Нету подходов в последнем \n               упражнении", Toast.LENGTH_LONG).show();
            return;
        }

        myDBManager.InsertTrainingInstance(ed_name, tv_Date, tv_Time, tv_Timer, TrainingViewModelList);
        Toast.makeText(this, "Тренировка завершена", Toast.LENGTH_LONG).show();
        finish();
        myDBManager.closeDb();

    }

    @Override
    public void onBackPressed() {
        if (!isEditState)
            MyTraining.this.finish();
        else {
            openQuitDialog();
        }
    }

    private void openQuitDialog() {
        if (edName.length() < 1 && GetLatestTraining() == null) {
            MyTraining.this.finish();
        } else {
            android.app.AlertDialog dialog = new android.app.AlertDialog.Builder(this)
                    .setMessage("Выйти из тренировки  и\nсбросить весь текущий прогресс?")
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
            dialog.setCanceledOnTouchOutside(false);
            TextView tvMessage = (TextView) dialog.findViewById(android.R.id.message);
            tvMessage.setGravity(Gravity.CENTER);
        }
    }

    void ClickButtonExe() {
        if (!isEditState) ;

        else {
            button_exe();
            button_cel();
        }
    }

    void button_exe() {
        Button b1 = new Button(this);
        b1.setBackground(this.getResources().getDrawable(R.drawable.exercises_from_mt));
        Toolbar.LayoutParams l_b = new Toolbar.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT, Toolbar.LayoutParams.MATCH_PARENT);
        l_b.width = 170;
        l_b.height = 100;
        l_b.setMarginEnd(20);
        l_b.gravity = Gravity.END;
        b1.setLayoutParams(l_b);
        toolbar.addView(b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyTraining.this, ListExercises.class);
                intent.putExtra("key", 666);
                startActivity(intent);
            }
        });
    }

    void button_cel() {
        Button b1 = new Button(this);
        b1.setBackground(this.getResources().getDrawable(R.drawable.celebrity_from_mt));
        Toolbar.LayoutParams l_b = new Toolbar.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT, Toolbar.LayoutParams.MATCH_PARENT);
        l_b.width = 100;
        l_b.height = 100;
        l_b.setMarginEnd(70);
        l_b.gravity = Gravity.END;
        b1.setLayoutParams(l_b);
        toolbar.addView(b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyTraining.this, CelebrityGO.class);
                intent.putExtra("key", 666);
                startActivity(intent);
            }
        });
    }

    private void EnterDate() {

        if (!isEditState)
        {

        } else {
            Calendar calendar = Calendar.getInstance();
            final int year = calendar.get(Calendar.YEAR);
            final int month = calendar.get(Calendar.MONTH);
            final int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(MyTraining.this, new DatePickerDialog.OnDateSetListener() {
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
                        tv_date.setText(sdf.format(date) + " ");
                        if (day == Day && month == Month-1 && year == Year)
                        {
                            SimpleDateFormat sdf1 = new SimpleDateFormat("EEEE");
                            String date1 = sdf1.format(Calendar.getInstance().getTime());
                            tv_date.setText(tv_date.getText().toString() + "(" + date1 + ")" + " ");
                        }
                    }catch (ParseException e) {
                        e.printStackTrace();
                    }
                    EnterTime();
                }
            }, year, month, day);



            datePickerDialog.setButton(DialogInterface.BUTTON_NEGATIVE, getText(R.string.Button_finish), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    if (which == DialogInterface.BUTTON_NEGATIVE) {
                        MyTraining.this.finish();
                    }
                }
            });
            datePickerDialog.setMessage("Дата тренировки");
            datePickerDialog.show();
            datePickerDialog.setCanceledOnTouchOutside(false);
            datePickerDialog.setCancelable(false);
            TextView tvMessage = datePickerDialog.findViewById(android.R.id.message);
            tvMessage.setGravity(Gravity.CENTER);
        }
    }

    private void EnterTime() {

        if (!isEditState) {

        } else {
            Calendar calendar = Calendar.getInstance();
            final int hour = calendar.get(Calendar.HOUR_OF_DAY);
            final int minute = calendar.get(Calendar.MINUTE);
            TimePickerDialog tpd = new TimePickerDialog(MyTraining.this, android.R.style.Theme_Holo_Light_Dialog, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    Hour = hourOfDay;
                    Minute = minute;
                    String time_ = Hour + ":" + Minute;
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                    try {
                        Date time = sdf.parse(time_);
                        tv_time.setText("в " + sdf.format(time));
                    }catch (ParseException e) {
                        e.printStackTrace();
                    }
                    runTimer();
                }
            },hour,minute,true);
            tpd.setButton(DialogInterface.BUTTON_NEGATIVE, getText(R.string.Button_finish), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    if (which == DialogInterface.BUTTON_NEGATIVE) {
                        MyTraining.this.finish();
                    }
                }
            });
            tpd.setMessage("Время начала тренировки");
            tpd.show();
            tpd.setCanceledOnTouchOutside(false);
            tpd.setCancelable(false);
            TextView tvMessage = tpd.findViewById(android.R.id.message);
            tvMessage.setGravity(Gravity.CENTER);

        }
    }

    String timer;

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void runTimer () {

        Chronometer Timer  = (Chronometer) findViewById(R.id.Timer);
        Timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener(){
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                long time = SystemClock.elapsedRealtime() - chronometer.getBase();
                int h   = (int)(time /3600000);
                int m = (int)(time - h*3600000)/60000;
                int s= (int)(time - h*3600000- m*60000)/1000 ;
                timer = (h < 10 ? h: h)+":"+(m < 10 ? "0"+m: m)+":"+ (s < 10 ? "0"+s: s);
                chronometer.setText(timer);
            }
        });
        Timer.setBase(SystemClock.elapsedRealtime());
        Timer.start();
    }

    public void onClickNameRed(View view) {
        edName.setFocusable(true);
        edName.setFocusableInTouchMode(true);
        edName.requestFocus();
    }
}
