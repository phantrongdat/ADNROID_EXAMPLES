package com.example.alone.mycalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity  implements View.OnClickListener {

    private Button num0,num1,num2,num3,num4,num5,num6,num7,num8,num9,add,sub,mul,div,dot,eql;
    private Button clear,about,exit;
    private EditText edt;
    private EditText edNum1;
    private EditText edNum2;
    private TextView result;
    private TextView init;
    private RelativeLayout background;
    private String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNum1=(EditText)findViewById(R.id.edNum1);
        edNum2=(EditText)findViewById(R.id.edNum2);

        edt=(EditText)findViewById(R.id.edNum1);

        result=(TextView)findViewById(R.id.tvResult);
        init=(TextView)findViewById(R.id.init);


        background=(RelativeLayout)findViewById(R.id.background);
        background.setBackgroundResource(R.drawable.background);


        num0 = (Button) findViewById(R.id.num0);
        num1 = (Button) findViewById(R.id.num1);
        num2 = (Button) findViewById(R.id.num2);
        num3 = (Button) findViewById(R.id.num3);
        num4 = (Button) findViewById(R.id.num4);
        num5 = (Button) findViewById(R.id.num5);
        num6 = (Button) findViewById(R.id.num6);
        num7 = (Button) findViewById(R.id.num7);
        num8 = (Button) findViewById(R.id.num8);
        num9 = (Button) findViewById(R.id.num9);

        dot=(Button)findViewById(R.id.dot);
        eql=(Button)findViewById(R.id.eql);

        add=(Button)findViewById(R.id.add);
        sub=(Button)findViewById(R.id.sub);
        mul=(Button)findViewById(R.id.mul);
        div=(Button)findViewById(R.id.div);

        clear=(Button)findViewById(R.id.btClear);
        about=(Button)findViewById(R.id.btAbout);
        exit=(Button)findViewById(R.id.btExit);

        num0.setOnClickListener(MainActivity.this);
        num1.setOnClickListener(MainActivity.this);
        num2.setOnClickListener(MainActivity.this);
        num3.setOnClickListener(MainActivity.this);
        num4.setOnClickListener(MainActivity.this);
        num5.setOnClickListener(MainActivity.this);
        num6.setOnClickListener(MainActivity.this);
        num7.setOnClickListener(MainActivity.this);
        num8.setOnClickListener(MainActivity.this);
        num9.setOnClickListener(MainActivity.this);

        dot.setOnClickListener(MainActivity.this);
        eql.setOnClickListener(MainActivity.this);

        add.setOnClickListener(MainActivity.this);
        sub.setOnClickListener(MainActivity.this);
        mul.setOnClickListener(MainActivity.this);
        div.setOnClickListener(MainActivity.this);

        clear.setOnClickListener(MainActivity.this);
        about.setOnClickListener(MainActivity.this);
        //exit.setOnClickListener(MainActivity.this);
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.eql) {
            double num1 = Double.parseDouble(edNum1.getText().toString());
            double num2 = Double.parseDouble(edNum2.getText().toString());

            if (init.getText().toString() == "+") {
                double res = num1 + num2;
                result.setText("Result: "+res);
            }

            if (init.getText().toString() == "-") {
                double res = num1 - num2;
                result.setText("Result: "+res);
            }

            if (init.getText().toString() == "*") {
                double res = num1 * num2;
                result.setText("Result: "+res);
            }

            if (init.getText().toString() == "/") {
                double res = num1 / num2;
                result.setText("Result: "+res);
            }

        } else {

            if (v.getId() == R.id.add || v.getId() == R.id.sub || v.getId() == R.id.mul || v.getId() == R.id.div) {
                edt = (EditText) findViewById(R.id.edNum2);
            }

            String s = edt.getText().toString() + "";
            switch (v.getId()) {
                case R.id.num0:
                    edt.setText(s + "0");
                    break;
                case R.id.num1:
                    edt.setText(s + "1");
                    break;
                case R.id.num2:
                    edt.setText(s + "2");
                    break;
                case R.id.num3:
                    edt.setText(s + "3");
                    break;
                case R.id.num4:
                    edt.setText(s + "4");
                    break;
                case R.id.num5:
                    edt.setText(s + "5");
                    break;
                case R.id.num6:
                    edt.setText(s + "6");
                    break;
                case R.id.num7:
                    edt.setText(s + "7");
                    break;
                case R.id.num8:
                    edt.setText(s + "8");
                    break;
                case R.id.num9:
                    edt.setText(s + "9");
                    break;
                case R.id.dot:
                    edt.setText(s + ".");
                    break;
                case R.id.add:
                    init.setText("+");
                    break;
                case R.id.sub:
                    init.setText("-");
                    break;
                case R.id.mul:
                    init.setText("*");
                    break;
                case R.id.div:
                    init.setText("/");
                    break;
                case R.id.btClear:
                    Intent clear=new Intent(MainActivity.this,MainActivity.class);
                    startActivity(clear);
                    break;
                case R.id.btAbout:
                    Intent about=new Intent(MainActivity.this,About.class);
                    startActivity(about);
                    break;
                case R.id.btExit:
                    break;
            }
        }
    }

    public void exit(View v)
    {
        AlertDialog.Builder exit=new AlertDialog.Builder(MainActivity.this);
        exit.setTitle("My Calculator");
        exit.setMessage("Exit program ?");
        exit.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                System.exit(0);
            }
        });
        exit.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        exit.create().show();
    }

}
