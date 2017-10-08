package info.trongdat.webserviceclient;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lstSach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        lstSach = (ListView) findViewById(R.id.lstSach);
        new MyAsyncTask().execute();
    }

    class MyAsyncTask extends AsyncTask<String, Integer, ArrayList<String>> {
        final String NAMESPACE = "http://tempuri.org/";
        String METHOD_NAME = "LaySachMoiNhat";
        final String URL = "http://appbook.somee.com/rbservice.asmx";
        int bookID;


        @Override
        protected ArrayList<String> doInBackground(String... params) {
            ArrayList<String> list = new ArrayList<>();
            try {
                // khai báo action (tên phương thức).
                final String SOAP_ACTION = NAMESPACE + METHOD_NAME;
                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
                //Thêm tham số cho action( gửi lên server).
                request.addProperty("id", bookID);

                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;
                envelope.setOutputSoapObject(request);
                //Nếu truyền số thực trên mạng
                MarshalFloat marshal = new MarshalFloat();
                marshal.register(envelope);
                // kết nối tới service và gọi action tương ứng.
                HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
                androidHttpTransport.call(SOAP_ACTION, envelope);

                SoapObject response = (SoapObject) envelope.getResponse();
                for (int i = 0; i < response.getPropertyCount(); i++) {
                    SoapObject object = (SoapObject) response.getProperty(i);
                    Log.d("datt", "doInBackground: " + object);

                    String tenSach = object.getProperty("TenSach").toString();
                    list.add(tenSach);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }

            return list;
        }

        @Override
        protected void onPostExecute(ArrayList<String> strings) {
            super.onPostExecute(strings);
            ArrayAdapter arrayAdapter = new
                    ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, strings);
            lstSach.setAdapter(arrayAdapter);
        }
    }

}
