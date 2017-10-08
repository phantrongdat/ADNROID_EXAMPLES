package info.trongdat.webserviceexample;

import android.os.AsyncTask;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.Date;

/**
 * Created by Alone on 3/21/2017.
 */

public class MyAsyncTask extends AsyncTask<Void, ThongTinTaiKhoan, ThongTinTaiKhoan> {

    private TaiKhoanListener myLoad;
    final String NAMESPACE = "http://tempuri.org/";
    final String METHOD_NAME = "getThongTinTaiKhoanbyTenTK";
    final String URL = "http://appdemo.somee.com/webservice.asmx";
    ThongTinTaiKhoan thongTinTaiKhoan;
    String tenTK;

    // TaiKhoanListener: callback nhằm xử lý sau khi thực hiện asynctask.
    // method: action gửi lên server.
    // tenTK: gửi lên server và lấy các thông tin của tài khoản.

    public MyAsyncTask(TaiKhoanListener myComponent, String tenTK) {
        this.myLoad = myComponent;
        this.tenTK = tenTK;
        thongTinTaiKhoan = new ThongTinTaiKhoan();
    }

    @Override
    protected ThongTinTaiKhoan doInBackground(Void... params) {
        try {
            // khai báo action (tên phương thức).
            final String SOAP_ACTION = NAMESPACE + METHOD_NAME;
            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            //Thêm tham số cho action( gửi lên server).
            request.addProperty("tenTK", tenTK);

            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.dotNet = true;
            envelope.setOutputSoapObject(request);
            //Nếu truyền số thực trên mạng
            MarshalFloat marshal = new MarshalFloat();
            marshal.register(envelope);
            // kết nối tới service và gọi action tương ứng.
            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.call(SOAP_ACTION, envelope);

            //lấy dữ liệu được hồi đáp từ server và xử lý object.
            SoapObject soapArray = (SoapObject) envelope.getResponse();
            for (int i = 0; i < soapArray.getPropertyCount(); i++) {

                SoapObject item = (SoapObject) soapArray.getProperty(i);
                thongTinTaiKhoan.setTenTK(item.getProperty("TenTK").toString());
                thongTinTaiKhoan.setHoTen(item.getProperty("HoTen").toString());
                thongTinTaiKhoan.setGioiTinh(Boolean.parseBoolean(item.getProperty("GioiTinh").toString()));
                thongTinTaiKhoan.setNgaySinh(new Date(item.getProperty("NgaySinh").toString()));
                thongTinTaiKhoan.setDiaChi(item.getProperty("DiaChi").toString());
                thongTinTaiKhoan.setEmail(item.getProperty("Email").toString());
                thongTinTaiKhoan.setSoDienThoai(item.getProperty("SoDT").toString());
            }
            return thongTinTaiKhoan;
        } catch (Exception e) {
            e.printStackTrace();
            return thongTinTaiKhoan;
        }
    }


    @Override
    protected void onPostExecute(ThongTinTaiKhoan thongTinTaiKhoan) {
        super.onPostExecute(thongTinTaiKhoan);
        if (myLoad != null) {
            myLoad.TaiKhoanListener(thongTinTaiKhoan);
        }
    }
}