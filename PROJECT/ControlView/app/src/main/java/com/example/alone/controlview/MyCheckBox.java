package com.example.alone.controlview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MyCheckBox extends ActionBarActivity {

    private CheckBox cbLaptop,cbMouse,cbKeyboard,cbCombo;
    private Button submit;
    private TextView total;
    private int sum=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_check_box);
        getSupportActionBar().setTitle("CheckBox");

        cbLaptop=(CheckBox)findViewById(R.id.cbLaptop);
        cbMouse=(CheckBox)findViewById(R.id.cbMouse);
        cbKeyboard=(CheckBox)findViewById(R.id.cbKeyboard);
        cbCombo=(CheckBox)findViewById(R.id.cbCombo);

        total=(TextView)findViewById(R.id.tvTotal);

        cbLaptop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true) sum+=15000000;
                else sum-=15000000;

                total.setText("Total: "+sum);
            }
        });

        cbMouse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true) sum+=200000;
                else sum-=200000;

                total.setText("Total: "+sum);
            }
        });

        cbKeyboard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) sum += 300000;
                else sum -= 300000;

                total.setText("Total: " + sum);
            }
        });

        cbCombo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked == true) sum += 15250000;
                else sum -= 15250000;

                total.setText("Total: " + sum);
            }
        });

    }
}
