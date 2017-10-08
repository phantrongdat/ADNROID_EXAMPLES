package com.example.alone.androidcontrol;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity implements View.OnClickListener{
    private Button bt0,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,btDot,btAdd,btSub,btMul,btDiv,btQue;
    private EditText edtNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt0=(Button)findViewById(R.id.bt0);
        bt1=(Button)findViewById(R.id.bt1);
        bt2=(Button)findViewById(R.id.bt2);
        bt3=(Button)findViewById(R.id.bt3);
        bt4=(Button)findViewById(R.id.bt4);
        bt5=(Button)findViewById(R.id.bt5);
        bt6=(Button)findViewById(R.id.bt6);
        bt7=(Button)findViewById(R.id.bt7);
        bt8=(Button)findViewById(R.id.bt8);
        bt9=(Button)findViewById(R.id.bt9);

        btDot=(Button)findViewById(R.id.btDot);
        btAdd=(Button)findViewById(R.id.btAdd);
        btSub=(Button)findViewById(R.id.btSub);
        btMul=(Button)findViewById(R.id.btMul);
        btDiv=(Button)findViewById(R.id.btDiv);
        btQue=(Button)findViewById(R.id.btQue);

        edtNumber=(EditText)findViewById(R.id.edNumber);



        bt0.setOnClickListener(this);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        final String s=edtNumber.getText().toString();
        switch (v.getId())
        {
            case R.id.bt0:
                edtNumber.setText(s+"0");
                break;
            case R.id.bt1:
                edtNumber.setText(s+"0");
                break;
            case R.id.bt2:
                edtNumber.setText(s+"0");
                break;
            case R.id.bt3:
                edtNumber.setText(s+"0");
                break;
            case R.id.bt4:
                edtNumber.setText(s+"0");
                break;
            case R.id.bt5:
                edtNumber.setText(s+"0");
                break;
            case R.id.bt6:
                edtNumber.setText(s+"0");
                break;
            case R.id.bt7:
                edtNumber.setText(s+"0");
                break;
            case R.id.bt8:
                edtNumber.setText(s+"0");
                break;
            case R.id.bt9:
                edtNumber.setText(s+"0");
                break;

        }
    }
}
