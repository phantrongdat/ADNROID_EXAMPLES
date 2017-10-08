package net.trongdat.restart.view;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.trongdat.restart.R;
import net.trongdat.restart.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {

ActivityLoginBinding loginBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
        loginBinding= DataBindingUtil.setContentView(this,R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setSubtitle("Project Request System");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        final Button btnLogin=loginBinding.contentLogin.btnLogin;

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLogin.setAlpha(0.56f);
                String user=loginBinding.contentLogin.edtUsername.getText().toString();
                String pass=loginBinding.contentLogin.edtPassword.getText().toString();

                if (user.equalsIgnoreCase("dat")&&pass.equals("123")) {
                    Toast.makeText(getApplicationContext(), "Login Success!", Toast.LENGTH_LONG).show();
                    finish();
                }
                else
                    Toast.makeText(getApplicationContext(),"Username or Passord is not Correct!",Toast.LENGTH_LONG).show();
            }
        });

    }
}
