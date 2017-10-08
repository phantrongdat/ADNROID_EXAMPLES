package info.trongdat.accountmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EditUserActivity extends AppCompatActivity {
    User user;
    EditText edtUser, edtPass, edtName;
    TextView txtId;
    IServiceUser iServiceUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        Bundle bundle = getIntent().getExtras();
        user = (User) bundle.getSerializable("user");

        txtId = (TextView) findViewById(R.id.txtId);
        edtUser = (EditText) findViewById(R.id.edtUsername);
        edtPass = (EditText) findViewById(R.id.edtPassword);
        edtName = (EditText) findViewById(R.id.edtName);

        txtId.setText(user.getId() + "");
        edtUser.setText(user.getUsername());
        edtPass.setText(user.getPassword());
        edtName.setText(user.getName());

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://cd3android.somee.com/").
                addConverterFactory(GsonConverterFactory.create())
                .build();
        iServiceUser = retrofit.create(IServiceUser.class);
    }

    public void updateConfirm(View view) {
        User newUser = new User(user.getId(), edtUser.getText().toString(), edtPass.getText().toString(), edtName.getText().toString());
        iServiceUser.updateUser(user.getId(), newUser).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.body()) {
                    Toast.makeText(EditUserActivity.this, "Update succeed", Toast.LENGTH_SHORT).show();
                    finish();
                } else
                    Toast.makeText(EditUserActivity.this, "Update failed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

            }
        });
    }

}