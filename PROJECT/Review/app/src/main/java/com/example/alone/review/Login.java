package com.example.alone.review;

import android.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Login extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View v)
    {
        EditText edtUser,edtPassword;
        edtUser=(EditText)findViewById(R.id.edtUser);
        edtPassword=(EditText)findViewById(R.id.edtPass);

        String user=edtUser.getText().toString();
        String password=edtPassword.getText().toString();


        if (user.equalsIgnoreCase("utehy")&&password.equals("fit"))
        {
            AlertDialog.Builder al=new AlertDialog.Builder(this);
            al.setTitle("Login");
            al.setMessage("Dang nhap thanh cong!").create().show();
        }

    }
}
