package info.trongdat.sharedreferencesexample;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    TextView txtUser;
    Button btnLogout;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String USERNAME_KEY = "user", PASSWORD_KEY = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sharedPreferences = getSharedPreferences("loginExample", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        txtUser = (TextView) findViewById(R.id.txtUser);
        btnLogout = (Button) findViewById(R.id.btnLogout);

        txtUser.setText("Hi ! " + sharedPreferences.getString(USERNAME_KEY, "null"));

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString(USERNAME_KEY, "");
                editor.putString(PASSWORD_KEY, "");
                editor.commit();
                finish();
            }
        });
    }
}
