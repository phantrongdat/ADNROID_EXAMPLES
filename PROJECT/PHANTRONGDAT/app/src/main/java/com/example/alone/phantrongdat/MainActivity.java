package com.example.alone.phantrongdat;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

    Button optionMenu,option2,contextMenu,contextIconMenu,taskbarMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        optionMenu=(Button)findViewById(R.id.btnOptionMenu);
        option2=(Button)findViewById(R.id.btnOption2);
        contextMenu=(Button)findViewById(R.id.btnContextMenu);
        contextIconMenu=(Button)findViewById(R.id.btnContextIcon);
        taskbarMenu=(Button)findViewById(R.id.btnTaskbarMenu);


        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent option2=new Intent(MainActivity.this,ReOptionMenu2.class);
                startActivity(option2);
            }
        });

        optionMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent option=new Intent(MainActivity.this,ReOptionMenu.class);
                startActivity(option);
            }
        });

        contextMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent context=new Intent(MainActivity.this,ReContextMenu.class);
                startActivity(context);
            }
        });

        contextIconMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent context2=new Intent(MainActivity.this,ContextIconMenu.class);
                startActivity(context2);
            }
        });

        taskbarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent taskbar=new Intent(MainActivity.this,TaskbarMenu.class);
                startActivity(taskbar);
            }
        });
    }
}
