package info.trongdat.camnangamthuc.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import info.trongdat.camnangamthuc.R;
import info.trongdat.camnangamthuc.fragments.DayNauAn;
import info.trongdat.camnangamthuc.fragments.FrgMonAn;

public class MainActivity extends AppCompatActivity {
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.shitstuff);

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new DayNauAn()).commit();
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();
                if (menuItem.getItemId() == R.id.navCamNang) {
                    toolbar.setTitle("Cẩm nang");
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new FrgMonAn().newInstance("layDSMonAn",4)).commit();
                }
                if (menuItem.getItemId() == R.id.navDayNauAn) {
                    toolbar.setTitle("Dạy nấu ăn");
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new DayNauAn()).commit();
                }
                if (menuItem.getItemId() == R.id.navGocSangTao) {
                    toolbar.setTitle("Góc sáng tạo");
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new FrgMonAn().newInstance("layDSMonAn",6)).commit();
                }
                if (menuItem.getItemId() == R.id.navVanHoaAmThuc) {
                    toolbar.setTitle("Văn hóa ẩm thực");
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new FrgMonAn().newInstance("layDSMonAn",5)).commit();
                }
                if (menuItem.getItemId() == R.id.navAmThucSucKhoe) {
                    toolbar.setTitle("Ẳm thực và sức khỏe");
                    FragmentTransaction xfragmentTransaction = mFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new FrgMonAn().newInstance("layDSMonAn",6)).commit();
                }
                if (menuItem.getItemId() == R.id.nav_item_settings) {
                    toolbar.setTitle("Cài đặt");
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new setting()).commit();
                }

                if (menuItem.getItemId() == R.id.nav_item_helps) {
                    toolbar.setTitle(R.string.help_title);
                    FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new help()).commit();
                }
                return false;
            }
        });
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater me = getMenuInflater();
        me.inflate(R.menu.action_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
