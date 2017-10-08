package info.trongdat.readbook.Tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import info.trongdat.readbook.Adapters.BookAdapter;
import info.trongdat.readbook.Entities.Book;
import info.trongdat.readbook.R;

/**
 * Created by Alone on 10/7/2016.
 */

public class BookCategory extends Fragment {
    private RecyclerView lstSachMoi, lstDocNhieu, lstNoiBat;
    TextView btnSachMoi, btnDocNhieu, btnNoiBat;
    private boolean sachMoiIsLV, docNhieuIsLV, noiBatIsLV;
    ArrayList<Book> newBooks = new ArrayList<>();
    ArrayList<Book> viewBooks = new ArrayList<>();
    ArrayList<Book> favoriteBooks = new ArrayList<>();
    private BookAdapter adapterNew, adapterView, adapterFavorite;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_book_categories,container,false);

        btnSachMoi = (TextView) view.findViewById(R.id.btnXemSachMoi);
        btnDocNhieu = (TextView) view.findViewById(R.id.btnXemDocNhieu);

//Test
//        newBooks.add(new Book(1,"Tạm biệt xe đạp", "Phan", "Trong", "Dat",true,"none", "null"));
//        newBooks.add(new Book(2,"Original working", "Phan", "Trong", "Dat",true,"none", "null"));
//        newBooks.add(new Book(3,"Concept Making", "Phan", "Trong", "Dat",true,"none", "null"));
//        newBooks.add(new Book(4,"Tôi và Paris", "Phan", "Trong", "Dat",true,"none", "null"));
//        newBooks.add(new Book(5,"Hoàng tử và chú bé", "Phan", "Trong", "Dat",true,"none", "null"));
//        newBooks.add(new Book(6,"Nghệ thuật giao tiếp", "Phan", "Trong", "Dat",true,"none", "null"));

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        lstSachMoi = (RecyclerView) view.findViewById(R.id.lstSachMoi);
        lstSachMoi.setLayoutManager(layoutManager1);
        adapterNew = new BookAdapter(getActivity().getApplicationContext(), newBooks);
        lstSachMoi.setAdapter(adapterNew);
        sachMoiIsLV = true;


        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity());
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        lstDocNhieu = (RecyclerView) view.findViewById(R.id.lstDocNhieu);
        lstDocNhieu.setLayoutManager(layoutManager2);
        adapterView = new BookAdapter(getActivity().getApplicationContext(), newBooks);
        lstDocNhieu.setAdapter(adapterView);
        docNhieuIsLV = true;


        LinearLayoutManager layoutManager3 = new LinearLayoutManager(getActivity());
        layoutManager3.setOrientation(LinearLayoutManager.HORIZONTAL);
        lstNoiBat = (RecyclerView) view.findViewById(R.id.lstSachNoiBat);
        lstNoiBat.setLayoutManager(layoutManager3);
        adapterFavorite = new BookAdapter(getActivity().getApplicationContext(), newBooks);
        lstNoiBat.setAdapter(adapterFavorite);



        btnSachMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sachMoiIsLV) {
                    StaggeredGridLayoutManager mStaggeredLayoutManager2 = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
                    mStaggeredLayoutManager2.supportsPredictiveItemAnimations();
                    mStaggeredLayoutManager2.requestSimpleAnimationsInNextLayout();
                    mStaggeredLayoutManager2.isSmoothScrolling();
                    lstSachMoi.setLayoutManager(mStaggeredLayoutManager2);
                    btnSachMoi.setText("Thu gọn ...");
                    sachMoiIsLV = false;
                } else {
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    layoutManager.requestSimpleAnimationsInNextLayout();
                    layoutManager.supportsPredictiveItemAnimations();
                    layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    lstSachMoi.setLayoutManager(layoutManager);
                    btnSachMoi.setText("Xem thêm ...");
                    sachMoiIsLV = true;
                }
            }
        });

        btnDocNhieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (docNhieuIsLV) {
                    StaggeredGridLayoutManager mStaggeredLayoutManager3 = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
                    mStaggeredLayoutManager3.supportsPredictiveItemAnimations();
                    mStaggeredLayoutManager3.requestSimpleAnimationsInNextLayout();
                    mStaggeredLayoutManager3.isSmoothScrolling();
                    lstDocNhieu.setLayoutManager(mStaggeredLayoutManager3);
                    btnDocNhieu.setText("Thu gọn ...");
                    docNhieuIsLV = false;
                } else {
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    layoutManager.requestSimpleAnimationsInNextLayout();
                    layoutManager.supportsPredictiveItemAnimations();
                    layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                    lstDocNhieu.setLayoutManager(layoutManager);
                    btnDocNhieu.setText("Xem thêm ...");
                    docNhieuIsLV = true;
                }
            }
        });
        return view;
    }
}
