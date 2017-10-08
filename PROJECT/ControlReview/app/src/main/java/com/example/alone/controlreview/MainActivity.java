package com.example.alone.controlreview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    RadioButton btr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView display = (TextView) findViewById(R.id.txtDisplay);
        Button input = (Button) findViewById(R.id.btInput);

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                final View view = inflater.inflate(R.layout.input, null);

                AlertDialog.Builder al = new AlertDialog.Builder(MainActivity.this);
                al.setView(view);
                al.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String num1 = ((EditText) view.findViewById(R.id.edtNum1)).getText().toString();
                        String num2=((EditText) view.findViewById(R.id.edtNum2)).getText().toString();
                        int sum=Integer.parseInt(num1)+Integer.parseInt(num2);
                        display.setText(sum+"");
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
