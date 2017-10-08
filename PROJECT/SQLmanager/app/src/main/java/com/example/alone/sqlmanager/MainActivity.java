package com.example.alone.sqlmanager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    MyDatabase db = new MyDatabase(this);
    Button get;
    ListView lv;
    ArrayList<String> arr = new ArrayList<String>();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lv = (ListView) findViewById(R.id.lvwAccount);

        get = (Button) findViewById(R.id.btGet);

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execute("CREATE TABLE IF NOT EXISTS Account( id varchar(15) PRIMARY KEY,password varchar(50) NOT NULL)");

                if (db.getRow("SELECT *FROM Account WHERE id='admin'") == 0) {
                    db.execute("INSERT INTO Account VALUES ('admin','admin')");
                }
                loadData();
            }

        });
    }

    public void loadData() {
        arr = new ArrayList<String>();
        Cursor c = db.executeQuery("SELECT*FROM Account");
        while (c.moveToNext()) {
            arr.add(c.getString(0) + " - " + c.getString(1));
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        lv.setAdapter(adapter);
    }
}
