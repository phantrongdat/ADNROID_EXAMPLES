package info.trongdat.camnangamthuc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import info.trongdat.camnangamthuc.R;
import info.trongdat.camnangamthuc.model.MonAn;

public class ChiTietMonAn extends AppCompatActivity {
    MonAn monAn;
    ImageView img;
    TextView txtChiTiet;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_mon_an);
        Bundle bundle = getIntent().getExtras();
        monAn = (MonAn) bundle.getSerializable("MonAn");

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(monAn.getTen());
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.mswip);
        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(android.R.color.holo_blue_bright), getResources().getColor(android.R.color.holo_green_light), getResources().getColor(android.R.color.holo_orange_light), getResources().getColor(android.R.color.holo_red_light));
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new CountDownTimer(5000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                    }

                    @Override
                    public void onFinish() {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }.start();
            }
        });

        img = (ImageView) findViewById(R.id.imgAnh);
        txtChiTiet = (TextView) findViewById(R.id.txtChiTiet);
        String image = monAn.getAnh();
        if (monAn.getAnh().indexOf("NULL") == 0)
            image = monAn.getAnh().substring(4, monAn.getAnh().length());
        Picasso.with(this).load(image).into(img);

        txtChiTiet.setText(monAn.getChiTiet());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.monan_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.itmWeb)
            startActivity(new Intent(ChiTietMonAn.this, XemMonAnWeb.class).putExtra("link", monAn.getLink()));
        return super.onOptionsItemSelected(item);
    }
}
