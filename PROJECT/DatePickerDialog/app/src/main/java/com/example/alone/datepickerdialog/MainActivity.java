package com.example.alone.datepickerdialog;

import android.app.DatePickerDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends ActionBarActivity {
    Button btSet;
    TextView tvDate;
    int d, m, y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar c = Calendar.getInstance();
        d = c.get(Calendar.DAY_OF_MONTH);
        m = c.get(Calendar.MONTH) + 1;
        y = c.get(Calendar.YEAR);

        btSet = (Button) findViewById(R.id.btSetDate);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvDate.setText(d + "/" + m + "/" + y);
        btSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener set = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvDate.setText(dayOfMonth + "/" + monthOfYear + "/" + year);

                        String[] get = tvDate.getText().toString().split("/");
                        d = Integer.parseInt(get[0]);
                        m = Integer.parseInt(get[1]);
                        y = Integer.parseInt(get[2]);

                    }
                };

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, set, y, m, d);
                datePickerDialog.setTitle("Chọn ngày : ");
                datePickerDialog.show();
            }
        });

    }
}
