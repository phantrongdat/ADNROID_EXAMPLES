package com.example.alone.phantrongdat;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

public class TaskbarMenu extends ActionBarActivity {
    TabHost tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskbar_menu);
        tab = (TabHost) findViewById(R.id.tabDemo);
        tab.setup();
        TabHost.TabSpec spec;
        spec = tab.newTabSpec("tab1");
        spec.setIndicator(tabIndicator(getLayoutInflater(), tab, "Search", R.drawable.iconsearch));
        spec.setContent(R.id.tbsearch);
        tab.addTab(spec);

        spec = tab.newTabSpec("tab2");
        spec.setIndicator(tabIndicator(getLayoutInflater(), tab, "News", R.drawable.iconnew));
        spec.setContent(R.id.tbnews);
        tab.addTab(spec);

        spec = tab.newTabSpec("tab3");
        spec.setIndicator(tabIndicator(getLayoutInflater(), tab, "Notification", R.drawable.iconnotification));
        spec.setContent(R.id.tbnotification);
        tab.addTab(spec);

        tab.setCurrentTab(0);

        for (int i = 0; i < tab.getTabWidget().getTabCount(); i++) {
            tab.getTabWidget().getChildTabViewAt(i).setBackgroundColor(Color.WHITE);
        }

        ((ImageView) tab.getTabWidget().getChildTabViewAt(0).findViewById(android.R.id.icon)).setImageResource(R.drawable.iconsearchfocus);
        tab.setOnTabChangedListener(new TabHost.OnTabChangeListener() {

            @Override
            public void onTabChanged(String tabId) {

                switch (tab.getCurrentTab()) {
                    case 0:
                        ((ImageView) tab.getTabWidget().getChildTabViewAt(0).findViewById(android.R.id.icon)).setImageResource(R.drawable.iconsearchfocus);
                        ((ImageView) tab.getTabWidget().getChildTabViewAt(1).findViewById(android.R.id.icon)).setImageResource(R.drawable.iconnew);
                        ((ImageView) tab.getTabWidget().getChildTabViewAt(2).findViewById(android.R.id.icon)).setImageResource(R.drawable.iconnotification);
                        break;
                    case 1:
                        ((ImageView) tab.getTabWidget().getChildTabViewAt(0).findViewById(android.R.id.icon)).setImageResource(R.drawable.iconsearch);
                        ((ImageView) tab.getTabWidget().getChildTabViewAt(1).findViewById(android.R.id.icon)).setImageResource(R.drawable.iconnewfocus);
                        ((ImageView) tab.getTabWidget().getChildTabViewAt(2).findViewById(android.R.id.icon)).setImageResource(R.drawable.iconnotification);
                        break;
                    case 2:
                        ((ImageView) tab.getTabWidget().getChildTabViewAt(0).findViewById(android.R.id.icon)).setImageResource(R.drawable.iconsearch);
                        ((ImageView) tab.getTabWidget().getChildTabViewAt(1).findViewById(android.R.id.icon)).setImageResource(R.drawable.iconnew);
                        ((ImageView) tab.getTabWidget().getChildTabViewAt(2).findViewById(android.R.id.icon)).setImageResource(R.drawable.iconnotificationfocus);
                        break;
                }
            }
        });
    }


    public View tabIndicator(LayoutInflater inflater, TabHost tabHost, String textResource, int iconResource) {
        View tabIndicator = inflater.inflate(R.layout.tab, tabHost.getTabWidget(), false);
        ((TextView) tabIndicator.findViewById(android.R.id.title)).setText(textResource);
        ((ImageView) tabIndicator.findViewById(android.R.id.icon)).setImageResource(iconResource);
        return tabIndicator;
    }
}