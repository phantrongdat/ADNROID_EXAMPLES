package com.example.alone.sqlitecreate;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Alone on 03/10/2016.
 */
public class MyDatabase extends SQLiteOpenHelper {
    public MyDatabase(Context context) {
        super(context, "database_account.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//          queryData("CREATE TABLE IF NOT EXISTS Account(user varchar(100) PRIMARY KEY,password varchar(100) NOT NULL)");
//          queryData("INSERT INTO Account VALUES('admin','123456')");
    }

    public Cursor getData(String sql) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery(sql, null);
        return c;
    }

    public void queryData(String sql) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public boolean isExists(String user) {
        Cursor c = getData("SELECT*FROM Account WHERE user='"+user+"'");
        if (c.getCount()!=0) return true;
        return false;
    }
//    public boolean isExists(String user) {
//        Cursor c = getData("SELECT*FROM Account");
//        while (c.moveToNext()) {
//            if (user.equalsIgnoreCase(c.getString(0)))
//                return true;
//        }
//        return false;
//    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
