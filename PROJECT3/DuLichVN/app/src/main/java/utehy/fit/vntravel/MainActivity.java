package utehy.fit.vntravel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import utehy.fit.vntravel.entities.DiaDiem;

public class MainActivity extends AppCompatActivity {
    MyService myService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://hmqdulich.somee.com/").
                addConverterFactory(GsonConverterFactory.create())
                .build();
        myService = retrofit.create(MyService.class);
        myService.layDSDiaDiem(29).enqueue(new Callback<ArrayList<DiaDiem>>() {
            @Override
            public void onResponse(Call<ArrayList<DiaDiem>> call, Response<ArrayList<DiaDiem>> response) {
                Log.d("datttttt", "onResponse: " + response.body().size());
            }

            @Override
            public void onFailure(Call<ArrayList<DiaDiem>> call, Throwable t) {

            }
        });
    }
}
