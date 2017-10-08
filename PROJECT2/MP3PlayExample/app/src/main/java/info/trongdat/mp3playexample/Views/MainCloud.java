//package info.trongdat.mp3playexample.Views;
//
//import android.graphics.Color;
//import android.os.Bundle;
//import android.support.v4.view.MenuItemCompat;
//import android.support.v4.view.ViewPager;
//import android.support.v7.app.ActionBar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.SearchView;
//import android.support.v7.widget.Toolbar;
//import android.view.Menu;
//import android.view.MenuItem;
//
//import com.ToxicBakery.viewpager.transforms.DepthPageTransformer;
//import com.gigamole.navigationtabstrip.NavigationTabStrip;
//
//import info.trongdat.mp3cloud.Presenters.Adapters.ViewPagerAdapter;
//import info.trongdat.mp3cloud.Presenters.SongPresenter;
//import info.trongdat.mp3cloud.R;
//import info.trongdat.mp3cloud.Views.Tabs.OfflineMusic;
//import info.trongdat.mp3cloud.Views.Tabs.OnlineMusic;
//
//public class MainCloud extends AppCompatActivity {
//    ActionBar actionBar;
//    Toolbar toolbar;
//    private ViewPager viewPager;
//    SongPresenter songPresenter;
//    private NavigationTabStrip navigationTabStrip;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_cloud);
//
//        define();
//        setup();
//    }
//
//    public void define() {
//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//
//        viewPager = (ViewPager) findViewById(R.id.viewpager);
//        navigationTabStrip = (NavigationTabStrip) findViewById(R.id.navTab);
//    }
//
//    public void setup() {
////        songPresenter=new SongPresenter(this);
////        songPresenter.initialize();
//        setSupportActionBar(toolbar);
//        actionBar = getSupportActionBar();
////        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setTitle("");
//
//        setupViewPager(viewPager);
//        navigationTabStrip.setViewPager(viewPager, 0);
//
//        navigationTabStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                if (position==0){
//                    navigationTabStrip.setActiveColor(Color.WHITE);
//                    navigationTabStrip.setInactiveColor(Color.GRAY);
//                }
//                else
//                {
//                    navigationTabStrip.setActiveColor(Color.GRAY);
//                    navigationTabStrip.setInactiveColor(Color.WHITE);
//                }
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//    }
//
//    public void setupViewPager(ViewPager viewPager) {
//        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
//        pagerAdapter.addFragment(new OfflineMusic(), "Offline Music");
//        pagerAdapter.addFragment(new OnlineMusic(), "Online");
//        viewPager.setAdapter(pagerAdapter);
//        viewPager.setPageTransformer(true, new DepthPageTransformer());
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main_cloud, menu);
//
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.search));
//        searchView.setIconifiedByDefault(true);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.search) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}
