package info.trongdat.ksoap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arrayList=new ArrayList<>();
    final String NAMESPACE="http://tempuri.org/";
    final String METHOD_NAME="LayChuyenMuc";
    final String URL="http://readbook.somee.com/rbservice.asmx";
    final String SOAP_ACTION=NAMESPACE+METHOD_NAME;
    TextView txtCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCount=(TextView) findViewById(R.id.txtCount);


        helloSoap();
    }


    public void helloSoap()
    {
        // Tạo đối tượng Soap
        SoapObject soapObject=new SoapObject(NAMESPACE,METHOD_NAME);
        // Thiết lập version
        SoapSerializationEnvelope envelope=new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet=true;
        // Thiết lập output
        envelope.setOutputSoapObject(soapObject);

        MarshalFloat marshalFloat=new MarshalFloat();
        marshalFloat.register(envelope);

        // Tạo đối tượng Transport SE
        HttpTransportSE httpTransportSE=new HttpTransportSE(URL);


        try {
            // Gọi service
            httpTransportSE.call(SOAP_ACTION,envelope);

            // Lấy kết quả trả về

            SoapObject soapObject1=(SoapObject) envelope.getResponse();

            // Hiển thị dữ liệu
            for (int i=0; i<soapObject1.getPropertyCount();i++)
            {
                arrayList.add(soapObject1.getProperty("MaChuyenMuc").toString()+"-"+soapObject1.getProperty("TenChuyenMuc").toString());
            }
            txtCount.setText(arrayList.get(0));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

    }
}
