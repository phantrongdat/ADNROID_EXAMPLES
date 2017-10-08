package com.example.alone.calculator;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Alone on 1/13/2016.
 */
public class register extends ActionBarActivity
{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        ListView huongDan=(ListView)findViewById(R.id.listHD);
        ArrayList<String> list1=new ArrayList<String>();

        list1.add("huong,huongpass");
        list1.add("taikhoan1");
        list1.add("myuser");
        list1.add("username01");
        list1.add("username02");

        ArrayAdapter adapter=new ArrayAdapter(register.this,android.R.layout.simple_list_item_1,list1);

        huongDan.setAdapter(adapter);

    }

}
