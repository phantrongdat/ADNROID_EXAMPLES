package info.hungmanh.readbook;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import info.hungmanh.readbook.Adapters.BookAdapter;
import info.hungmanh.readbook.Adapters.SQLiteHandler;
import info.hungmanh.readbook.CallBacks.BookAsyncTask;
import info.hungmanh.readbook.CallBacks.BookLoadListener;
import info.hungmanh.readbook.CallBacks.ChapterAsyncTask;
import info.hungmanh.readbook.CallBacks.ChapterLoadListener;
import info.hungmanh.readbook.Entities.Book;
import info.hungmanh.readbook.Entities.Chapter;

public class BookDetail extends AppCompatActivity {
    SQLiteHandler db;
    private ActionBar actionBar;
    private Book book;
    Button btnRead;
    private RecyclerView lstBook;
    private ImageView imgBook;
    private TextView txtTitle, txtAuthor, txtPrice, txtDescription;
    private ArrayList<Book> books = new ArrayList<>();
    int bookID, categoryID;
    private static final int TIME_DELAY = 2000;
    private static long back_pressed;
    boolean online;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Giỏ sách");
        db = new SQLiteHandler(this);
        initialize();

    }

    public void initialize() {
        book = (Book) getIntent().getSerializableExtra("Book");
        online = (boolean) getIntent().getSerializableExtra("online");

        imgBook = (ImageView) findViewById(R.id.imgBook);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtAuthor = (TextView) findViewById(R.id.txtAuthor);
        txtPrice = (TextView) findViewById(R.id.txtPrice);
        txtDescription = (TextView) findViewById(R.id.txtDescription);
        btnRead = (Button) findViewById(R.id.btnRead);

        bookID = book.getId();
        categoryID = book.getCategoryID();
        String img = book.getImageName();

        if (img.contains("http")) {
            Picasso.with(this).load(img).
                    placeholder(R.drawable.book_placeholder).
                    error(R.drawable.book_error).
                    into(imgBook);
        } else {
            Picasso.with(this).load(new File(img)).
                    placeholder(R.drawable.book_placeholder).
                    error(R.drawable.book_error).
                    into(imgBook);
        }

        txtTitle.setText(book.getBookName());
        txtAuthor.setText(book.getAuthor());
        txtDescription.setText(book.getDescription());

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        lstBook = (RecyclerView) findViewById(R.id.lstBook);
        lstBook.setLayoutManager(layoutManager1);
        BookAsyncTask asyncNewBook = new BookAsyncTask(new BookLoadListener() {
            @Override
            public void BookLoadListener(ArrayList<Book> listtintuc) {

                BookAdapter bookAdapter = new BookAdapter(BookDetail.this, listtintuc);
                lstBook.setAdapter(bookAdapter);
            }
        }, "LaySachTheoChuyenMuc", categoryID);

        asyncNewBook.execute();

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookDetail.this, BookReader.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("id", bookID);
                intent.putExtra("name", book.getBookName());
                intent.putExtra("online", online);
                startActivity(intent);
            }
        });
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

    public void saveBook() {
        Cursor cursor = db.rawQuery("SELECT * FROM Sachs WHERE MaSach=" + bookID);
        if (cursor.getCount() == 1)
            Toast.makeText(BookDetail.this, "Bạn đã có sách này rồi!", Toast.LENGTH_SHORT).show();
        else {
            String imageName = "book_" + bookID + ".png";
            String path = "/data/data/info.hungmanh.readbook/app_readbook/";
            ContextWrapper cw = new ContextWrapper(this);
            File directory = cw.getDir("readbook", Context.MODE_PRIVATE); // path to /data/data/yourapp/app_imageDir
            File myImageFile = new File(directory, imageName); // Create image file

            Picasso.with(this).load(book.getImageName()).into(picassoImageTarget(myImageFile));
            String sql1 = "INSERT INTO Sachs VALUES(" + bookID + "," + categoryID + ",'" + book.getBookName() + "','" + path + imageName + "'," +
                    "'" + book.getDescription() + "'," + book.getExtranet() + ",'" + book.getAuthor() + "',' ')";
            db.execute(sql1);

            // save chapters, handler
            ChapterAsyncTask chapterAsyncTask = new ChapterAsyncTask(new ChapterLoadListener() {
                @Override
                public void ChapterLoadListener(ArrayList<Chapter> list) {
                    for (Chapter chapter : list) {
                        String sql = "INSERT INTO Chuongs VALUES(" + chapter.getId() + "," + bookID + "," +
                                "'" + chapter.getChapName() + "','" + chapter.getDetail() + "')";
                        db.execute(sql);
                    }
                }
            }, "LayDanhSachChuong", bookID);
            chapterAsyncTask.execute();

            Toast.makeText(BookDetail.this, "Đã lưu trong tủ sách!", Toast.LENGTH_SHORT).show();
        }
    }

    public void favorite() {
        BookAsyncTask bookAsyncTask = new BookAsyncTask(new BookLoadListener() {
            @Override
            public void BookLoadListener(ArrayList<Book> list) {
                Toast.makeText(BookDetail.this,"Bạn thích sách này!",Toast.LENGTH_SHORT).show();
            }
        }, "SachYeuThich", bookID);
        bookAsyncTask.execute();
    }

    private Target picassoImageTarget(final File myImageFile) {
        Log.d("picassoImageTarget", " picassoImageTarget");

        return new Target() {
            @Override
            public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        FileOutputStream fos = null;
                        try {
                            fos = new FileOutputStream(myImageFile);
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                fos.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        Log.i("image", "image saved to >>>" + myImageFile.getAbsolutePath());

                    }
                }).start();
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                if (placeHolderDrawable != null) {
                }
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Download:
                saveBook();
                break;
            case R.id.Favorite:
                favorite();
                break;

        }
        return super.onOptionsItemSelected(item);
    }


}
