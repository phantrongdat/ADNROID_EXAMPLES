package info.hungmanh.readbook;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;

import info.hungmanh.readbook.Adapters.SQLiteHandler;
import info.hungmanh.readbook.CallBacks.ChapterAsyncTask;
import info.hungmanh.readbook.CallBacks.ChapterLoadListener;
import info.hungmanh.readbook.Entities.Chapter;

public class BookReader extends AppCompatActivity implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {
    SQLiteHandler db;
    ActionBar actionBar;
    int id;
    int chap = 1;
    boolean state;
    TextView txtDetail;
    Button btnNext, btnPre;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_reader2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();


        try {
            Field f = null;
            f = toolbar.getClass().getDeclaredField("mTitleTextView");
            f.setAccessible(true);
            TextView toolbarTextView = null;
            toolbarTextView = (TextView) f.get(toolbar);
            toolbarTextView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            toolbarTextView.setFocusable(true);
            toolbarTextView.setFocusableInTouchMode(true);
            toolbarTextView.requestFocus();
            toolbarTextView.setSingleLine(true);
            toolbarTextView.setSelected(true);
            toolbarTextView.setMarqueeRepeatLimit(-1);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        initialize();

        loadBook(id, chap, state);

    }

    public void initialize() {
        db = new SQLiteHandler(this);
        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("id");
        state = bundle.getBoolean("online");
        actionBar.setTitle(bundle.getString("name"));

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.mswip);
        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(android.R.color.holo_blue_dark), getResources().getColor(android.R.color.holo_green_light), getResources().getColor(android.R.color.holo_orange_light), getResources().getColor(android.R.color.holo_red_light));

        mSwipeRefreshLayout.setOnRefreshListener(this);

        txtDetail = (TextView) findViewById(R.id.txtDetail);
        btnNext = (Button) findViewById(R.id.nextChapter);
        btnNext.setOnClickListener(this);
        btnPre = (Button) findViewById(R.id.preChapter);
        btnPre.setOnClickListener(this);
    }

    public void loadBook(int id, final int chapter1, boolean state) {
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        });
        if (state) {
            //if online, handler here!
            ChapterAsyncTask chapterAsyncTask = new ChapterAsyncTask(new ChapterLoadListener() {
                @Override
                public void ChapterLoadListener(ArrayList<Chapter> list) {
                    if (mSwipeRefreshLayout.isRefreshing()) {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                    if (list.size() != 0) {
                        Chapter chapter = list.get(chapter1 - 1);

                        txtDetail.setText(chapter.getDetail());
                        btnPre.setVisibility(View.VISIBLE);
                        btnNext.setVisibility(View.VISIBLE);
                        if (chapter1 == 1) btnPre.setVisibility(View.INVISIBLE);
                        if (chapter1 == list.size()) btnNext.setVisibility(View.INVISIBLE);
                    } else txtDetail.setText("Không thể tải dữ liệu.");
                }
            }, "LayDanhSachChuong", id);
            chapterAsyncTask.execute();

        } else {
            //if offline, handler here!
            if (mSwipeRefreshLayout.isRefreshing()) {
                mSwipeRefreshLayout.setRefreshing(false);
            }
            String sql = "SELECT TenChuong, ChiTiet FROM Chuongs WHERE MaSach=" + id + " and MaChuong=" + chap;
            Cursor cursor = db.rawQuery(sql);
            cursor.moveToFirst();
            if (cursor.getCount() != 0) {
                Chapter chapter = new Chapter();
                chapter.setId(chap);
                chapter.setBookID(id);
                chapter.setChapName(cursor.getString(0));
                chapter.setDetail(cursor.getString(1));

                txtDetail.setText(chapter.getDetail());

                Cursor cursor1 = db.rawQuery("SELECT TenChuong, ChiTiet FROM Chuongs WHERE MaSach=" + id);

                btnPre.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.VISIBLE);
                if (chap == 1) btnPre.setVisibility(View.INVISIBLE);
                if (chap == cursor1.getCount()) btnNext.setVisibility(View.INVISIBLE);
            } else
                txtDetail.setText("Không có dữ liệu.");
        }
    }

    @Override
    public void onClick(View v) {
//        btnPre.setEnabled(false);
//        btnNext.setEnabled(false);

        btnPre.setVisibility(View.INVISIBLE);
        btnNext.setVisibility(View.INVISIBLE);

        if (v.getId() == R.id.nextChapter) {
            // click next button, handler here.
            chap++;
            loadBook(id, chap, state);
        }
        if (v.getId() == R.id.preChapter) {
            // click pre button, handler here.
            chap--;
            loadBook(id, chap, state);
        }
    }

    @Override
    public void onRefresh() {
        loadBook(id, chap, state);
    }
}
