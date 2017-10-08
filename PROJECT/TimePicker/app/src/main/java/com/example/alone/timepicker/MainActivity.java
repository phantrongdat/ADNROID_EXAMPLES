package com.example.alone.timepicker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends ActionBarActivity {
    TimePicker tpTime;
    Button btSet;
    TextView tvTime;
    int h,m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tpTime=(TimePicker)findViewById(R.id.tpTime);
        btSet=(Button)findViewById(R.id.btSetTime);
        tvTime=(TextView)findViewById(R.id.tvTime);

        btSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h=tpTime.getCurrentHour();
                m=tpTime.getCurrentMinute();

                tvTime.setText(h+":"+m);
            }
        });
    }
}
