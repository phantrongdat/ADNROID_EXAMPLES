package com.dat17.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewControl extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_control);

        listView = (ListView) findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        arrayList.add("Quy");
        arrayList.add("Truc");
        arrayList.add("Duy");

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                                                Toast.makeText(ListViewControl.this, arrayList.get(position).toString(), Toast.LENGTH_SHORT).show();
                                            }
                                        }
        );
    }
}
