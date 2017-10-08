package com.example.alone.sqlitecreate;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    MyDatabase mydb = new MyDatabase(this);
    EditText user, password;
    Button login;
    CheckBox cbLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb.queryData("CREATE TABLE IF NOT EXISTS Account(user varchar(100) PRIMARY KEY,password varchar(100) NOT NULL)");
        if (!mydb.isExists("admin")) {
            mydb.queryData("INSERT INTO  Account VALUES('admin','admin')");
        }
        user = (EditText) findViewById(R.id.edtUser);
        password = (EditText) findViewById(R.id.edtPassword);
        cbLogin = (CheckBox) findViewById(R.id.cbLogin);

        login = (Button) findViewById(R.id.btLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check()) {
                    Toast.makeText(MainActivity.this, "Dang nhap thanh cong !", Toast.LENGTH_SHORT).show();
                    if (!cbLogin.isChecked()) {
                        user.setText("");
                        password.setText("");
                    }
                    Intent ok = new Intent(MainActivity.this, AccountManagement.class);
                    startActivity(ok);
                } else {
                    AlertDialog.Builder al = new AlertDialog.Builder(MainActivity.this);
                    al.setTitle("Error !");
                    al.setMessage("Tai khoan hoac mat khau khong chinh xac !");
                    al.create().show();
                }
            }
        });
    }

    public boolean check() {
        String tk = user.getText().toString();
        String mk = password.getText().toString();
        Cursor c = mydb.getData("SELECT*FROM Account");
        while (c.moveToNext()) {
            if (tk.equalsIgnoreCase(c.getString(0)) && mk.equals(c.getString(1))) return true;
        }
        return false;
    }

}
