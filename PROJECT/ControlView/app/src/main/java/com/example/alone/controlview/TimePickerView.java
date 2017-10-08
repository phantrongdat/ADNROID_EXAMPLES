package com.example.alone.controlview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class TimePickerView extends ActionBarActivity {
    TimePicker tp;
    TextView time;
    int h,m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_view);
        getSupportActionBar().setTitle("TimePicker");

        tp=(TimePicker)findViewById(R.id.tpTimePicker);
        time=(TextView)findViewById(R.id.tvTime);

        Button bt =(Button)findViewById(R.id.btGetTime);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time.setText(tp.getCurrentHour()+":"+tp.getCurrentMinute());
                //Toast.makeText(TimePickerView.this,tp.getCurrentHour()+":"+tp.getCurrentMinute(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
