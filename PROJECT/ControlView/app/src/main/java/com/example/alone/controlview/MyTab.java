package com.example.alone.controlview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TabHost;

public class MyTab extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tab);
        TabHost tabHost=(TabHost)findViewById(R.id.tabHost);
        tabHost.setup();
        TabHost.TabSpec tabSpec;
        tabSpec=tabHost.newTabSpec("1");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("LOGIN");
        tabHost.addTab(tabSpec);

        TabHost.TabSpec tabSpec2;
        tabSpec2=tabHost.newTabSpec("2");
        tabSpec2.setContent(R.id.tab2);
        tabSpec2.setIndicator("TIPS");
        tabHost.addTab(tabSpec2);

        TabHost.TabSpec tabSpec3;
        tabSpec3=tabHost.newTabSpec("3");
        tabSpec3.setContent(R.id.tab3);
        tabSpec3.setIndicator("MAIN");
        tabHost.addTab(tabSpec3);

        tabHost.setCurrentTab(0);

    }

}
