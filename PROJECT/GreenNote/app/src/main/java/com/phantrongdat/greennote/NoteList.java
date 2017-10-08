package com.phantrongdat.greennote;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

public class NoteList extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_list);
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#309e45"));
        getActionBar().setBackgroundDrawable(colorDrawable);
    }
}
