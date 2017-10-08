package com.phantrongdat.greennote;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends ActionBarActivity {
    NoteDatabase db = new NoteDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        getActionBar().hide();

    }

    public void skip(View view) {
        Intent edit = new Intent(this, NoteEdit.class);
        startActivity(edit);
    }
}

