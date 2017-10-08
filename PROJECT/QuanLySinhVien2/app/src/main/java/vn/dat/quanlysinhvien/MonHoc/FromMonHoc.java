package vn.dat.quanlysinhvien.MonHoc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TabHost;

import vn.dat.quanlysinhvien.R;

public class FromMonHoc extends AppCompatActivity {

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monhoc_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("QUẢN LÝ MÔN HỌC");
        actionBar.setDisplayHomeAsUpEnabled(true);
        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec("T1");
        tabSpec.setContent(R.id.tbThemMH);
        tabSpec.setIndicator("THÊM MÔN HỌC");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("T2");
        tabSpec.setContent(R.id.tbDSMH);
        tabSpec.setIndicator("DANH SÁCH MH");
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTab(0);
    }

}
