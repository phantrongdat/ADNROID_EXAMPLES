package com.dat17.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class TabHostControl extends AppCompatActivity {

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_host_control);
        tabHost=(TabHost)findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec;

        spec=tabHost.newTabSpec("Tab1");
        spec.setIndicator("QUI");
        spec.setContent(R.id.Layout1);
        tabHost.addTab(spec);

        spec=tabHost.newTabSpec("Tab2");
        spec.setIndicator("HA");
        spec.setContent(R.id.Layout2);
        tabHost.addTab(spec);


        tabHost.setCurrentTab(0);
    }
}
