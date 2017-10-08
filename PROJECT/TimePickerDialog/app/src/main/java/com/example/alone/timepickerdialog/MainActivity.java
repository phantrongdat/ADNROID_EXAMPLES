package com.example.alone.timepickerdialog;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends ActionBarActivity {
    Button btSet;
    TextView tvTime;
    int h,m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar c=Calendar.getInstance();
        h=c.get(Calendar.HOUR);
        m=c.get(Calendar.MINUTE);

        tvTime=(TextView)findViewById(R.id.tvTime);

        tvTime.setText(h+":"+m);

        btSet=(Button)findViewById(R.id.btSetTime);
        btSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog.OnTimeSetListener set=new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvTime.setText(hourOfDay+":"+minute);

                        String[] get=tvTime.getText().toString().split(":");
                        h=Integer.parseInt(get[0]);
                        m=Integer.parseInt(get[1]);
                    }
                };

                TimePickerDialog timePickerDialog=new TimePickerDialog(MainActivity.this,set,h,m,true);
                timePickerDialog.setTitle("Chọn thời gian: ");
                timePickerDialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
