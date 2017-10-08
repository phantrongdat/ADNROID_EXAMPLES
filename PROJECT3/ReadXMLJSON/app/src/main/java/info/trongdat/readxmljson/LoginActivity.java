package info.trongdat.readxmljson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import static info.trongdat.readxmljson.Constants.ACCOUNT_DATA;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private EditText edtPassword, edtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);

    }

    public void loginClick(View view) {
        String user = edtUsername.getText().toString();
        String pass = edtPassword.getText().toString();

        if (login(user, pass)) {
            Toast.makeText(this, "Login success!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        } else Toast.makeText(this, "Login error!", Toast.LENGTH_SHORT).show();
    }

    public boolean login(String user, String pass) {
        try {
            String data = readJSONFromAsset(ACCOUNT_DATA);
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = (JSONObject) jsonArray.get(i);
                String u = object.getString("Username");
                String p = object.getString("Password");
                if (user.equalsIgnoreCase(u) && pass.equals(p)) return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public String readJSONFromAsset(String data) {
        String json = null;
        try {
            InputStream is = getAssets().open(data);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}

