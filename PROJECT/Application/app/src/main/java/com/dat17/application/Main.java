package com.dat17.application;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class Main extends AppCompatActivity {
    private ListView lstControl;
    private ArrayList<String> controls;
    private ArrayAdapter<String> adapter;
    private String[] arrControl = new String[]{"TextView", "EditText", "CheckBox", "RadioButton", "TabHost",
            "Option Menu", "Context Menu", "ListView", "Spinner", "SQLite Example", "Account Manager", "More", "More"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        lstControl = (ListView) findViewById(R.id.lstControl);
        lstControl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                    case 1:
                        startActivity(new Intent(Main.this, BasicControl.class));
                        break;
                    case 2:
                        startActivity(new Intent(Main.this, CheckBoxControl.class));
                        break;
                    case 3:
                        startActivity(new Intent(Main.this, RadioButtonControl.class));
                        break;
                    case 4:
                        startActivity(new Intent(Main.this, TabHostControl.class));
                        break;
                    case 5:
                        startActivity(new Intent(Main.this, OptionMN.class));
                        break;
                    case 6:
                        startActivity(new Intent(Main.this, ContextMN.class));
                        break;
                    case 7:
                        startActivity(new Intent(Main.this, ListViewControl.class));
                        break;
                    case 8:
                        startActivity(new Intent(Main.this, SpinnerControl.class));
                        break;
                    case 9:
                        startActivity(new Intent(Main.this, SQLiteExample.class));
                        break;
                    case 10:
                        startActivity(new Intent(Main.this, AccountManager.class));
                        break;
                }
            }
        });
        loadControl();

    }

    public void loadControl() {
        controls = new ArrayList<>(Arrays.asList(arrControl));
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, controls);
        lstControl.setAdapter(adapter);

    }
}

