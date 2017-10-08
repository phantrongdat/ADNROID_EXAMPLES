package com.example.alone.controlview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class DatePickerView extends ActionBarActivity {
    int y,m,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_view);
        getSupportActionBar().setTitle("DatePicker");

        final DatePicker dp=(DatePicker)findViewById(R.id.dpDatePicker);



        final TextView tvToday=(TextView)findViewById(R.id.tvToday);
        Button btGet=(Button)findViewById(R.id.btGetTime);

        btGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                y=dp.getYear();
                m=dp.getMonth()+1;
                d=dp.getDayOfMonth();
                tvToday.setText(d+"/"+m+"/"+y);
            }
        });
    }
}
