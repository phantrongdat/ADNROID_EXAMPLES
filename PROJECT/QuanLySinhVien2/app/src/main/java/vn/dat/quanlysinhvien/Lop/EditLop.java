package vn.dat.quanlysinhvien.Lop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import vn.dat.quanlysinhvien.R;

/**
 * Created by Alone on 05/02/2016.
 */
public class EditLop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lop_sua);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("QUẢN LÝ LỚP");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
