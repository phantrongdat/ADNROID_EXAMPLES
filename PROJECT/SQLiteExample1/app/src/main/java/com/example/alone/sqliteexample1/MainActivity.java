package com.example.alone.sqliteexample1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

public class MainActivity extends ActionBarActivity {
    private MyDatabase mdb=new MyDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdb.queryData("CREATE TABLE IF NOT EXISTS Sinhvien" +
                "(maSV INT PRIMARY KEY AUTOINCREMENT,hoTen NVARCHAR(50),diaChi NVARCHAR(50),soDT VARCHAR(10),eMail NVARCHAR(50)");

    }
}
