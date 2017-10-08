package info.trongdat.readbook;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import info.trongdat.readbook.Adapters.BookAdapter;
import info.trongdat.readbook.Entities.Book;

public class BookDetail extends AppCompatActivity {

    ActionBar actionBar;
    int bookID;

    RecyclerView lstBook;
    ImageView imgBook;
    TextView txtTitle, txtAuthor, txtPrice, txtDescription;

    ArrayList<Book> books = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle("Giỏ sách");
        Bundle bundle = getIntent().getExtras();
        bookID = bundle.getInt("id");

//
//        books.add(new Book(1,"Tạm biệt xe đạp", "Phan", "Trong", "Dat",true,"none", "null"));
//        books.add(new Book(2,"Original working", "Phan", "Trong", "Dat",true,"none", "null"));
//        books.add(new Book(3,"Concept Making", "Phan", "Trong", "Dat",true,"none", "null"));
//        books.add(new Book(4,"Tôi và Paris", "Phan", "Trong", "Dat",true,"none", "null"));
//        books.add(new Book(5,"Hoàng tử và chú bé", "Phan", "Trong", "Dat",true,"none", "null"));
//        books.add(new Book(6,"Nghệ thuật giao tiếp", "Phan", "Trong", "Dat",true,"none", "null"));

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this);
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        lstBook = (RecyclerView) findViewById(R.id.lstBook);
        lstBook.setLayoutManager(layoutManager1);
        BookAdapter bookAdapter = new BookAdapter(this, books);
        lstBook.setAdapter(bookAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
