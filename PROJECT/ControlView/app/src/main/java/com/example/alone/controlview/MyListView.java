package com.example.alone.controlview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MyListView extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_view);
        getSupportActionBar().setTitle("ListView");

        ListView listView = (ListView) findViewById(R.id.lvDanhSach);
        //
        final ArrayList<String> list = new ArrayList<String>();
        list.add("Phan Trong Dat");
        list.add("Ta Duy Chien");
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);

        listView.setAdapter(adapter);
        final int[] soThuTu = {0};

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                soThuTu[0] = position;
            }
        });
        final EditText edt=(EditText)findViewById(R.id.edList);
        Button btInsert=(Button)findViewById(R.id.btInsert);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add(edt.getText()+"");

            }
        });

        Button btDelete=(Button)findViewById(R.id.btDelete);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(soThuTu[0]);

            }
        });

    }
}

