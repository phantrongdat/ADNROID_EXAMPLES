package com.example.alone.reoptionmenu;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.jar.Manifest;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sinh_vien, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itmPhanTrongDat:
                Toast.makeText(MainActivity.this, "You selected Phan Trong Dat", Toast.LENGTH_LONG).show();
                break;
            case R.id.itmTaDuyChien:
                Toast.makeText(MainActivity.this, "You selected Ta Duy Chien", Toast.LENGTH_LONG).show();
                break;
            case R.id.itmVuDucHanh:
                Toast.makeText(MainActivity.this, "You selected Vu Duc Hanh", Toast.LENGTH_LONG).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
