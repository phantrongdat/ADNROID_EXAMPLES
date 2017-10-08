package com.example.alone.taskmanagement;

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

    private EditText edtName, edtContent;
    private TextView tvDate, tvTime;
    Calendar c;
    private Button btAdd, btSetDate, btSetTime;
    private ListView lvTask;
    private ArrayList<String> arrayList = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    private int d, m, y, h, mn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c = Calendar.getInstance();
        d = c.get(Calendar.DAY_OF_MONTH);
        m = c.get(Calendar.MONTH) + 1;
        y = c.get(Calendar.YEAR);
        h = c.get(Calendar.HOUR);
        mn = c.get(Calendar.MINUTE);

        edtName = (EditText) findViewById(R.id.edtName);
        edtContent = (EditText) findViewById(R.id.edtContent);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvTime = (TextView) findViewById(R.id.tvTime);

        lvTask = (ListView) findViewById(R.id.lvTask);
        btSetDate = (Button) findViewById(R.id.btSetDay);
        btSetTime = (Button) findViewById(R.id.btSetTime);
        btAdd = (Button) findViewById(R.id.btAddTask);

        tvDate.setText(c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR));
        tvTime.setText(c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE));

        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
        lvTask.setAdapter(adapter);

        btSetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog.OnDateSetListener setDate = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                        String[] get = tvDate.getText().toString().split("/");
                        d = Integer.parseInt(get[0]);
                        m = Integer.parseInt(get[1]);
                        y = Integer.parseInt(get[2]);

                    }
                };

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, setDate, y, m, d);
                datePickerDialog.setTitle("SET DATE");
                datePickerDialog.show();
            }
        });

        btSetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog.OnTimeSetListener setTime = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvTime.setText(hourOfDay + ":" + minute);

                        String[] get = tvTime.getText().toString().split(":");
                        h = Integer.parseInt(get[0]);
                        mn = Integer.parseInt(get[1]);
                    }
                };

                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, setTime, h, mn, true);
                timePickerDialog.setTitle("SET TIME");
                timePickerDialog.show();
            }
        });

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String put = edtName.getText() + "\n" + edtContent.getText() + "\n" + tvTime.getText() + " - " + tvDate.getText();
                arrayList.add(put);
                adapter.notifyDataSetChanged();

                tvDate.setText(c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR));
                tvTime.setText(c.get(Calendar.HOUR) + ":" + c.get(Calendar.MINUTE));
                edtName.setText("");
                edtContent.setText("");
            }
        });
    }
}
