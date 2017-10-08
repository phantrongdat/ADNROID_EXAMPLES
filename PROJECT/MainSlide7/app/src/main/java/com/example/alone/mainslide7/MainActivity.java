package com.example.alone.mainslide7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btSpinner=(Button)findViewById(R.id.btSpinner);
        btSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent spinner = new Intent(MainActivity.this, Spinner.class);
                startActivity(spinner);
            }
        });
        Button btListView=(Button)findViewById(R.id.btListView);
        btListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listview=new Intent(MainActivity.this,ListView1.class);
                startActivity(listview);
            }
        });

        Button btDatePicker=(Button)findViewById(R.id.btDatePicker);
        btDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent datePicker=new Intent(MainActivity.this,DatePicker3.class);
                startActivity(datePicker);
            }
        });
    }
}
