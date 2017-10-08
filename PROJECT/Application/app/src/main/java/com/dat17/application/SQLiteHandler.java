package com.dat17.application;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Alone on 6/13/2016.
 */
public class SQLiteHandler extends SQLiteOpenHelper {
    Context dbContext;
    SQLiteDatabase db;
    static final String DB_NAME = "db2016.sqlite";
    static final String DB_PATH = "/data/data/com.dat17.application/databases/" + DB_NAME;
    static final int DB_VERSION = 1;


    public SQLiteHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        dbContext = context;
//openDatabase();
    }

    public void openDatabase() {
        if (checkDatabase()) {
            db = SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);
//            Toast.makeText(dbContext, "Open db success!", Toast.LENGTH_SHORT).show();
        } else {
            copyDatabase();
//            Toast.makeText(dbContext, "Copy db success!", Toast.LENGTH_SHORT).show();
        }
    }

    public void closeDatabase() {
        db.close();
    }

    public void execute(String sql) //thuc thi cau lenh sql
    {
        openDatabase();
        db.execSQL(sql);
        closeDatabase();
    }

    public Cursor executeQuery(String sql) // truy van du lieu
    {
        openDatabase();
        return db.rawQuery(sql, null);
    }

    public boolean checkDatabase() {
        File fdb = new File(DB_PATH);
        if (fdb.exists()) return true;
        return false;
    }

    public void copyDatabase() {
        this.db = getReadableDatabase();

        try {
            InputStream inputStream = dbContext.getAssets().open(DB_NAME);
            OutputStream outputStream = new FileOutputStream(DB_PATH);
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

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
