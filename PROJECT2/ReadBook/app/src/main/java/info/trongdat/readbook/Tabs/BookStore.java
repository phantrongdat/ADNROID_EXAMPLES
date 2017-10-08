package info.trongdat.readbook.Tabs;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import info.trongdat.readbook.Adapters.BookAdapter;
import info.trongdat.readbook.Entities.Book;
import info.trongdat.readbook.R;

/**
 * Created by Alone on 10/7/2016.
 */


public class BookStore extends Fragment {

    private RecyclerView lstSachMoi, lstDocNhieu, lstNoiBat;
    TextView btnSachMoi, btnDocNhieu, btnNoiBat;
    private boolean newExpand, viewExpand, favoriteExpand;
    ArrayList<Book> newBooks = new ArrayList<>();
    ArrayList<Book> viewBooks = new ArrayList<>();
    ArrayList<Book> favoriteBooks = new ArrayList<>();
    private BookAdapter adapterNew, adapterView, adapterFavorite;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_store, container, false);

        // Inflate the layout for this fragment
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

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

        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(80);
        Executor threadPoolExecutor = new ThreadPoolExecutor(60, 80, 10, TimeUnit.SECONDS, workQueue);
        MyAsyncTask asyncNewBook = new MyAsyncTask(getActivity(), "LaySachMoiNhat");
        asyncNewBook.executeOnExecutor(threadPoolExecutor);

        newBooks=asyncNewBook.getBooks();

        adapterNew = new BookAdapter(getActivity().getApplicationContext(), newBooks);
        lstSachMoi.setAdapter(adapterNew);
        newExpand = true;
        return view;
    }

    public void initialize() {
        MyAsyncTask asyncNewBook = new MyAsyncTask(getActivity(), "LaySachMoiNhat");
            asyncNewBook.execute();

        newBooks=asyncNewBook.getBooks();

        adapterNew = new BookAdapter(getActivity().getApplicationContext(), newBooks);
        lstSachMoi.setAdapter(adapterNew);
        newExpand = true;

        btnSachMoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (newExpand) {
                    StaggeredGridLayoutManager mStaggeredLayoutManager2 = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
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


//        MyAsyncTask asyncViewBook = new MyAsyncTask(getActivity(), "LaySachXemNhieu");
//        asyncViewBook.execute();
//        viewBooks=asyncNewBook.getBooks();
//
//        adapterView = new BookAdapter(getActivity().getApplicationContext(), viewBooks);
//        lstDocNhieu.setAdapter(adapterView);
//        viewExpand = true;
//
//        btnDocNhieu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (viewExpand) {
//                    StaggeredGridLayoutManager mStaggeredLayoutManager3 = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
//                    mStaggeredLayoutManager3.supportsPredictiveItemAnimations();
//                    mStaggeredLayoutManager3.requestSimpleAnimationsInNextLayout();
//                    mStaggeredLayoutManager3.isSmoothScrolling();
//                    lstDocNhieu.setLayoutManager(mStaggeredLayoutManager3);
//                    btnDocNhieu.setText("Thu gọn ...");
//                    viewExpand = false;
//                } else {
//                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//                    layoutManager.requestSimpleAnimationsInNextLayout();
//                    layoutManager.supportsPredictiveItemAnimations();
//                    layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//                    lstDocNhieu.setLayoutManager(layoutManager);
//                    btnDocNhieu.setText("Xem thêm ...");
//                    viewExpand = true;
//                }
//            }
//        });
//
//        MyAsyncTask asyncFavoriteBook = new MyAsyncTask(getActivity(), "LaySachYeuThich");
//        asyncFavoriteBook.execute();
//        favoriteBooks=asyncNewBook.getBooks();
//
//        adapterFavorite = new BookAdapter(getActivity().getApplicationContext(), favoriteBooks);
//        lstNoiBat.setAdapter(adapterFavorite);
    }


    public class MyAsyncTask extends AsyncTask<Void, Book, ArrayList<Book>> {
        final String NAMESPACE = "http://tempuri.org/";
        String METHOD_NAME = "LaySachMoiNhat";
        final String URL = "http://readbook.somee.com/rbservice.asmx?WSDL";
        Activity activity;
        ArrayList<Book> books;

        public MyAsyncTask(Activity activity, String method) {
            this.activity = activity;
            METHOD_NAME = method;
            books = new ArrayList<>();
        }
        public MyAsyncTask(Activity activity) {
            this.activity = activity;
            books = new ArrayList<>();
        }


        @Override
        protected ArrayList<Book> doInBackground(Void... params) {
            try {

                final String SOAP_ACTION = NAMESPACE + METHOD_NAME;
                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
                SoapSerializationEnvelope envelope =
                        new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);
                //Nếu truyền số thực trên mạng
                MarshalFloat marshal = new MarshalFloat();
                marshal.register(envelope);

                HttpTransportSE androidHttpTransport =
                        new HttpTransportSE(URL);
                androidHttpTransport.call(SOAP_ACTION, envelope);
                SoapObject soapArray = (SoapObject) envelope.getResponse();
                for (int i = 0; i < soapArray.getPropertyCount(); i++) {

                    Book book = new Book();
                    SoapObject item = (SoapObject) soapArray.getProperty(i);
                    book.setId(Integer.parseInt(item.getProperty("MaSach").toString()));
                    book.setCategoryID(Integer.parseInt(item.getProperty("MaChuyenMuc").toString()));
                    book.setBookName(item.getPropertyAsString("TenSach"));
                    book.setDescription(item.getPropertyAsString("MoTa"));
                    book.setExtranet(Integer.parseInt(item.getPropertyAsString("MaNhaXuatBan")));
                    book.setAuthor(item.getPropertyAsString("TacGia"));
                    book.setDetail(item.getPropertyAsString("ChiTiet"));
                    book.setView(Integer.parseInt(item.getPropertyAsString("LuotXem")));
                    book.setFavorite(Integer.parseInt(item.getPropertyAsString("YeuThich")));

                    System.out.println("OUT PRINT "+item.getProperty(i));
                    publishProgress(book);
                }

            } catch (Exception e) {
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Book... values) {
            super.onProgressUpdate(values);
            System.out.println(values[0].getBookName());
        }

        @Override
        protected void onPostExecute(ArrayList<Book> books) {
            super.onPostExecute(books);
            this.books = books;
        }

        public ArrayList<Book> getBooks()
        {
            return this.books;
        }
    }
}
