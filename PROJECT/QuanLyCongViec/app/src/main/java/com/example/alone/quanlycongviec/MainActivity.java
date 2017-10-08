package com.example.alone.quanlycongviec;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends ActionBarActivity {
    private Button dateChange, timeChange, addTask;
    private TextView date, time;
    private int d, m, y, h, mn;
    private ListView danhSach;
    private EditText tenCV, ndCV;
    private ArrayList<String> arr = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("QL Công việc");

        Calendar c = Calendar.getInstance();
        d = c.get(Calendar.DAY_OF_MONTH);
        m = c.get(Calendar.MONTH) + 1;
        y = c.get(Calendar.YEAR);
        h = c.get(Calendar.HOUR_OF_DAY);
        mn = c.get(Calendar.MINUTE);

        date = (TextView) findViewById(R.id.tvDate);
        time = (TextView) findViewById(R.id.tvTime);
        date.setText(d + "/" + m + "/" + y);
        time.setText(h + ":" + mn);

        dateChange = (Button) findViewById(R.id.btChonNgay);
        timeChange = (Button) findViewById(R.id.btChonGio);
        addTask = (Button) findViewById(R.id.btAdd);

        dateChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        date.setText(dayOfMonth + "/" + monthOfYear + "/" + year);
                    }
                };

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, dateSetListener, y, m, d);
                datePickerDialog.setTitle("Chọn ngày");
                datePickerDialog.show();
            }
        });

        timeChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        time.setText(hourOfDay + ":" + minute);
                    }
                };
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, timeSetListener, h, mn, true);
                timePickerDialog.setTitle("Chọn giờ");
                timePickerDialog.show();

            }
        });

        ////////////////////////////
        tenCV = (EditText) findViewById(R.id.edTenCV);
        ndCV = (EditText) findViewById(R.id.edND);
        danhSach = (ListView) findViewById(R.id.lvCongViec);

        loadList();

        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arr.add("Tên CV: " + tenCV.getText() + "\nNội Dung: " + ndCV.getText() + "\nThời gian: " + time.getText() + "-" + date.getText());
                loadList();
                ///////////////////////////////////////
                ndCV.setText("");
                tenCV.setText("");
                date.setText(d + "/" + m + "/" + y);
                time.setText(h + ":" + mn);
            }
        });

    }

    public void loadList() {
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arr);
        danhSach.setAdapter(adapter);
    }
}
