package info.trongdat.accountmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailUserActivity extends AppCompatActivity {
    TextView txtId, txtUser, txtPass, txtName;
    int id;
    User user;
    IServiceUser iServiceUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        txtId = (TextView) findViewById(R.id.txtId);
        txtUser = (TextView) findViewById(R.id.txtUsername);
        txtPass = (TextView) findViewById(R.id.txtPassword);
        txtName = (TextView) findViewById(R.id.txtName);

        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("id");


        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://cd3android.somee.com/").
                addConverterFactory(GsonConverterFactory.create())
                .build();
        iServiceUser = retrofit.create(IServiceUser.class);


        loadData();
    }

    public void loadData() {
        iServiceUser.getUser(id).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                user = response.body();
                txtId.setText(user.getId() + "");
                txtUser.setText(user.getUsername());
                txtPass.setText(user.getPassword());
                txtName.setText(user.getName());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    public void deleteClick(View view) {
        iServiceUser.deleteUser(id).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.body()) {
                    Toast.makeText(DetailUserActivity.this, "Delete succeed", Toast.LENGTH_SHORT).show();
                    finish();
                } else
                    Toast.makeText(DetailUserActivity.this, "Dlete failed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

            }
        });
    }

    public void editClick(View view) {
        startActivity(new Intent(DetailUserActivity.this, EditUserActivity.class).putExtra("user", user));
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }
}
