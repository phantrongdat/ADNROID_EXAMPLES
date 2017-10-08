package info.trongdat.readbook;

import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.gigamole.navigationtabbar.ntb.NavigationTabBar;

import java.util.ArrayList;

import info.trongdat.readbook.Adapters.ViewPagerAdapter;
import info.trongdat.readbook.Tabs.BookCategory;
import info.trongdat.readbook.Tabs.BookSave;
import info.trongdat.readbook.Tabs.BookStore;

public class MainActivity extends AppCompatActivity {

    private NavigationTabBar navigationTabBar;
    private ViewPager viewPager;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setTitle("Đọc sách");

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        navigationTabBar = (NavigationTabBar) findViewById(R.id.ntb_horizontal);

        setup();
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
