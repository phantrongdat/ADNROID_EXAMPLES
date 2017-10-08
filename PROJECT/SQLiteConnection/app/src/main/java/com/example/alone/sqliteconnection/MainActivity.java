package com.example.alone.sqliteconnection;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    MyDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new MyDatabase(this);
        getActionBar();

//        Cursor c=db.getData("SELECT*FROM tblAccount");
//        while (c.moveToNext())
//        {
//            Toast.makeText(this,c.getString(0)+"|"+c.getString(1), Toast.LENGTH_LONG).show();
//        }
    }
}
