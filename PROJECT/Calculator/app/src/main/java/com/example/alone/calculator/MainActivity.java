package com.example.alone.calculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button cal1=(Button)findViewById(R.id.btnCal);

        Button cal2=(Button)findViewById(R.id.btnCAL2);

        cal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cal=new Intent(MainActivity.this,Calculator_activity.class);
                startActivity(cal);
            }
        });

        cal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cal=new Intent(MainActivity.this,Calculator.class);
                startActivity(cal);
            }
        });
    }
}
