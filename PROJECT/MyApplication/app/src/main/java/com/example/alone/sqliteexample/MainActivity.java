package com.example.alone.sqliteexample;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    MyDatabase db=new MyDatabase(this);

    ArrayList<String> arrayList=new ArrayList<String>();
    ArrayAdapter<String> adapter=null;
    ListView ds;
    Button them,sua,xoa;
    EditText tk,mk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ////////////////////
        //db.copyDB2SDCard();
        ////////////////////
        tk=(EditText)findViewById(R.id.edTK);
        mk=(EditText)findViewById(R.id.edMK);
        ds=(ListView)findViewById(R.id.lvDSTK);
        load();
    }

    public void load()
    {
        Cursor c=db.getCursor("SELECT *FROM Account");
        if (c.moveToFirst()){
            do {
                String row=c.getString(0)+" - "+c.getString(1);
                arrayList.add(row);
            }while (c.moveToNext());
        }
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        ds.setAdapter(adapter);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
