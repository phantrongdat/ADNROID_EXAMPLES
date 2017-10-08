package com.example.alone.mainslide7;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class DatePicker3 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker3);
        final TextView tvDateTime = (TextView) findViewById(R.id.tvDatePicker);
        DatePicker dp=(DatePicker)findViewById(R.id.dpDatePicker);
        dp = (DatePicker) findViewById(R.id.dpDatePicker);

        final int day = dp.getDayOfMonth();
        final int month = dp.getMonth();
        final int year = dp.getYear();

        dp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDateTime.setText(day + "/" + month + "/" + year);
            }
        });
    }
}
