package info.hungmanh.readbook.CallBacks;

import android.os.AsyncTask;
import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

import info.hungmanh.readbook.Entities.Book;

/**
 * Created by Alone on 10/22/2016.
 */

public class BookAsyncTask extends AsyncTask<Void, Book, ArrayList<Book>> {

    private BookLoadListener myLoad;
    final String NAMESPACE = "http://tempuri.org/";
    String METHOD_NAME = "";
    final String URL = "http://readbook.somee.com/rbservice.asmx";
    ArrayList<Book> books;
    int bookID;

    public BookAsyncTask(BookLoadListener myComponent, String method, int id) {
        this.myLoad = myComponent;
        METHOD_NAME = method;
        bookID = id;
        books = new ArrayList<>();
    }


    @Override
    protected ArrayList<Book> doInBackground(Void... params) {
        ArrayList<Book> list = new ArrayList<>();
        try {
            final String SOAP_ACTION = NAMESPACE + METHOD_NAME;
            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            request.addProperty("id", bookID);
            SoapSerializationEnvelope envelope =  new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            //Nếu truyền số thực trên mạng
            MarshalFloat marshal = new MarshalFloat();
            marshal.register(envelope);
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
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
            e.printStackTrace(); return list;
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

