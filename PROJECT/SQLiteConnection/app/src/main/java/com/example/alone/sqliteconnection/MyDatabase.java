package com.example.alone.sqliteconnection;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Alone on 04/07/2016.
 */
public class MyDatabase extends SQLiteOpenHelper {
    SQLiteDatabase db = null;
    Context dbContext = null;
    static String dbName = "DBTest.db";
    static String dbPath = "/data/data/com.example.alone.sqliteconnection/databases/";
    static int dbVersion = 1;
    String path = dbPath + dbName;

    public MyDatabase(Context context) {
        super(context, dbName, null, dbVersion);
        dbContext = context;
        openDB();
    }

    //    public boolean checkDB() {
//        SQLiteDatabase check = null;
//
//        try {
//            check = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
//        } catch (SQLiteException e) {
//            e.printStackTrace();
//        }
//
//        if (check != null) check.close();
//        return check == null ? false : true;
//    }
    public boolean checkDB() {
        File fcheck = new File(path);
        if (fcheck.exists()) return true;
        else return false;
    }

    public void copyDB() {
        try {
            InputStream inputStream = dbContext.getAssets().open(dbName);
            OutputStream outputStream = new FileOutputStream(new File(path));

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openDB() {
        if (checkDB()) {
            db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
            Toast.makeText(dbContext, "Open Database successfuly !", Toast.LENGTH_LONG).show();
        } else {
//            this.getReadableDatabase();
            copyDB();
            Toast.makeText(dbContext, "Copy database successfuly ! !", Toast.LENGTH_LONG).show();
        }
    }

    public Cursor getData(String sql) {
        Cursor c = null;
        try {
            c = db.rawQuery(sql, null);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
