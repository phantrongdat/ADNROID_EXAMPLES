package com.example.alone.calculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by Alone on 1/10/2016.
 */
public class RadioButton1 extends ActionBarActivity {
    private RadioButton rbAsus,rbHp,rbDell,rbAcer,rbLenovo;
    private Button btOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);


        rbAsus=(RadioButton)findViewById(R.id.rbAsus);
        rbHp=(RadioButton)findViewById(R.id.rbHp);
        rbDell=(RadioButton)findViewById(R.id.rbDell);
        rbAcer=(RadioButton)findViewById(R.id.rbAcer);
        rbLenovo=(RadioButton)findViewById(R.id.rbLenovo);

        rbAsus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true)
                {
                    Toast.makeText(RadioButton1.this, "Selected Laptop ASUS", Toast.LENGTH_SHORT).show();
                }
            }
        });


        rbAcer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true)
                {
                    Toast.makeText(RadioButton1.this,"Selected Laptop ACER",Toast.LENGTH_SHORT).show();
                }
            }
        });

        rbDell.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true)
                {
                    Toast.makeText(RadioButton1.this,"Selected Laptop DELL",Toast.LENGTH_SHORT).show();
                }
            }
        });

        rbLenovo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    Toast.makeText(RadioButton1.this, "Selected Laptop LENOVO", Toast.LENGTH_SHORT).show();
                }
            }
        });

        rbHp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) {
                    Toast.makeText(RadioButton1.this, "Selected Laptop HP", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
