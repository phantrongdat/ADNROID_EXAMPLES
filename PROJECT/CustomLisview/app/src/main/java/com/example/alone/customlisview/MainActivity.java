package com.example.alone.customlisview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {
    ListView list;
    AdapterCustom adap;
    ArrayList<String> arr=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView)findViewById(R.id.lsvList);
        arr.add("Search");
        arr.add("Search focus");
        arr.add("News");
        arr.add("News focus");
        arr.add("Notification");
        arr.add("Notification focus");
        adap=new AdapterCustom(this,R.layout.list_custom,arr);
        AlertDialog.Builder al=new AlertDialog.Builder(this);
        al.setAdapter(adap, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which)
                {
                    case 0 :
                        Toast.makeText(MainActivity.this,"Search",Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
        al.setTitle("Option");
        al.create().show();
        //list.setAdapter(adap);
    }
}
