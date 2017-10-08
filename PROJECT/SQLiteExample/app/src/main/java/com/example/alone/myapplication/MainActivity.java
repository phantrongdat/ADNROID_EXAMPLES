package com.example.alone.myapplication;

import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {
    MyDatabase mydb = new MyDatabase(this);

    EditText user, password;
    ListView list;
    ArrayList<String> arr = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.edtUser);
        password = (EditText) findViewById(R.id.edtPassword);

        list = (ListView) findViewById(R.id.lvAccount);

        mydb.copyDB2SDCard();
    }

    public void load() {
        Cursor c = mydb.getCursor("SELECT*FROM Account");
        if (c.moveToFirst()) {
            do {
                String row = c.getString(0) + " - " + c.getString(1);
                arr.add(row);
            } while (c.moveToNext());
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        list.setAdapter(adapter);
    }

    public void insertDB(View view) {
        int id = mydb.getCount("SELECT*FROM Account WHERE ID='" + user.getText().toString() + "'");
        if (id != 0) {
            mydb.executeDB("INSERT INTO Account VALUES('" + user.getText().toString() + "','" + password.getText().toString() + "')");
        } else {
            Toast.makeText(MainActivity.this, "ID is exist!", Toast.LENGTH_LONG).show();
        }
        load();
    }

    public void updateDB(View view) {
        mydb.executeDB("UPDATE Account SET password='" + password.getText().toString() + "' WHERE ID='" + user.getText().toString() + "'");
        load();
    }

    public void deleteDB(View view) {
        mydb.executeDB("DELETE FROM Account WHERE ID='" + user.getText().toString() + "'");
        load();
    }
}
