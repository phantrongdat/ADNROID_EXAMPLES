package info.trongdat.readbook.Tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import info.trongdat.readbook.Adapters.BookAdapter;
import info.trongdat.readbook.Entities.Book;
import info.trongdat.readbook.R;

/**
 * Created by Alone on 10/7/2016.
 */

public class BookSave extends Fragment {
    private RecyclerView lstBook;
    private ArrayList<Book> books = new ArrayList<>();
    private BookAdapter adapter;

    Spinner spinner;
    List<String> categories = new ArrayList<>();
    ArrayAdapter adapterCate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_save, container, false);
//        books.add(new Book(1, "Tạm biệt xe đạp", "Phan", "Trong", "Dat", true, "none", "null"));
//        books.add(new Book(2, "Original working", "Phan", "Trong", "Dat", true, "none", "null"));
//        books.add(new Book(3, "Concept Making", "Phan", "Trong", "Dat", true, "none", "null"));
//        books.add(new Book(4, "Tôi và Paris", "Phan", "Trong", "Dat", true, "none", "null"));
//        books.add(new Book(5, "Hoàng tử và chú bé", "Phan", "Trong", "Dat", true, "none", "null"));
//        books.add(new Book(6, "Nghệ thuật giao tiếp", "Phan", "Trong", "Dat", true, "none", "null"));
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
        lstBook = (RecyclerView) view.findViewById(R.id.lstBook);
        lstBook.setLayoutManager(mStaggeredLayoutManager1);
        adapter = new BookAdapter(getActivity().getApplicationContext(), books);
        lstBook.setAdapter(adapter);


        spinner = (Spinner) view.findViewById(R.id.spinner);
        categories.add("Sách kinh tế");
        categories.add("Sách thiếu nhi");
        categories.add("Sách kỹ năng sống");
        categories.add("Tạp chí & chuyên đề");
        categories.add("Sách chuyên ngành");
        adapterCate = new ArrayAdapter(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, categories);
        adapterCate.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter(adapterCate);

        return view;
    }
}
