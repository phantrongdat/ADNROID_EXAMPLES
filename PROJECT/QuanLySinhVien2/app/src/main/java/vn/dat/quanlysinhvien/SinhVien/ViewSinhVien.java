package vn.dat.quanlysinhvien.SinhVien;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import vn.dat.quanlysinhvien.R;

/**
 * Created by Alone on 05/01/2016.
 */
public class ViewSinhVien extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sinhvien_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("QUẢN LÝ SINH VIÊN");
        actionBar.setDisplayHomeAsUpEnabled(true);

    }
}
