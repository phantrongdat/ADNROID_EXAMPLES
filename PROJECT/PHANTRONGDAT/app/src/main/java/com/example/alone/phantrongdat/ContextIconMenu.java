package com.example.alone.phantrongdat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class ContextIconMenu extends ActionBarActivity {
    Button btnContext;

    RelativeLayout layout;
    ArrayList<String> arr = new ArrayList<String>();
    AdapterContextMenu adap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_icon_menu);
        layout = (RelativeLayout) findViewById(R.id.layoutDemo);

        btnContext = (Button) findViewById(R.id.btnContextIconMenu);

        registerForContextMenu(btnContext);
        arr.add(" Change to Blue");
        arr.add(" Change to Red");
        arr.add(" Change to White");
        arr.add(" Change to Yellow");
        arr.add(" Change to Green");
        adap = new AdapterContextMenu(ContextIconMenu.this, R.layout.context_menu_with_icon, arr);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AlertDialog.Builder al = new AlertDialog.Builder(this);
        al.setTitle("Change Background");
        al.setAdapter(adap, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        layout.setBackgroundColor(Color.BLUE);
                        break;
                    case 1:
                        layout.setBackgroundColor(Color.RED);
                        break;
                    case 2:
                        layout.setBackgroundColor(Color.WHITE);
                        break;
                    case 3:
                        layout.setBackgroundColor(Color.YELLOW);
                        break;
                    case 4:
                        layout.setBackgroundColor(Color.GREEN);
                        break;
                }
            }
        }).create().show();
    }
}
