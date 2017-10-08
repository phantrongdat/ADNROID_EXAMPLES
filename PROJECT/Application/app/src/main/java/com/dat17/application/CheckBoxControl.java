package com.dat17.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;


    public class CheckBoxControl extends AppCompatActivity {
    CheckBox cbxQui,cbxHa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_control);

        cbxQui=(CheckBox)findViewById(R.id.idQui);
        cbxHa=(CheckBox)findViewById(R.id.idHa);

        if (cbxQui.isChecked())
        {
            Toast.makeText(CheckBoxControl.this, "Check QUI", Toast.LENGTH_SHORT).show();
        }

        if (cbxHa.isChecked()) {
            Toast.makeText(CheckBoxControl.this, "Check Ha", Toast.LENGTH_SHORT).show();
        }

    }
}
