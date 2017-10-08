package com.example.alone.controlview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.*;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculator=(Button)findViewById(R.id.btCalculator);
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cal = new Intent(MainActivity.this, Calculator.class);
                startActivity(cal);
            }
        });

        Button radioButton=(Button)findViewById(R.id.btRadioButton);
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rd = new Intent(MainActivity.this, MyRadioButton.class);
                startActivity(rd);
            }
        });

        Button checkBox=(Button)findViewById(R.id.btCheckBox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cb = new Intent(MainActivity.this, MyCheckBox.class);
                startActivity(cb);
            }
        });

        Button send=(Button)findViewById(R.id.btSend);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(MainActivity.this, Sending.class);
                startActivity(s);
            }
        });

        Button spinner=(Button)findViewById(R.id.btSpinner);
        spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sp = new Intent(MainActivity.this, MySpinner.class);
                startActivity(sp);
            }
        });

        Button listView=(Button)findViewById(R.id.btListView);
        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lv = new Intent(MainActivity.this, MyListView.class);
                startActivity(lv);
            }
        });

        Button dpDialog=(Button)findViewById(R.id.btdpDialog);
        dpDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dpd = new Intent(MainActivity.this, DatePickerDialogView.class);
                startActivity(dpd);
            }
        });

        Button tpDialog=(Button)findViewById(R.id.bttpDialog);
        tpDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tpd=new Intent(MainActivity.this,TimePickerDialogView.class);
                startActivity(tpd);
            }
        });

        Button btTask=(Button)findViewById(R.id.btTask);
        btTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent task=new Intent(MainActivity.this,MyTask.class);
                startActivity(task);
            }
        });

        Button btTab=(Button)findViewById(R.id.btTab);
        btTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tab=new Intent(MainActivity.this,MyTab.class);
                startActivity(tab);
            }
        });

        Button btMenu=(Button)findViewById(R.id.btMenu);
        btMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MainActivity.this, MenuView.class);
                startActivity(menu);
            }
        });

        Button btMenuContext=(Button)findViewById(R.id.btContextMenu);
        btMenuContext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MainActivity.this, ContextMenuView.class);
                startActivity(menu);
            }
        });

        Button btCustomMenu=(Button)findViewById(R.id.btSubMenu);
        btCustomMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MainActivity.this, SubMenu.class);
                startActivity(menu);
            }
        });
        //////////////////////////////////////
    }

    public void datePicker(View v)
    {
        Intent datePicker=new Intent(this,DatePickerView.class) ;
        startActivity(datePicker);
    }

    public void timePicker(View v)
    {
        Intent Picker=new Intent(this,TimePickerView.class) ;
        startActivity(Picker);
    }
}
