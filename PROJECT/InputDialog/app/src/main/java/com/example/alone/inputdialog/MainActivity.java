package com.example.alone.inputdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    EditText num1, num2;
    Button input;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.txtResult);
        input = (Button) findViewById(R.id.btInput);

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder al = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater().from(MainActivity.this);
                final View view = inflater.inflate(R.layout.input, null);
                al.setView(view);

//                Dialog dlg=new Dialog(MainActivity.this);
//                dlg.setContentView(R.layout.input);

                al.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        num1 = (EditText) view.findViewById(R.id.edtNum1);
                        num2 = (EditText) view.findViewById(R.id.edtNum2);
                        int sum = Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString());
                        result.setText(sum + "");
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
        });

    }
}
