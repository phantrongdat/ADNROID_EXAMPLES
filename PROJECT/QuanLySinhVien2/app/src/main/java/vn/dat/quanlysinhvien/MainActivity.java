package vn.dat.quanlysinhvien;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import vn.dat.quanlysinhvien.DatabaseHandler.DatabaseHandler;
import vn.dat.quanlysinhvien.Diem.DiemSV;
import vn.dat.quanlysinhvien.Lop.FromLop;
import vn.dat.quanlysinhvien.MonHoc.FromMonHoc;
import vn.dat.quanlysinhvien.SinhVien.FormSinhVien;

public class MainActivity extends AppCompatActivity {
    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("QUẢN LÝ SINH VIÊN - UTEHY");

        db=new DatabaseHandler(this);
    }

    public void clickQLSV(View v)
    {
        startActivity(new Intent(getApplicationContext(), FormSinhVien.class));
    }

    public void clickQLDiem(View v)
    {
        startActivity(new Intent(getApplicationContext(), DiemSV.class));
    }

    public void clickQLLop(View v)
    {
        startActivity(new Intent(getApplicationContext(),FromLop.class));
    }

    public void clickQLMH(View v)
    {
        startActivity(new Intent(getApplicationContext(),FromMonHoc.class));
    }

    public void clickTimKiem(View v)
    {
        startActivity(new Intent(getApplicationContext(),TimKiem.class));
    }

    public void clickThongKe(View v)
    {
        startActivity(new Intent(getApplicationContext(),ThongKe.class));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
