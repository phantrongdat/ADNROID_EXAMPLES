package info.trongdat.retrofilexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView lstTaiKhoan;
    ArrayList<ThongTinTaiKhoan> list;
    ArrayAdapter<ThongTinTaiKhoan> adapter;
    MyService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Tạo đối tượng Retrofit và cấu hình.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://demoapp.somee.com")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                //GsonConverterFactory.create() nếu dữ liệu dạng JSON.
                .build();
        service = retrofit.create(MyService.class);

        lstTaiKhoan = (ListView) findViewById(R.id.lstTaiKhoan);
        layDSTK();
    }

    public void layDSTK() {
        // Gọi method getListTK() và xử lý dữ liệu response sau callback.
        service.getListTK().enqueue(new Callback<List<ThongTinTaiKhoan>>() {
            @Override
            public void onResponse(Call<List<ThongTinTaiKhoan>> call, Response<List<ThongTinTaiKhoan>> response) {
//                Log.v("s", call.request().url() + "");
                list.addAll(response.body());
                adapter = new ArrayAdapter<ThongTinTaiKhoan>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, list);
                lstTaiKhoan.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ThongTinTaiKhoan>> call, Throwable t) {

            }
        });
    }
}
