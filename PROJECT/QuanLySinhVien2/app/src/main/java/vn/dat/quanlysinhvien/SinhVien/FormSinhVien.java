package vn.dat.quanlysinhvien.SinhVien;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TabHost;

import vn.dat.quanlysinhvien.R;

/**
 * Created by Alone on 05/01/2016.
 */
public class FormSinhVien extends AppCompatActivity {
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sinhvien_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("QUẢN LÝ SINH VIÊN");
        actionBar.setDisplayHomeAsUpEnabled(true);

        tabHost=(TabHost)findViewById(R.id.thSinhVien);
        tabHost.setup();

        TabHost.TabSpec tabSpec;

        tabSpec=tabHost.newTabSpec("T1");
        tabSpec.setContent(R.id.tbThemSV);
        tabSpec.setIndicator("THÊM SINH VIÊN");
        tabHost.addTab(tabSpec);

        tabSpec=tabHost.newTabSpec("T2");
        tabSpec.setContent(R.id.tbDSSV);
        tabSpec.setIndicator("Danh sách SV");
        tabHost.addTab(tabSpec);
        tabHost.setCurrentTab(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sinhvien_mnu_main,menu);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.itmTimKiemSV));
//        searchView.setIconifiedByDefault(true);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
        return super.onCreateOptionsMenu(menu);
    }
}
