package com.example.alone.phantrongdat;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

    Button optionMenu,optionMenuStyle,contextMenu,contextMenuIcon,taskbarMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        optionMenu=(Button)findViewById(R.id.btnOptionMenu);
        optionMenuStyle=(Button)findViewById(R.id.btnOptionMenuStyle);
        contextMenu=(Button)findViewById(R.id.btnContextMenu);
        contextMenuIcon=(Button)findViewById(R.id.btnContextMenuIcon);
        taskbarMenu=(Button)findViewById(R.id.btnTaskbarMenu);

        optionMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent option=new Intent(MainActivity.this,OptionMenuBasic.class);
                startActivity(option);
            }
        });

        optionMenuStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent option2=new Intent(MainActivity.this,OptinonMenuStyle.class);
                startActivity(option2);
            }
        });


        contextMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent context=new Intent(MainActivity.this,MultiContextMenu.class);
                startActivity(context);
            }
        });

        contextMenuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent context2 = new Intent(MainActivity.this, IconContextMenu.class);
                startActivity(context2);
            }
        });

        taskbarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent taskbar = new Intent(MainActivity.this, TaskbarMenu.class);
                startActivity(taskbar);
            }
        });
    }
}
