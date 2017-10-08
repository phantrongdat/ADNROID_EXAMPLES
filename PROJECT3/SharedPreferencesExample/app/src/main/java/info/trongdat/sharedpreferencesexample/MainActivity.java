package info.trongdat.sharedpreferencesexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUser, edtPass;
    CheckBox cbxRemember;
    Button btnLogin;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String USERNAME_KEY = "user", PASSWORD_KEY = "password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("loginExample", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        initialize();

    }

    public void initialize() {
        edtUser = (EditText) findViewById(R.id.edtUsername);
        edtPass = (EditText) findViewById(R.id.edtPassword);
        cbxRemember = (CheckBox) findViewById(R.id.cbxRemember);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        String session = sharedPreferences.getString(USERNAME_KEY, "");
        if (!session.equals("")) startActivity(new Intent(MainActivity.this, Home.class));

//        edtUser.setText(sharedPreferences.getString(USERNAME_KEY, ""));
//        edtPass.setText(sharedPreferences.getString(PASSWORD_KEY, ""));
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginClick();
            }
        });
    }


    public void loginClick() {
        String user = edtUser.getText().toString();
        String pass = edtPass.getText().toString();
        if (user.equals("alone") && pass.equals("123456")) {
            Toast.makeText(this, "Login success!", Toast.LENGTH_SHORT).show();
            if (cbxRemember.isChecked()) {
                editor.putString(USERNAME_KEY, user.trim());
                editor.putString(PASSWORD_KEY, pass.trim());
                editor.commit();
            }

            startActivity(new Intent(MainActivity.this, Home.class));

            edtUser.setText("");
            edtPass.setText("");

        } else
            Toast.makeText(this, "Username or password is not correct!", Toast.LENGTH_SHORT).show();
    }

}
