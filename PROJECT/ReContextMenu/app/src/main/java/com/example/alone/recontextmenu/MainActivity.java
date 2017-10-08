package com.example.alone.recontextmenu;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    TextView txtContext;

    @Override
    protected void onCreate(Bundle  savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtContext = (TextView) findViewById(R.id.txtContext);

        // Create the menu builder.
                  MenuBuilder builder = new MenuBuilder(this);
                  ClipData.Item newItem = null;
                  newItem = builder.add(0, 1, "Photos",
                R.drawable.item1);
    }
}
