package com.example.alone.myapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    int sum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        //CheckBox cb1=(CheckBox)findViewById(R.id.check1);
        /*
        Button bt=(Button)findViewById(R.id.ok);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast;
                EditText user=(EditText)findViewById(R.id.editText);
                EditText pass=(EditText)findViewById(R.id.editText2);
                String u=user.getText().toString();
                String p=pass.getText().toString();

                if (u=="fit"&&p=="utehy")
                {
                    toast=Toast.makeText(MainActivity.this,"Login Success",Toast.LENGTH_LONG);
                    toast.show();
                }else
                {
                    toast=Toast.makeText(MainActivity.this,"Error", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        */
    }


    public void login(View v)
    {
        Toast toast;
        EditText user=(EditText)findViewById(R.id.editText);
        EditText pass=(EditText)findViewById(R.id.editText2);

        String u=user.getText().toString()+"";
        String p=pass.getText().toString()+"";
        String u0="fit";
        String p0="utehy";
        if (u==u0&&p==p0)
        {
            toast=Toast.makeText(MainActivity.this,"Login Success",Toast.LENGTH_LONG);
            toast.show();
            setContentView(R.layout.activity_main);
        }else
        {
            toast=Toast.makeText(MainActivity.this,"Error", Toast.LENGTH_LONG);
            toast.show();
            setContentView(R.layout.check_layout);
        }
    }
    public void total(View v) {
        TextView total = (TextView) findViewById(R.id.total1);
        boolean check = ((CheckBox) v).isChecked();
        String t = "Total: ";
        if (check) {
            switch (v.getId()) {
                case R.id.check1:

                    sum += 15000000;
                    total.setText(t + sum);

                    break;
                case R.id.check2:
                    sum += 10000000;
                    total.setText(t + sum);
                    break;
                case R.id.check3:
                    sum += 250000;
                    total.setText(t + sum);
                    break;
                case R.id.check4:
                    sum += 300000;
                    total.setText(t + sum);
                    break;
            }
        }
    }
}
