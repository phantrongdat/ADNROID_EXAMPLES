package info.hungmanh.readbook.Tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import info.hungmanh.readbook.Adapters.BookAdapter;
import info.hungmanh.readbook.CallBacks.BookLoadListener;
import info.hungmanh.readbook.CallBacks.BookAsyncTask;
import info.hungmanh.readbook.Entities.Book;
import info.hungmanh.readbook.R;

/**
 * Created by Alone on 10/7/2016.
 */


public class BookStore extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    private RecyclerView lstSachMoi, lstDocNhieu, lstNoiBat;
    TextView btnSachMoi, btnDocNhieu, btnNoiBat;
    private boolean newExpand, viewExpand, favoriteExpand;
    private static final String STATE_MOI_NHAT = "state_moi_nhat";
    private static final String STATE_NOI_BAT = "state_noi_bat";
    private static final String STATE_XEM_NHIEU_NHAT = "state_xem_nhieu_nhat";
    ArrayList<Book> mMoiNhat,mXemNhieu,mNoiBat;
    private BookAdapter adapterNew, adapterView, adapterFavorite;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_store, container, false);

        // Inflate the layout for this fragment
        mMoiNhat=new ArrayList<>();
        mXemNhieu=new ArrayList<>();
        mNoiBat=new ArrayList<>();
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.mswip);
        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(android.R.color.holo_blue_dark),getResources().getColor(android.R.color.holo_green_light), getResources().getColor(android.R.color.holo_orange_light),getResources().getColor(android.R.color.holo_red_light));

        btnSachMoi = (TextView) view.findViewById(R.id.btnXemSachMoi);
        btnDocNhieu = (TextView) view.findViewById(R.id.btnXemDocNhieu);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        lstSachMoi = (RecyclerView) view.findViewById(R.id.lstSachMoi);
        lstSachMoi.setLayoutManager(layoutManager1);


        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        lstDocNhieu = (RecyclerView) view.findViewById(R.id.lstDocNhieu);
        lstDocNhieu.setLayoutManager(layoutManager2);


        StaggeredGridLayoutManager mStaggeredLayoutManager1 = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mStaggeredLayoutManager1.supportsPredictiveItemAnimations();
        mStaggeredLayoutManager1.requestSimpleAnimationsInNextLayout();
        mStaggeredLayoutManager1.isSmoothScrolling();
        lstNoiBat = (RecyclerView) view.findViewById(R.id.lstSachNoiBat);
        lstNoiBat.setLayoutManager(mStaggeredLayoutManager1);
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        });
        mSwipeRefreshLayout.setOnRefreshListener(this);

        if (savedInstanceState != null)
        {

        }
        else {

            if (mMoiNhat.isEmpty()==true|| mNoiBat.isEmpty()==true|| mXemNhieu.isEmpty()==true) {
                initialize();
            }
        }
        return view;
    }

    public void initialize() {
        BookAsyncTask asyncNewBook = new BookAsyncTask(new BookLoadListener() {
            @Override
            public void BookLoadListener(ArrayList<Book> listtintuc) {
                mMoiNhat=listtintuc;
                adapterNew = new BookAdapter(getActivity(), listtintuc);
                lstSachMoi.setAdapter(adapterNew);
            }
        }, "LaySachMoiNhat",0);
        asyncNewBook.execute();
        newExpand = true;
        btnSachMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newExpand) {
                    GridLayoutManager mStaggeredLayoutManager2 = new GridLayoutManager(getActivity(),3 );
                    mStaggeredLayoutManager2.supportsPredictiveItemAnimations();
                    mStaggeredLayoutManager2.requestSimpleAnimationsInNextLayout();
                    mStaggeredLayoutManager2.isSmoothScrolling();
                    lstSachMoi.setLayoutManager(mStaggeredLayoutManager2);
                    btnSachMoi.setText("Thu gọn ...");
                    newExpand = false;
                } else {
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    layoutManager.requestSimpleAnimationsInNextLayout();
                    layoutManager.supportsPredictiveItemAnimations();
                    layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    lstSachMoi.setLayoutManager(layoutManager);
                    btnSachMoi.setText("Xem thêm ...");
                    newExpand = true;
                }
            }
        });



        BookAsyncTask asyncViewBook = new BookAsyncTask(new BookLoadListener() {
            @Override
            public void BookLoadListener(ArrayList<Book> listtintuc) {
                mXemNhieu=listtintuc;
                adapterView = new BookAdapter(getActivity(), listtintuc);
                lstDocNhieu.setAdapter(adapterView);
            }
        }, "LaySachXemNhieu",0);

        asyncViewBook.execute();



        viewExpand = true;

        btnDocNhieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewExpand) {
                    StaggeredGridLayoutManager mStaggeredLayoutManager3 = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
                    mStaggeredLayoutManager3.supportsPredictiveItemAnimations();
                    mStaggeredLayoutManager3.requestSimpleAnimationsInNextLayout();
                    mStaggeredLayoutManager3.isSmoothScrolling();
                    lstDocNhieu.setLayoutManager(mStaggeredLayoutManager3);
                    btnDocNhieu.setText("Thu gọn ...");
                    viewExpand = false;
                } else {
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    layoutManager.requestSimpleAnimationsInNextLayout();
                    layoutManager.supportsPredictiveItemAnimations();
                    layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    lstDocNhieu.setLayoutManager(layoutManager);
                    btnDocNhieu.setText("Xem thêm ...");
                    viewExpand = true;
                }
            }
        });

        BookAsyncTask asyncFavoriteBook = new BookAsyncTask(new BookLoadListener() {
            @Override
            public void BookLoadListener(ArrayList<Book> listtintuc) {
                if (mSwipeRefreshLayout.isRefreshing()) {
                    mSwipeRefreshLayout.setRefreshing(false);
                }
                mNoiBat=listtintuc;
                adapterFavorite = new BookAdapter(getActivity(), listtintuc);
                lstNoiBat.setAdapter(adapterFavorite);
            }
        }, "LaySachYeuThich",0);
        asyncFavoriteBook.execute();


    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(STATE_MOI_NHAT, mMoiNhat);
        outState.putSerializable(STATE_XEM_NHIEU_NHAT, mXemNhieu);
        outState.putSerializable(STATE_NOI_BAT, mNoiBat);
    }

    @Override
    public void onRefresh() {
        initialize();
    }

}
