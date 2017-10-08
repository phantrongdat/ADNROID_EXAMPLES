package com.example.alone.listviewcustom;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv=(ListView)findViewById(R.id.lvwListview);
        ArrayList<Account> arr=new ArrayList<Account>();
        arr.add(new Account("admin","123456","12/12/2012"));
        arr.add(new Account("dat","123","12/12/2012"));
        arr.add(new Account("alone","123456","12/12/2012"));

        ArrayAccount adapter=new ArrayAccount(MainActivity.this,R.layout.custom_list_account,arr);
        lv.setAdapter(adapter);
    }
}
