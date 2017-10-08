package info.hungmanh.readbook.CallBacks;

import android.os.AsyncTask;
import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

import info.hungmanh.readbook.Entities.Chapter;

/**
 * Created by Alone on 10/22/2016.
 */

public class ChapterAsyncTask extends AsyncTask<Void, Chapter, ArrayList<Chapter>> {
    private ChapterLoadListener myLoad;

    final String NAMESPACE = "http://tempuri.org/";
    String METHOD_NAME = "";
    final String URL = "http://readbook.somee.com/rbservice.asmx";

    int bookID;

    public ChapterAsyncTask(ChapterLoadListener myComponent, String method, int id) {
        this.myLoad = myComponent;
        METHOD_NAME = method;
        bookID = id;
    }

    @Override
    protected ArrayList<Chapter> doInBackground(Void... params) {
        ArrayList<Chapter> list = new ArrayList<>();

        try {

            final String SOAP_ACTION = NAMESPACE + METHOD_NAME;
            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            request.addProperty("id", bookID);
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

                Chapter chapter = new Chapter();
                SoapObject item = (SoapObject) soapArray.getProperty(i);
                chapter.setBookID(bookID);
                chapter.setId(Integer.parseInt(item.getProperty("MaChuong").toString()));
                chapter.setChapName(item.getProperty("TenChuong").toString());
                chapter.setDetail(item.getProperty("ChiTiet").toString());
                Log.v("chapter", chapter.getChapName());
                list.add(chapter);

            }

            return list;
        } catch (Exception e) {
            return list;
        }

    }

    @Override
    protected void onPostExecute(ArrayList<Chapter> chapters) {
        super.onPostExecute(chapters);
        if (myLoad != null) {
            myLoad.ChapterLoadListener(chapters);
        }
    }
}