package com.example.alone.review;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.zip.Inflater;

public class Menu_Review extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__review);
        Button menu1, menu2;
        menu1=(Button)findViewById(R.id.btnMenu1);
        menu2=(Button)findViewById(R.id.btnMenu2);
        registerForContextMenu(menu1);
        registerForContextMenu(menu2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId())
        {
            case R.id.btnMenu1:
                getMenuInflater().inflate(R.menu.menu1,menu);break;
            case R.id.btnMenu2:
                getMenuInflater().inflate(R.menu.menu2,menu);break;
        }

        //super.onCreateContextMenu(menu, v, menuInfo);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        return super.onContextItemSelected(item);
    }
}
