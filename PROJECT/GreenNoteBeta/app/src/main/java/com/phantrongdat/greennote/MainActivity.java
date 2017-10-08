package com.phantrongdat.greennote;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NoteDatabase db=new NoteDatabase(this);
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.GREEN));
    }
}
