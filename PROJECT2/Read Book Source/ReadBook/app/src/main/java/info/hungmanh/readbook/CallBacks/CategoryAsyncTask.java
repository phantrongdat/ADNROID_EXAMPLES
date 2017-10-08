package info.hungmanh.readbook.CallBacks;

import android.os.AsyncTask;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

import info.hungmanh.readbook.Entities.Category;

/**
 * Created by Alone on 10/22/2016.
 */

public class CategoryAsyncTask extends AsyncTask<Void, Category, ArrayList<Category>> {
    private CategoryLoadListener myLoad;

    final String NAMESPACE = "http://tempuri.org/";
    String METHOD_NAME = "";
    final String URL = "http://readbook.somee.com/rbservice.asmx";
    ArrayList<Category> categories;

    public CategoryAsyncTask(CategoryLoadListener myComponent, String method) {
        this.myLoad = myComponent;
        METHOD_NAME = method;
        categories = new ArrayList<>();
    }




    @Override
    protected ArrayList<Category> doInBackground(Void... params) {
        ArrayList<Category> list = new ArrayList<>();

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

                Category category = new Category();
                SoapObject item = (SoapObject) soapArray.getProperty(i);
                category.setCateName(item.getProperty("TenChuyenMuc").toString());
                category.setId(Integer.parseInt(item.getProperty("MaChuyenMuc").toString()));
                categories.add(category);
//                Log.e("v1",category.getCateName());

            }

            return list;
        } catch (Exception e) {
            return list;
        }

    }

    @Override
    protected void onPostExecute(ArrayList<Category> books) {
        super.onPostExecute(books);
        if (myLoad != null) {
            myLoad.CategoryLoadListener(categories);
        }
    }
}