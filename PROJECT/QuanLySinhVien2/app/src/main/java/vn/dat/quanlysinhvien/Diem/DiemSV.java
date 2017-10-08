package vn.dat.quanlysinhvien.Diem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import vn.dat.quanlysinhvien.R;

/**
 * Created by Alone on 05/01/2016.
 */
public class DiemSV  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diem_sv);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("QUẢN LÝ ĐIỂM");
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    public void ok(View view)
    {
        startActivity(new Intent(getApplicationContext(), FromDiem.class));
    }
}
