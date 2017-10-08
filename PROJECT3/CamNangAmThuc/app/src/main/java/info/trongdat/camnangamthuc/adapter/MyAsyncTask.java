package info.trongdat.camnangamthuc.adapter;

import android.os.AsyncTask;
import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

import info.trongdat.camnangamthuc.model.MonAn;

/**
 * Created by Alone on 4/24/2017.
 */

public class MyAsyncTask extends AsyncTask<String, Integer, ArrayList<MonAn>> {
    MonAnLoadListener listener;
    private String method;
    private int idTheLoai;
    final String NAMESPACE = "http://tempuri.org/";
    //    final String METHOD_NAME = "layDSMonAn";
    final String URL = "http://cd3android.somee.com/wservice.asmx";

    public MyAsyncTask(MonAnLoadListener listener, String method, int idTheLoai) {
        this.listener = listener;
        this.method = method;
        this.idTheLoai = idTheLoai;
    }

    @Override
    protected ArrayList<MonAn> doInBackground(String... params) {
        ArrayList<MonAn> list = new ArrayList<>();

        try {
            // khai báo action (tên phương thức).
            final String SOAP_ACTION = NAMESPACE + method;
            SoapObject request = new SoapObject(NAMESPACE, method);
            //Thêm tham số cho action( gửi lên server).
            request.addProperty("idTheLoai", idTheLoai);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            //Nếu truyền số thực trên mạng
            MarshalFloat marshal = new MarshalFloat();
            marshal.register(envelope);
            // kết nối tới service và gọi action tương ứng.
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.call(SOAP_ACTION, envelope);
            Log.d("datt", "doInBackground: " + SOAP_ACTION);
            Log.d("datt", "doInBackground: " + envelope.getResponse());

            SoapObject soapArray = (SoapObject) envelope.getResponse();
            Log.d("datt", "doInBackground: " + SOAP_ACTION + "\n" + soapArray);
            for (int i = 0; i < soapArray.getPropertyCount(); i++) {
                MonAn monAn = new MonAn();
                SoapObject soapItem = (SoapObject) soapArray.getProperty(i);

                monAn.setId(Integer.parseInt(soapItem.getProperty("id").toString()));
                monAn.setTen(soapItem.getProperty("ten").toString());
                monAn.setAnh(soapItem.getProperty("anh").toString());
                monAn.setChiTiet(soapItem.getProperty("chiTiet").toString());
                monAn.setLink(soapItem.getProperty("link").toString());

                list.add(monAn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    protected void onPostExecute(ArrayList<MonAn> list) {
        super.onPostExecute(list);
        listener.monAnLoadListener(list);
    }
}