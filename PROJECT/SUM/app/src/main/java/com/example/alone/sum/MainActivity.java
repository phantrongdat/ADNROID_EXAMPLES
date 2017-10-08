package com.example.alone.sum;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    EditText num1,num2;
    TextView diplay;
    Button add,sub,mul,div;
    double result=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1=(EditText)findViewById(R.id.edtNum1);
        num2=(EditText)findViewById(R.id.edtNum2);
        diplay=(TextView)findViewById(R.id.txtResult);

        add=(Button)findViewById(R.id.btnAdd);
        sub=(Button)findViewById(R.id.btnSub);
        mul=(Button)findViewById(R.id.btnMul);
        div=(Button)findViewById(R.id.btnDiv);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result=Double.parseDouble(num1.getText().toString())+Double.parseDouble(num2.getText().toString());
                diplay.setText(result+"");
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result=Double.parseDouble(num1.getText().toString())-Double.parseDouble(num2.getText().toString());
                diplay.setText(result+"");
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result=Double.parseDouble(num1.getText().toString())*Double.parseDouble(num2.getText().toString());
                diplay.setText(result+"");
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result=Double.parseDouble(num1.getText().toString())/Double.parseDouble(num2.getText().toString());
                diplay.setText(result+"");
            }
        });
    }
}
