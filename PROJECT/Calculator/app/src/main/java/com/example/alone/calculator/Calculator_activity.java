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

import java.util.ArrayList;

/**
 * Created by Alone on 01/27/2016.
 */
public class Calculator_activity extends ActionBarActivity implements View.OnClickListener {
    private Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9, add, sub, mul, div, dot, equ;
    private Button clear, about, exit;
    private EditText edt;
    private TextView result;
    int i=0;
    double kq=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        getSupportActionBar().setTitle("My Calculator");

        edt = (EditText) findViewById(R.id.edNum);

        result = (TextView) findViewById(R.id.tvResult);

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

        dot = (Button) findViewById(R.id.dot);
        equ = (Button) findViewById(R.id.equ);

        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        mul = (Button) findViewById(R.id.mul);
        div = (Button) findViewById(R.id.div);

        clear = (Button) findViewById(R.id.btClear);
        about = (Button) findViewById(R.id.btAbout);
        exit = (Button) findViewById(R.id.btExit);

        num0.setOnClickListener(Calculator_activity.this);
        num1.setOnClickListener(Calculator_activity.this);
        num2.setOnClickListener(Calculator_activity.this);
        num3.setOnClickListener(Calculator_activity.this);
        num4.setOnClickListener(Calculator_activity.this);
        num5.setOnClickListener(Calculator_activity.this);
        num6.setOnClickListener(Calculator_activity.this);
        num7.setOnClickListener(Calculator_activity.this);
        num8.setOnClickListener(Calculator_activity.this);
        num9.setOnClickListener(Calculator_activity.this);

        dot.setOnClickListener(Calculator_activity.this);
        equ.setOnClickListener(Calculator_activity.this);

        add.setOnClickListener(Calculator_activity.this);
        sub.setOnClickListener(Calculator_activity.this);
        mul.setOnClickListener(Calculator_activity.this);
        div.setOnClickListener(Calculator_activity.this);

        clear.setOnClickListener(Calculator_activity.this);
        about.setOnClickListener(Calculator_activity.this);
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.equ) {
            String s = edt.getText().toString();
            ArrayList<String> arr=new ArrayList<String>();

            if (!s.equals("+")&&!s.equals("-")&&!s.equals("*")&&!s.equals("/"))
            {
                arr.get(i).concat(s);
            }
            else
            {
                i++;
                arr.get(i).concat(s);
                i++;
            }
            kq=Double.parseDouble(arr.get(0));
            for (int j=0;j<arr.size();j++)
            {
                if (arr.get(i).equals("+"));
                {

                }

            }

        }

        String s = edt.getText().toString();
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
                edt.setText(s + "+");
                break;
            case R.id.sub:
                edt.setText(s + "-");
                break;
            case R.id.mul:
                edt.setText(s + "*");
                break;
            case R.id.div:
                edt.setText(s + "/");
                break;
            case R.id.btClear:
                edt.setText("");
                result.setText("");
                break;
            case R.id.btAbout:
                Intent about = new Intent(Calculator_activity.this, About.class);
                startActivity(about);
                break;
        }
    }


    public void exit(View v) {
        AlertDialog.Builder exit = new AlertDialog.Builder(Calculator_activity.this);
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
