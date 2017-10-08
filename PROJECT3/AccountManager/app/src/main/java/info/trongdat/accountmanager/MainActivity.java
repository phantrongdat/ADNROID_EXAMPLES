package info.trongdat.accountmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ListView lstAccount;
    ArrayList<User> list;
    IServiceUser iServiceUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstAccount = (ListView) findViewById(R.id.lstAccount);
        lstAccount.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailUserActivity.class);
                intent.putExtra("id", list.get(position).getId());
                startActivity(intent);
            }
        });

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://cd3android.somee.com/").
                addConverterFactory(GsonConverterFactory.create())
                .build();

        iServiceUser = retrofit.create(IServiceUser.class);
        loadData();
    }

    public void loadData() {
        iServiceUser.getUsers().enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                list=response.body();
                ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1, list);
                lstAccount.setAdapter(arrayAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {

            }
        });
    }

    public void addClick(View view) {
        startActivity(new Intent(MainActivity.this, AddUserActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }
}
