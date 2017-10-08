package info.trongdat.accountmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddUserActivity extends AppCompatActivity {
    EditText edtUser, edtPass, edtName;
    IServiceUser iServiceUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        edtUser = (EditText) findViewById(R.id.edtUsername);
        edtPass = (EditText) findViewById(R.id.edtPassword);
        edtName = (EditText) findViewById(R.id.edtName);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://cd3android.somee.com/").
                addConverterFactory(GsonConverterFactory.create())
                .build();
        iServiceUser = retrofit.create(IServiceUser.class);
    }

    public void addConfirm(View view) {
        User user = new User(0, edtUser.getText().toString(), edtPass.getText().toString(), edtName.getText().toString());
        iServiceUser.addUser(user).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.body()) {
                    Toast.makeText(AddUserActivity.this, "Create user succeed", Toast.LENGTH_SHORT).show();
                    finish();
                } else
                    Toast.makeText(AddUserActivity.this, "Create user failed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

            }
        });

    }
}
