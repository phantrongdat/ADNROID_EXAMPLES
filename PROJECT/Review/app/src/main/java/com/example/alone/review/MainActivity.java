package com.example.alone.review;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

    Button spinner,listview,tab,menu,input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void spinner(View view)
    {
        Intent it=new Intent(this,Spinner_Review.class);
        startActivity(it);
    }
    public  void listview(View view)
    {
        Intent it=new Intent(this,ListView_Review.class);
        startActivity(it);
    }
    public  void tab(View view)
    {
        Intent it=new Intent(this,Tab_Review.class);
        startActivity(it);
    }
    public  void menu(View view)
    {
        Intent it=new Intent(this,Menu_Review.class);
        startActivity(it);
    }
    public  void input(View view)
    {
        Intent it=new Intent(this,InputDialog_Review.class);
        startActivity(it);
    }
    public  void login(View view)
    {
        Intent it=new Intent(this,Login.class);
        startActivity(it);
    }

}
