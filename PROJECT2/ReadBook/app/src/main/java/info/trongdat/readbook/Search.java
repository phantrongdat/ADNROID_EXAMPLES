package info.trongdat.readbook;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import java.util.ArrayList;

import info.trongdat.readbook.Adapters.BookAdapter;
import info.trongdat.readbook.Entities.Book;

public class Search extends AppCompatActivity {

    private RecyclerView lstBook;
    private ArrayList<Book> books = new ArrayList<>();
    private BookAdapter adapter;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setTitle("Tìm kiếm");
//
//        books.add(new Book(1, "Tạm biệt xe đạp", "Phan", "Trong", "Dat", true, "none", "null"));
//        books.add(new Book(2, "Original working", "Phan", "Trong", "Dat", true, "none", "null"));
//        books.add(new Book(3, "Concept Making", "Phan", "Trong", "Dat", true, "none", "null"));
//        books.add(new Book(4, "Tôi và Paris", "Phan", "Trong", "Dat", true, "none", "null"));
//        books.add(new Book(5, "Hoàng tử và chú bé", "Phan", "Trong", "Dat", true, "none", "null"));
//        books.add(new Book(6, "Nghệ thuật giao tiếp", "Phan", "Trong", "Dat", true, "none", "null"));


        StaggeredGridLayoutManager mStaggeredLayoutManager1 = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mStaggeredLayoutManager1.supportsPredictiveItemAnimations();
        mStaggeredLayoutManager1.requestSimpleAnimationsInNextLayout();
        mStaggeredLayoutManager1.isSmoothScrolling();
        lstBook = (RecyclerView) findViewById(R.id.lstBook);
        lstBook.setLayoutManager(mStaggeredLayoutManager1);
        adapter = new BookAdapter(getApplicationContext(), books);
        lstBook.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.Search));
        searchView.setIconifiedByDefault(true);
        return super.onCreateOptionsMenu(menu);
    }
}
