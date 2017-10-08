package vn.dat.quanlysinhvien.Diem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TabHost;

import vn.dat.quanlysinhvien.R;

public class FromDiem extends AppCompatActivity {

    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diem_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("QUẢN LÝ ĐIỂM");
        actionBar.setDisplayHomeAsUpEnabled(true);
        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec("T1");
        tabSpec.setContent(R.id.tbThemDiem);
        tabSpec.setIndicator("THÊM ĐIỂM");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("T2");
        tabSpec.setContent(R.id.tbDSDiem);
        tabSpec.setIndicator("XEM ĐIỂM");
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTab(0);
    }
}
