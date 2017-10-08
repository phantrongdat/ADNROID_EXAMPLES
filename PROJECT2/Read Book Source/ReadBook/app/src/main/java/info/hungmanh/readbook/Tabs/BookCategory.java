package info.hungmanh.readbook.Tabs;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import info.hungmanh.readbook.Adapters.BookAdapter;
import info.hungmanh.readbook.CallBacks.BookAsyncTask;
import info.hungmanh.readbook.CallBacks.BookLoadListener;
import info.hungmanh.readbook.CallBacks.CategoryAsyncTask;
import info.hungmanh.readbook.CallBacks.CategoryLoadListener;
import info.hungmanh.readbook.Entities.Book;
import info.hungmanh.readbook.Entities.Category;
import info.hungmanh.readbook.R;

/**
 * Created by Alone on 10/7/2016.
 */

public class BookCategory extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    ArrayList<Category> categories = new ArrayList<>();
    LinearLayout layout;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_categories, container, false);
        layout = (LinearLayout) view.findViewById(R.id.container);

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.mswip);
        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(android.R.color.holo_blue_dark), getResources().getColor(android.R.color.holo_green_light), getResources().getColor(android.R.color.holo_orange_light), getResources().getColor(android.R.color.holo_red_light));
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        });
        mSwipeRefreshLayout.setOnRefreshListener(this);

        initialize();
        return view;
    }

    public void initialize() {
        CategoryAsyncTask asyncTask = new CategoryAsyncTask(new CategoryLoadListener() {
            @Override
            public void CategoryLoadListener(ArrayList<Category> list) {
                categories = list;

//                Toast.makeText(getActivity().getApplicationContext(), list.size() + "", Toast.LENGTH_SHORT).show();
                for (final Category category : list) {
                    if (list.lastIndexOf(category)==list.size()-1){
                        if (mSwipeRefreshLayout.isRefreshing()) {
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                    }
                    Log.e("a", category.getCateName());
                    final TextView textView = new TextView(getActivity());
                    textView.setText(category.getCateName());
                    textView.setTextSize(18f);
                    textView.setTextColor(Color.BLACK);
//                    textView.setVisibility(View.VISIBLE);


                    final RecyclerView recyclerView = new RecyclerView(getActivity());
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    recyclerView.setLayoutManager(layoutManager);
//                    recyclerView.setVisibility(View.VISIBLE);
                    final BookAsyncTask asyncNewBook = new BookAsyncTask(new BookLoadListener() {
                        @Override
                        public void BookLoadListener(ArrayList<Book> listtintuc) {
                            if (listtintuc.size() != 0) {
                                layout.addView(textView);
                                layout.addView(recyclerView);

                                BookAdapter bookAdapter = new BookAdapter(getActivity().getApplicationContext(), listtintuc);
                                recyclerView.setAdapter(bookAdapter);
                            }
                        }
                    }, "LaySachTheoChuyenMuc", category.getId());
                    asyncNewBook.execute();

                }
            }
        }, "LayChuyenMuc");
        asyncTask.execute();

    }

    @Override
    public void onRefresh() {
        initialize();
    }
}
