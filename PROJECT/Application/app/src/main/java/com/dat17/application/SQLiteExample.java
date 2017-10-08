package com.dat17.application;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SQLiteExample extends AppCompatActivity {
    SQLiteHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_example);
        db=new SQLiteHandler(this);
        Cursor c;
        c=db.executeQuery("SELECT * FROM tblSV");

        while (c.moveToNext())
        {
            Toast.makeText(SQLiteExample.this, c.getInt(0)+c.getString(1), Toast.LENGTH_SHORT).show();
        }
    }
}
