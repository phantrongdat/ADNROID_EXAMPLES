package info.trongdat.accountmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private EditText edtPassword, edtUsername;
    IServiceUser iServiceUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://cd3android.somee.com/").
                addConverterFactory(GsonConverterFactory.create())
                .build();
        iServiceUser = retrofit.create(IServiceUser.class);
    }

    public void loginClick(View view) {
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();
        iServiceUser.checkUser(username, password).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.body()) {
                    Toast.makeText(LoginActivity.this, "Login succeed", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                } else
                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

            }
        });
    }

}

