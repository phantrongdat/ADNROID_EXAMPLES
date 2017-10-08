package com.example.alone.controlview;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class DatePickerDialogView extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_dialog_view);
        getSupportActionBar().setTitle("DatePicker Dialog");

        Calendar c=Calendar.getInstance();
        final int y=c.get(Calendar.YEAR);
        final int m=c.get(Calendar.MONTH)+1;
        final int d=c.get(Calendar.DAY_OF_MONTH);

        final TextView today=(TextView)findViewById(R.id.tvToday);
        today.setText(d+"/"+m+"/"+y);

        final DatePickerDialog.OnDateSetListener set=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                today.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
            }
        };

        String s=today.getText().toString();
        String [] a=s.split("/");
        final int day=Integer.parseInt(a[0]);
        final int month=Integer.parseInt(a[1])+1;
        final int year=Integer.parseInt(a[2]);

        Button btChange=(Button)findViewById(R.id.btChange);
        btChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog dl = new DatePickerDialog(DatePickerDialogView.this, set,y,m,d);
                dl.setTitle("Chon ngay thang");
                dl.show();
            }
        });


    }


}
