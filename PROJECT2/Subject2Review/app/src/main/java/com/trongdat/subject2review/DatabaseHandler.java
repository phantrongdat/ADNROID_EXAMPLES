package com.trongdat.subject2review;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Alone on 12/27/2016.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    Context context;
    SQLiteDatabase db;
    static final String DBPATH = "data/data/com.trongdat.subject2review/databases/";
    private static final String DBNAME = "data1.sqlite";

    public DatabaseHandler(Context context) {
        super(context, DBNAME, null, 1);
        this.context = context;
    }

    public void openDB() {
        File file = new File(DBPATH + DBNAME);
        if (file.exists()) {
            db = SQLiteDatabase.openDatabase(DBPATH + DBNAME, null, SQLiteDatabase.OPEN_READWRITE);
        } else {
            copyDB();
        }
    }

    public void copyDB() {
        try {
            this.getReadableDatabase();
            InputStream inputStream = context.getAssets().open(DBNAME);
            OutputStream outputStream = new FileOutputStream(DBPATH + DBNAME);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            inputStream.close();
            outputStream.flush();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeDB() {
        db.close();
    }

    public void executeQuery(String sql) {
        openDB();
        db.execSQL(sql);
        closeDB();
    }

    public Cursor rawQuery(String sql) {
        openDB();
        return db.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
