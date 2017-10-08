package com.example.alone.sqliteexample;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Alone on 03/07/2016.
 */
public class MyDatabase extends SQLiteOpenHelper {
    private Context dbContext;
    private SQLiteDatabase db;
    private static final String dbPath = "data/data/com.example.alone.sqliteexample/databases/database_account.sqlite";
    private static final String dbName = "database_account.sqlite";
    private static final int dbVersion = 1;

    // Khoi tao database
    public MyDatabase(Context context) {
        super(context, dbName, null, dbVersion);
        this.dbContext = context;
    }


    // Mo database
    public void opendDB() {
        db = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    // Dong database
    public void closeDB() {
        db.close();
    }

    // Copy database sang sdcard .neu co roi thi thoi
    public void copyDB() throws IOException {
        InputStream inputStream = dbContext.getAssets().open("database_account.sqlite");
        String outFileName = dbPath;
        OutputStream outputStream = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }

    public void copyDB2SDCard() {
        try {
            SQLiteDatabase check = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
            if (check != null) check.close();
            else {
                copyDB();
            }
        } catch (Exception e) {
            throw new Error("Error !");
        }
    }

    // Thuc thi cac cau lenh
    public void excuteDB(String sql) {
        opendDB();
        db.execSQL(sql);
        closeDB();
    }

    public Cursor getCursor(String sql) {
        opendDB();
        return db.rawQuery(sql, null);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
