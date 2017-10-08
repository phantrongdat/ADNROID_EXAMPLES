package com.example.alone.review;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class InputDialog_Review extends ActionBarActivity {
    TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_dialog__review);
        display=(TextView)findViewById(R.id.txtResult);
    }

    public void input(View v){
        LayoutInflater inflater=getLayoutInflater();
        View view=inflater.inflate(R.layout.input, null);
        final EditText number1=(EditText)view.findViewById(R.id.edtNumber1);
        final EditText number2=(EditText)view.findViewById(R.id.edtNumber2);
        AlertDialog.Builder al=new AlertDialog.Builder(this);
        al.setView(view);
        al.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int sum = Integer.parseInt(number1.getText().toString()) + Integer.parseInt(number2.getText().toString());
                display.setText(sum + "");
            }
        });

        al.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        al.create().show();
    }
}
