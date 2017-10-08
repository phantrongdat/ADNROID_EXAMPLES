package com.example.alone.datepicker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.lang.reflect.TypeVariable;

public class MainActivity extends ActionBarActivity {
    DatePicker datePicker;
    Button btSet;
    TextView tvDate;
    int d,m,y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker=(DatePicker)findViewById(R.id.dpDatepicker);
        tvDate=(TextView)findViewById(R.id.tvDate);
        btSet=(Button)findViewById(R.id.btSetDate);
        btSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=datePicker.getDayOfMonth();
                m=datePicker.getMonth()+1;
                y=datePicker.getYear();

                tvDate.setText(d+"/"+m+"/"+y);
            }
        });

    }
}
