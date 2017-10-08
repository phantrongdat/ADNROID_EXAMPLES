package info.hungmanh.readbook;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

import info.hungmanh.readbook.Adapters.BookAdapter;
import info.hungmanh.readbook.CallBacks.BookLoadListener;
import info.hungmanh.readbook.Entities.Book;

public class Search extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

    private RecyclerView lstBook;
    private ArrayList<Book> books;
    private BookAdapter adapter;
    ActionBar actionBar;
    String query;
    TextView txtResult;

    private SwipeRefreshLayout mSwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Tìm kiếm");
        initialize();

        Bundle bundle = getIntent().getExtras();
        query = bundle.getString("data");
        search(query);

    }

    public void initialize() {
        txtResult=(TextView)findViewById(R.id.txtResult);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.mswip);
        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(android.R.color.holo_blue_dark),getResources().getColor(android.R.color.holo_green_light), getResources().getColor(android.R.color.holo_orange_light),getResources().getColor(android.R.color.holo_red_light));

        StaggeredGridLayoutManager mStaggeredLayoutManager1 = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mStaggeredLayoutManager1.supportsPredictiveItemAnimations();
        mStaggeredLayoutManager1.requestSimpleAnimationsInNextLayout();
        mStaggeredLayoutManager1.isSmoothScrolling();

        lstBook = (RecyclerView) findViewById(R.id.lstBook);
        lstBook.setLayoutManager(mStaggeredLayoutManager1);
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        });
        mSwipeRefreshLayout.setOnRefreshListener(this);

    }

    public void search(String query) {
        txtResult.setText("Kết quả cho: "+query);
        SearchAsyncTask asyncNewBook = new SearchAsyncTask(new BookLoadListener() {
            @Override
            public void BookLoadListener(ArrayList<Book> listtintuc) {
                if (mSwipeRefreshLayout.isRefreshing()) {
                    mSwipeRefreshLayout.setRefreshing(false);
                }
                books = listtintuc;
                adapter = new BookAdapter(getApplicationContext(), listtintuc);
                lstBook.setAdapter(adapter);
            }
        }, "TimKiemSach", query);
        asyncNewBook.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.Search));
        searchView.setIconifiedByDefault(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (!query.equals(""))
                search(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!newText.equals(""))
                search(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onRefresh() {
        initialize();
    }

    public class SearchAsyncTask extends AsyncTask<Void, Book, ArrayList<Book>> {
        private BookLoadListener myLoad;

        final String NAMESPACE = "http://tempuri.org/";
        String METHOD_NAME = "";
        final String URL = "http://readbook.somee.com/rbservice.asmx";
        ArrayList<Book> books;
        String textQuery;

        public SearchAsyncTask(BookLoadListener myComponent, String method, String text) {
            this.myLoad = myComponent;
            METHOD_NAME = method;
            textQuery = text;
            books = new ArrayList<>();

        }

        @Override
        protected ArrayList<Book> doInBackground(Void... params) {
            ArrayList<Book> list = new ArrayList<>();

            try {

                final String SOAP_ACTION = NAMESPACE + METHOD_NAME;
                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
                request.addProperty("text", textQuery);
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
                    book.setBookName(item.getProperty("TenSach").toString());
                    book.setImageName(item.getProperty("AnhDaiDien").toString());
                    book.setDescription(item.getProperty("MoTa").toString());
                    book.setExtranet(Integer.parseInt(item.getProperty("MaNhaXuatBan").toString()));

                    book.setAuthor(item.getProperty("TacGia").toString());
                    //  book.setDetail(item.getProperty("ChiTiet").toString());
                    book.setView(Integer.parseInt(item.getProperty("LuotXem").toString()));
                    book.setFavorite(Integer.parseInt(item.getProperty("YeuThich").toString()));
                    Log.v("book", book.getBookName());
                    list.add(book);

                }

                return list;
            } catch (Exception e) {
                return list;
            }

        }

        @Override
        protected void onPostExecute(ArrayList<Book> books) {
            super.onPostExecute(books);
            if (myLoad != null) {
                myLoad.BookLoadListener(books);
            }
        }
    }
}
