package com.example.alone.review;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Spinner_Review extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner__review);
        ArrayList<String> arr = new ArrayList<String>();
        ArrayAdapter adap = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arr);
        adap.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        Spinner spn = (Spinner) findViewById(R.id.spnSpinner);
        spn.setAdapter(adap);

        final TextView display=(TextView)findViewById(R.id.txtSpinner);
        arr.add("Phan Trong Dat");
        arr.add("Ta Duy Chien");
        arr.add("Vu Duc Hanh");
        adap.notifyDataSetChanged();

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 1: display.setText("PHAN TRONG DAT");break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
