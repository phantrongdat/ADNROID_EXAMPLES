package info.hungmanh.readbook;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.gigamole.navigationtabbar.ntb.NavigationTabBar;

import java.util.ArrayList;

import info.hungmanh.readbook.Adapters.ViewPagerAdapter;
import info.hungmanh.readbook.Tabs.BookCategory;
import info.hungmanh.readbook.Tabs.BookSave;
import info.hungmanh.readbook.Tabs.BookStore;

public class MainActivity extends AppCompatActivity {

    private NavigationTabBar navigationTabBar;
    private ViewPager viewPager;
    ActionBar actionBar;

    private static final int TIME_DELAY = 2000;
    private static long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setTitle("Đọc sách");

        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        navigationTabBar = (NavigationTabBar) findViewById(R.id.ntb_horizontal);

        setup();
        String file = Environment.getExternalStorageDirectory().getAbsolutePath();
        Log.e("path", file);
    }

    public void setup() {
        setupViewPager(viewPager);

        final String[] colors = getResources().getStringArray(R.array.vertical_ntb);

        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_book_store),
                        Color.parseColor(colors[0]))
                        .title("Kho sách")
                        .badgeTitle("mới")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.ic_book_download),
                        Color.parseColor(colors[1]))
                        .title("Tủ sách")
                        .badgeTitle("Lưu trữ")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.categories_icon),
                        Color.parseColor(colors[2]))
                        .title("Danh mục")
                        .badgeTitle("mới")
                        .build()
        );
        navigationTabBar.setModels(models);
        navigationTabBar.setViewPager(viewPager, 0);
    }

    public void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new BookStore(), "Kho sách");
        pagerAdapter.addFragment(new BookSave(), "Tủ sách");
        pagerAdapter.addFragment(new BookCategory(), "Danh mục");
        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public void onBackPressed() {
        if (back_pressed + TIME_DELAY > System.currentTimeMillis()) {
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_in);
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        } else {
            Toast.makeText(getApplicationContext(), "Press again to exit!",
                    Toast.LENGTH_SHORT).show();
        }
        back_pressed = System.currentTimeMillis();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.Search));
        searchView.setIconifiedByDefault(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = new Intent(MainActivity.this, Search.class);
                intent.putExtra("data",query);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.Search) {

        }
        return super.onOptionsItemSelected(item);
    }
}
