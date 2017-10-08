package com.example.alone.listview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=(ListView)findViewById(R.id.listLaptop);

        ArrayList<String> lap=new ArrayList<String>();
        lap.add("DELL");
        lap.add("HP");
        lap.add("ASUS");
        lap.add("MICROSOFT");
        lap.add("APPLE");
        lap.add("LENOVO");
        lap.add("THINKPAD");
        lap.add("IBM");
        lap.add("SONY");
        lap.add("SAMSUNG");
        lap.add("TOSHIBA");
        lap.add("FUJITSU");
        lap.add("BENQ");
        lap.add("HPPRO");
        lap.add("GIGABYTE");
        lap.add("EXPER");
        lap.add("ACER");

        ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_activated_1,lap);

        listView.setAdapter(arrayAdapter);
    }
}
