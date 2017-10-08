package com.example.alone.androidstart;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
    EditText hello;
    Button name,address,age,phone,mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hello=(EditText)findViewById(R.id.hello1);

        address=(Button)findViewById(R.id.btAddress);
        name=(Button)findViewById(R.id.btName);
        age=(Button)findViewById(R.id.btAge);
        phone=(Button)findViewById(R.id.btPhone);
        mail=(Button)findViewById(R.id.btMail);

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hello.setText("PHAN TRONG DAT");
            }
        });

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hello.setText("Khoai Chau - Hung Yen");
            }
        });


        age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hello.setText("19+");
            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hello.setText("01657586636");
            }
        });

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hello.setText("aloneptd@gmail.com");
            }
        });

    }
}
