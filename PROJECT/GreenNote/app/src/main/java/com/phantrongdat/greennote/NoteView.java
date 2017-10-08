package com.phantrongdat.greennote;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.EditText;

/**
 * Created by Alone on 04/11/2016.
 */
public class NoteView extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_view);

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#309e45"));
        getActionBar().setBackgroundDrawable(colorDrawable);
    }
}
