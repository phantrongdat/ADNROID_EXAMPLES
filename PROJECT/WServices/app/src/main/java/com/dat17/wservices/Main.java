package com.dat17.wservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class Main extends AppCompatActivity implements View.OnClickListener,AsyncResponse {
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("SIGN IN");


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main.this, Register.class));
            }
        });
        mEmailView = (AutoCompleteTextView) findViewById(R.id.edtUsername);

        mPasswordView = (EditText) findViewById(R.id.edtPassword);

        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {

                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String username = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
//
        HashMap dataPost=new HashMap();
        dataPost.put("action","login");
        dataPost.put("edtUsername",username);
        dataPost.put("edtPassword",password);

        PostResponseAsyncTask asyncTask=new PostResponseAsyncTask(this, dataPost);
        asyncTask.execute("http://devmobile.club/services/index.php");
    }
    @Override
    public void processFinish(String s) {
//        Toast.makeText(Main.this, s+"", Toast.LENGTH_SHORT).show();
        if (s.equals("login_success")) {
            Toast.makeText(Main.this, "Login Success", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(Main.this,AccountList.class);
            intent.putExtra("username",mEmailView.getText().toString());
            startActivity(intent);
        }else {
            Toast.makeText(Main.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
        }
    }

}
