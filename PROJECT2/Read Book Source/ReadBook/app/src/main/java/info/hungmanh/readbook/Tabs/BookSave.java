package info.hungmanh.readbook.Tabs;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import info.hungmanh.readbook.Adapters.BookAdapter;
import info.hungmanh.readbook.Adapters.SQLiteHandler;
import info.hungmanh.readbook.Entities.Book;
import info.hungmanh.readbook.Entities.Category;
import info.hungmanh.readbook.R;

/**
 * Created by Alone on 10/7/2016.
 */

public class BookSave extends Fragment {
    private RecyclerView lstBook;
    private ArrayList<Book> books;
    private BookAdapter adapter;
    SQLiteHandler db;
    Spinner spinner;
    List<Category> categories = new ArrayList<>();
    ArrayAdapter adapterCate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_save, container, false);

        StaggeredGridLayoutManager mStaggeredLayoutManager1 = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mStaggeredLayoutManager1.supportsPredictiveItemAnimations();
        mStaggeredLayoutManager1.requestSimpleAnimationsInNextLayout();
        mStaggeredLayoutManager1.isSmoothScrolling();
        lstBook = (RecyclerView) view.findViewById(R.id.lstBook);
        lstBook.setLayoutManager(mStaggeredLayoutManager1);

        spinner = (Spinner) view.findViewById(R.id.spinner);
        initialize();
        loadBook(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                loadBook(categories.get(position).getId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void initialize() {
        db = new SQLiteHandler(getActivity().getApplicationContext());
        Cursor cursor = db.rawQuery("SELECT * FROM ChuyenMucs");
        categories.add(0, new Category(0, "Tủ sách của bạn"));
        while (cursor.moveToNext()) {
            categories.add(new Category(cursor.getInt(cursor.getColumnIndex("MaChuyenMuc")), cursor.getString(cursor.getColumnIndex("TenChuyenMuc"))));
        }

        adapterCate = new ArrayAdapter(getActivity().getApplicationContext(), R.layout.spiner_item_text, categories);
        adapterCate.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter(adapterCate);
    }

    public void loadBook(int category) {

        books = new ArrayList<>();
        String sql;

        if (category == 0) sql = "SELECT * FROM Sachs";
        else sql = "SELECT * FROM Sachs WHERE MaChuyenMuc="+category+"";

        Cursor cursor = db.rawQuery(sql);
        while (cursor.moveToNext()) {
            Book book = new Book();
            book.setId(cursor.getInt(cursor.getColumnIndex("MaSach")));
            book.setBookName(cursor.getString(cursor.getColumnIndex("TenSach")));
            book.setCategoryID(cursor.getInt(cursor.getColumnIndex("MaChuyenMuc")));
            book.setAuthor(cursor.getString(cursor.getColumnIndex("TacGia")));
            book.setDescription(cursor.getString(cursor.getColumnIndex("MoTa")));
            book.setImageName(cursor.getString(cursor.getColumnIndex("AnhDaiDien")));
            book.setExtranet(cursor.getInt(cursor.getColumnIndex("MaNhaXuatBan")));

            books.add(book);
        }
        adapter = new BookAdapter(getActivity().getApplicationContext(), books);
        lstBook.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
